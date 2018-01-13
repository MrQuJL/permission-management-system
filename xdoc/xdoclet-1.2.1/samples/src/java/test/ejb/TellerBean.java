package test.ejb;

import test.interfaces.Account;

import javax.ejb.*;

/**
 * This is a teller bean. It is an example of how to use the XDoclet tags.
 *
 * @ejb.bean         name="Teller"
 *                   description="Teller example bean"
 *                   jndi-name="ejb/bank/Teller"
 *                   type="Stateless"
 *
 * @ejb.ejb-ref      ejb-name="Account"
 *                   ref-name="ejb/bank/Account"
 *
 * @ejb.ejb-ref      ejb-name="Customer"
 *
 * @ejb.security-role-ref role-link="Administrator"
 *                        role-name="admin"
 *
 * @ejb.permission   role-name="Teller"
 * @ejb.permission   role-name="Administrator"
 *
 * @ejb.transaction  type="Required"
 * @ejb.transaction-type type="Container"
 *
 * @ejb.resource-ref res-auth="Container"
 *                   res-name="jdbc/DBPool"
 *                   res-type="javax.sql.DataSource"
 *
 * @soap.service    urn="TellerService"
 *
 * @jboss.resource-ref res-ref-name="jdbc/DBPool"
 *                     resource-name="MyDataSourceManager"
 *
 * @jboss.container-configuration name="Standard Stateless SessionBean"
 *
 * @jboss.ejb-ref-jndi jndi-name="ejb/bank/Account"
 *                     ref-name="bank/Account"
 *
 * @weblogic.pool      initial-beans-in-free-pool="1"
 *                     max-beans-in-free-pool="3"
 *
 * @weblogic.stateless-clustering stateless-bean-call-router-class-name="Whatever"
 *                                stateless-bean-is-clusterable="True"
 *                                stateless-bean-load-algorithm="Whazzup"
 *                                stateless-bean-methods-are-idempotent="Sure"
 *
 * @websphere.bean timeout="239"
 * @jonas.bean ejb-name="Teller"
 *             jndi-name="TellerHome"
 * @jonas.ejb-ref ejb-ref-name="ejb/bank/Account"
 *                jndi-name="Account"
 * @jonas.ejb-ref ejb-ref-name="ejb/Customer"
 *                jndi-name="Customer"
 * @jonas.resource res-ref-name="jdbc/DBPool"
 *                 jndi-name="jdbc_1"
 *
 * @author  <a href="mailto:youremail@yourdomain.com">youremail@yourdomain.com</a>
 */
public abstract class TellerBean extends BaseTellerBean implements SessionBean {
    /**
     * Transfer money between accounts.
     *
     * @ejb.interface-method view-type="remote"
     */
    public void transfer(Account from, Account to, float amount) {
        try {
            from.withdraw(amount);
            to.deposit(amount);
        }
        catch (java.rmi.RemoteException e) {
            throw new EJBException(e);
        }
    }

    /**
     */
    public void ejbActivate() {
    }

    /**
     */
    public void ejbPassivate() {
    }

    /**
     */
    public void setSessionContext(SessionContext ctx) {
    }

    /**
     * Remove
     *
     * @ejb.transaction
     *    type="Mandatory"
     */
    public void ejbRemove() {
    }

}
