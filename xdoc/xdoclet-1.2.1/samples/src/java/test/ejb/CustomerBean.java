package test.ejb;

import test.interfaces.AccountHome;
import test.interfaces.AddressLocalHome;
import test.interfaces.ApplicationException;
import test.interfaces.Customer;
import test.interfaces.CustomerData;
import test.interfaces.CustomerLightValue;
import test.interfaces.CustomerNormalValue;
import test.interfaces.CustomerPK;

import javax.ejb.CreateException;
import javax.ejb.EJBException;
import javax.ejb.EntityContext;
import javax.naming.InitialContext;
import java.util.Collection;

/**
 * This is a customer bean. It is an example of how to use the XDoclet tags.
 *
 * @ejb.bean
 *    cmp-version="1.x"
 *    jndi-name="${ejb.prefix}/bank/Customer"
 *    name="Customer"
 *    type="CMP"
 *    use-soft-locking="true"
 *    view-type="remote"
 * @ejb.ejb-ref
 *    ejb-name="Account"
 *    ref-name="ejb/bank/Account"
 * @ejb.security-role-ref
 *    role-link="Administrator"
 *    role-name="admin"
 * @ejb.permission
 *    role-name="Teller"
 * @ejb.transaction
 *    type="Required"
 * @ejb.data-object
 *    use-super-equals="true"
 * @ejb.value-object
 *    match="light"
 *    name="CustomerLight"
 * @ejb.value-object
 *    match="normal"
 *    name="CustomerNormal"
 * @ejb.value-object
 *    match="*"
 * @jboss.ejb-ref-jndi
 *    jndi-name="ejb/bank/Account"
 *    ref-name="bank/Account"
 * @ejb.persistence table-name="customer"
 * @jboss.create-table "true"
 * @jboss.remove-table "true"
 * @jboss.tuned-updates "true"
 * @jboss.read-only "true"
 * @jboss.time-out "100"
 * @weblogic.transaction-isolation TRANSACTION_SERIALIZABLE
 *
 * @jonas.bean ejb-name="Customer"
 *    jndi-name="CustomerHome"
 * @jonas.ejb-ref ejb-ref-name="ejb/bank/Account"
 *    jndi-name="Account"
 * @jonas.jdbc-mapping
 *    jndi-name="jdbc_1"
 *    jdbc-table-name="customer"
 *
 * @todo This too should not appear in CMP class
 */

public abstract class CustomerBean
        extends PersonBean {
    private EntityContext ctx;

    /**
     * Overriden from Person.
     *
     * @todo This todo should not appear in interfaces
     * @ejb.interface-method
     * @weblogic.transaction-isolation TRANSACTION_READ_COMMITTED
     */
    public void talkTo() {
    }

    /**
     * Overloaded works too.
     *
     * @ejb.interface-method
     */
    public void talkTo(String somebody) {
    }

    /**
     * Credit limit
     *
     * @ejb.persistent-field
     * @ejb.persistence
     *    column-name="credit"
     * @ejb.value-object
     *    match="normal"
     * @ejb.value-object
     *    match="light"
     */
    public abstract float getCredit();

    /**
     * Array
     *
     * @ejb.persistent-field
     * @ejb.persistence
     *    column-name="array"
     * @ejb.value-object
     *    match="normal"
     * @ejb.value-object
     *    match="light"
     */
    public abstract String[][] getArray();

    /**
     * Array
     *
     * @ejb.persistent-field
     * @ejb.persistence
     *    column-name="image"
     * @ejb.value-object
     *    match="normal"
     * @ejb.value-object
     *    match="light"
     */
    public abstract byte[] getImage();

    /**
     * Tax Code
     *
     * @ejb.persistent-field
     * @ejb.persistence
     *    column-name="tax"
     * @ejb.value-object
     *    match="normal"
     */
    public abstract float getTax();

    /**
     * Credit limit
     *
     */
    public abstract void setCredit(float credit);

    /**
     * Accounts of this customer
     *
     * @ejb.interface-method
     * @ejb.transaction
     *    type="Supports"
     * @ejb.value-object
     *    aggregate="test.interfaces.AccountValue"
     *    aggregate-name="AccountView"
     *    match="normal"
     *    members="test.interfaces.AccountLocal"
     *    members-name="Account"
     *    relation="external"
     *    type="java.util.Collection"
     */
    public java.util.Collection getAccounts() {
        // Some code here under that will flame the guy who break multiple method tags
        CustomerNormalValue normal = new CustomerNormalValue();
        normal.getCredit();
        CustomerLightValue light = new CustomerLightValue();
        light.getCredit();
        try {
            AccountHome home = (AccountHome) new InitialContext().lookup("java:comp/env/ejb/bank/Account");
            return home.findByOwner((Customer) ctx.getEJBObject());
        }
        catch (Exception e) {
            throw new EJBException(e);
        }
    }

    /**
     * Just to show that generated methods can be exported to remote/local interafce
     *
     * @ejb.interface-method
     */
    public abstract void addAccount(test.interfaces.AccountValue added)
            throws javax.ejb.FinderException;

    /**
     * Generated bulk accessor.  Not remote, but could be.
     *
     */
    public void setData(CustomerData data) {
        try {
            super.setData(data);
            setCredit(data.getCredit());
        }
        catch (Exception e) {
            throw new javax.ejb.EJBException(e);
        }
    }

    /**
     * @ejb.interface-method
     *    view-type="remote"
     */
    public abstract void setCustomerNormalValue(CustomerNormalValue value)
            throws ApplicationException;

    /**
     * @ejb.interface-method
     *    view-type="remote"
     */
    public abstract CustomerNormalValue getCustomerNormalValue();

    /**
     * This method to show how validation errors can be reported to the user. This is Business Logic validation error.
     *
     */
    protected void validate(CustomerNormalValue value)
            throws ApplicationException {
        /* This exception should better be done in the client itself because
           it requires no ejb connection.  Anyway this is an "example" on how
           business validation can be done */
        if (value.getTax() < 0)
            throw new ApplicationException("A Customer can not have a negative Tax");
    }

    /**
     * Generated bulk accessor. This is set as remote to allow clients to get all data in one call.
     *
     * @ejb.interface-method
     *    view-type="remote"
     * @ejb.transaction
     *    type="Supports"
     */
    public CustomerData getData() {
        return null;
    }

    /**
     * @ejb:interface-method
     * @ejb:permission role-name="Administrator"
     * @ejb:transaction type="Supports"
     * @ejb:value-object match="*" compose="test.interfaces.AddressValue" compose-name="AddressValue"
     */
//   public abstract test.interfaces.AddressLocal getAddress();

    /**
     * @ejb:interface-method
     */
//   public abstract void setAddress(test.interfaces.AddressLocal addr);

    /**
     * Accounts of this customer
     *
     * @ejb.interface-method
     * @ejb.transaction
     *    type="Supports"
     * @ejb.value-object
     *    compose="test.interfaces.AddressValue"
     *    compose-name="ShippingAddressValue"
     *    match="normal"
     *    members="test.interfaces.AddressLocal"
     *    members-name="ShippingAddress"
     *    relation="external"
     *    type="java.util.Collection"
     */
    public java.util.Collection getShippingAddresses() {
        try {
            AddressLocalHome home = (AddressLocalHome) new InitialContext().lookup("java:comp/env/ejb/bank/Address");
            return home.findByOwner((Customer) ctx.getEJBObject());
        }
        catch (Exception e) {
            throw new EJBException(e);
        }
    }

    /**
     * Create customer.
     *
     * @ejb.create-method
     * @ejb.permission
     *    role-name="Administrator"
     */
    public java.lang.Object ejbCreate(CustomerNormalValue data)
            throws CreateException {
        try {
            setId(data.getId());
//         data.getAddressValue().setId(data.getId());
//         AddressUtil.getLocalHome().create(data.getAddressValue());
            return null;
        }
        catch (Exception e) {
            throw new EJBException(e);
        }
    }

//  Let's test the ejbPC auto add feature
//   public void ejbPostCreate(CustomerNormalValue data)
//     throws CreateException {}

    /**
     * Create customer.
     *
     */
    public void ejbPostCreate(CustomerData data)
            throws CreateException {
    }

    // EntityBean implementation -------------------------------------
    /**
     * Remove
     *
     * @ejb:transaction type="Mandatory"
     */
//   public void ejbRemove() throws RemoveException {
//      getAddress().remove();
//   }

    /**
     * To see if abstract works
     *
     */
    public abstract void ejbLoad();

    /**
     * Custom Finders
     *
     */
    public java.util.Collection ejbFindCustomFinderInSuper() {
        return null;
    }

    /**
     * @ejb:home-method
     */
    public void ejbHomeCopyToArchive(CustomerPK pk) {
        // does nothing with CMP, BMP will override
    }

}
