package test.ejb;

import test.interfaces.Customer;
import test.interfaces.CustomerHome;

import javax.ejb.EJBException;
import javax.ejb.FinderException;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.rmi.RemoteException;
import java.util.Collection;
import java.util.Iterator;

/**
 * This Bean serves as an example of a session bean that does not require a subclass to
 * be generated, but is included in the deployment descriptor generation. It is a _very_ simple
 * stupid example.
 *
 * @ejb.bean
 *    generate="false"
 *    jndi-name="ejb/bank/SecurityOfficer"
 *    name="SecurityOfficer"
 *    type="Stateless"
 * @ejb.ejb-ref
 *    ejb-name="SecurityOfficer"
 * @ejb.permission
 *    role-name="SecurityOfficer"
 * @ejb.interface
 *    generate="false"
 * @ejb.home
 *    generate="false"
 * @ejb.util
 *    generate="false"
 * @jboss.container-configuration
 *    name="Standard Stateless SessionBean"
 * @jboss.ejb-ref-jndi
 *    jndi-name="ejb/bank/Customer"
 *    ref-name="bank/Customer"
 *
 * @jonas.bean ejb-name="SecurityOfficer"
 *             jndi-name="SecurityOfficerHome"
 * @jonas.ejb-ref ejb-ref-name="ejb/SecurityOfficer"
 *                jndi-name="SecurityOfficer"
 */
public class SecurityOfficerBean implements SessionBean {
    // SessionBean implementation -----------------------------------

    private SessionContext sessionContext;

    /**
     */
    public void setSessionContext(SessionContext context) {
        this.sessionContext = context;
    }

    /**
     */
    public void ejbRemove() {
        ;
    }

    /**
     */
    public void ejbActivate() {
        ;
    }

    /**
     */
    public void ejbPassivate() {
        ;
    }

    /**
     */
    public void patrolBank() {
        System.out.println("Patrolling bank.");

        try {
            CustomerHome home = (CustomerHome) new InitialContext().lookup("java:comp/env/ejb/bank/Customer");
            Collection customers = home.findAll();
            for (Iterator customersInBank = customers.iterator(); customersInBank.hasNext();) {
                Customer customer = (Customer) customersInBank.next();
                customer.talkTo();
            }
        }
        catch (NamingException e) {
            throw new EJBException("Unable to find any customers: " + e.getMessage());
        }
        catch (RemoteException e) {
            throw new EJBException("Unable to find any customers: " + e.getMessage());
        }
        catch (FinderException e) {
            throw new EJBException("Unable to find any customers: " + e.getMessage());
        }
    }

}
