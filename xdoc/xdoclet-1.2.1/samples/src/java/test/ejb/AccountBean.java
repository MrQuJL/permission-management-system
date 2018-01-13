package test.ejb;

import test.interfaces.Account;
import test.interfaces.AccountData;
import test.interfaces.AccountPK;
import test.interfaces.AccountValue;
import test.interfaces.Customer;

import javax.ejb.*;
import java.util.Date;

/**
 * This is an account bean. It is an example of how to use the XDoclet tags.
 * There are several jboss tags that cannot be used together: autoincrement and unknown-pk for instance.
 *
 * @ejb.bean
 *     name="Account"
 *     jndi-name="ejb/bank/Account"
 *
 * @ejb.finder
 *     signature="Collection findAll()"
 *     transaction-type="NotSupported"
 *     unchecked="true"
 *
 * @ejb.finder
 *     signature="Collection findByOwner(test.interfaces.Customer owner)"
 *     role-name="Teller"
 *     transaction-type="Supports"
 *
 * @ejb.finder
 *     signature="Collection findLargeAccounts(int balance)"
 *     role-name="Teller,IRS"
 *
 * @ejb.interface
 *     remote-class="test.interfaces.Account"
 *
 * @ejb.persistence
 *     table-name="acct"
 *
 * @jboss.create-table "${jboss.create.table}"
 * @jboss.remove-table "${jboss.remove.table}"
 * @jboss.tuned-updates "${jboss.tuned.updates}"
 * @jboss.read-only "${jboss.read.only}"
 *
 * @jboss.finder-query
 *     name="findLargeAccounts"
 *     order="balance"
 *     query="$1 > 1000"
 *     read-ahead="true"
 *
 * @jboss.unknown-pk
 *   class="java.lang.Integer"
 *   column-name="generated_id"
 *   jdbc-type="INTEGER"
 *   sql-type="INTEGER"
 *   auto-increment="true"
 * @jboss.entity-command
 *   name="pk-sql"
 * @jboss.entity-command-attribute
 *   name="pk-sql"
 *   value="SELECT SEQ_ACCOUNT.nextval FROM DUAL"
 * @jboss.optimistic-locking
 *   key-generator-factory="java:/keygenererator"
 *   field-type="java.lang.Integer"
 *   field-name="Id"
 *   column-name="ID"
 *   jdbc-type="INTEGER"
 *   sql-type="DECIMAL(18)"
 *
 * @jboss.audit-created-by
 *   field-name="createdBy"
 *   column-name="CREATED_BY"
 *   jdbc-type="VARCHAR"
 *   sql-type="VARCHAR(128)"
 * @jboss.audit-created-time
 *   field-name="createdTime"
 *   column-name="CREATED_TIMESTAMP"
 *   jdbc-type="TIMESTAMP"
 *   sql-type="TIMESTAMP"
 * @jboss.audit-updated-by
 *   field-name="updatedBy"
 *   column-name="UPDATED_BY"
 *   jdbc-type="VARCHAR"
 *   sql-type="VARCHAR(128)"
 * @jboss.audit-updated-time
 *   field-name="updatedTime"
 *   column-name="UPDATED_TIME"
 *   jdbc-type="TIMESTAMP"
 *   sql-type="TIMESTAMP"
 *
 * @weblogic.data-source-name xdoclet.database
 *
 * @ejb.value-object
 *     match="*"
 *     name="Account"
 *
 * @jonas.bean
 *     ejb-name="Account"
 *     jndi-name="AccountHome"
 * @jonas.jdbc-mapping
 *     jndi-name="jdbc_1"
 *     jdbc-table-name="acct"
 * @jonas.finder-method-jdbc-mapping
 *     method-name="findAll"
 *     jdbc-where-clause=""
 * @jonas.finder-method-jdbc-mapping
 *     method-name="findLargeAccounts"
 *     jdbc-where-clause="c_balance > 1000"
 *
 * @version $Revision: 1.14 $
 * @author  <a href="mailto:youremail@yourdomain.com">youremail@yourdomain.com</a>
 */
public abstract class AccountBean extends BaseEntityBean implements EntityBean {
    /**
     * Id of this account. This is not remote since the primary key can be extracted by other means.
     *
     * @ejb.pk-field
     * @ejb.persistent-field
     * @ejb.interface-method
     *
     * @ejb.persistence column-name="account_id"
     *
     * @jboss.auto-increment
     *
     * @jonas.cmp-field-jdbc-mapping
     *     field-name="id"
     *     jdbc-field-name="account_id"
     */
    public abstract Integer getId();

    /**
     * No interface method for setId(..). See page 130 of the EJB 2.0 specification:
     * "Once the primary key for an entity bean has been set, the Bean Provider must
     * not attempt to change it by use of set accessor methods on the primary key
     * cmp-fields. The Bean provider should therefore not expose the set accessor
     * methods for the primary key cmp-fields in the component interface of the
     * entity bean.". A work around would be to remove and then an re-create the bean.
     */
    public abstract void setId(Integer id);

    /**
     * Deposit money.
     *
     * @ejb.interface-method
     */
    public void deposit(float amount) {
        setBalance(getBalance() + amount);
        setLastModificationDate(new Date());
    }

    /**
     * Withdraw money.
     *
     * @ejb.interface-method
     */
    public void withdraw(float amount) {
        if (amount <= 0)
            throw new IllegalArgumentException("Invalid amount: " + amount + ", must be > 0");

        setBalance(getBalance() - amount);
        setLastModificationDate(new Date());
    }

    /**
     * @ejb.value-object match="*"
     *                   relation="external"
     */
    public float getTotalBalance() {
        // do some wicked dynamic calculation
        return 0;
    }

    /**
     * Owner of this account.
     *
     * @ejb.persistent-field
     * @ejb.interface-method
     *
     * @ejb.persistence column-name="last_modif"
     *                  sql-type="TIMESTAMP"

     * @ejb.permission  role-name="Administrator"
     *
     * @ejb.transaction type="Supports"
     *
     * @ejb.value-object
     *    aggregate="test.interfaces.CustomerNormalValue"
     *    aggregate-name="OwnerNormalValue"
     *    match="*"
     */
    public abstract test.interfaces.Customer getOwner();

    /**
     * Owner of this account.
     */
    public abstract void setOwner(test.interfaces.Customer owner);

    /**
     * Balance of the account.
     *
     * @ejb.interface-method
     * @ejb.persistent-field
     *
     * @ejb.transaction type="Supports"
     * @ejb.permission  role-name="Customer,Administrator"
     *
     * @jboss.sql-type DOUBLE
     * @jboss.jdbc-type DOUBLE
     * @weblogic.dbms-column balance
     *
     * @jonas.cmp-field-jdbc-mapping
     *     field-name="balance"
     *     jdbc-field-name="balance"
     */
    public abstract float getBalance();

    /**
     * Balance of the account.  This is not remote since changing the balance of the account is done by calling "withdraw" or "deposit".
     */
    public abstract void setBalance(float balance);

    /**
     * @ejb.permission
     *    role-name="Administrator"
     * @ejb.transaction
     *    type="Supports"
     * @ejb.value-object
     *    exclude="true"
     *    match="*"
     * @ejb.persistent-field
     * @ejb.persistence
     *    column-name="last_modif"
     *    sql-type="TIMESTAMP"
     *
     * @jonas.cmp-field-jdbc-mapping
     *     field-name="lastModificationDate"
     *     jdbc-field-name="last_modif"
     */
    public abstract Date getLastModificationDate();

    public abstract void setLastModificationDate(Date d);

    /**
     * A getter without a corresponding setter.
     *
     * @ejb.persistent-field
     * @ejb.persistence
     *    column-name="accountid"
     *    sql-type="VARCHAR(20)"
     *
     * @jonas.cmp-field-jdbc-mapping
     *     field-name="accountid"
     *     jdbc-field-name="accountid"
     */
    public abstract String getAccountId();

    /**
     * Generated bulk accessor.  Not remote, but could be.
     *
     */
    public abstract void setData(AccountData data);

    /**
     * Generated bulk accessor. This is set as remote to allow clients to get all data in one call.
     *
     * @ejb.interface-method
     * @ejb.permission
     *    role-name="Administrator"
     * @ejb.transaction
     *    type="Supports"
     */
    public abstract AccountData getData();

    /**
     * @ejb.interface-method
     *    view-type="both"
     */
    public abstract AccountValue getAccountValue();

    /**
     * @ejb.interface-method
     *    view-type="both"
     */
    public abstract void setAccountValue(AccountValue value);

    /**
     * Create account.
     *
     * @ejb.create-method
     * @ejb.permission
     *    role-name="Administrator"
     */
    public AccountPK ejbCreate(AccountValue data)
            throws CreateException {
        setId(data.getId());
        setAccountValue(data);

        return null;
    }

    /**
     * Create account.
     */
    public void ejbPostCreate(AccountValue data)
            throws CreateException {
    }

    /**
     * Transfer money
     *
     * @ejb.permission
     *    role-name="Administrator"
     * @ejb.home-method
     *    view-type="remote"
     */
    public void ejbHomeTransfer(Account from, Account to, float amount) {
        try {
            from.withdraw(amount);
            to.deposit(amount);
        }
        catch (java.rmi.RemoteException e) {
            throw new EJBException(e);
        }
    }

        /**
         * This is to get the unknown primary key. We just get the primary key
         * from the entity context and cast it to the "known" class.
         *
         * @ejb.interface-method
         *   view-type="both"
         */
        public Integer getGeneratedPrimaryKey() {
                return (Integer) entityContext.getPrimaryKey();
        }
}
