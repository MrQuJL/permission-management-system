
package test.ejb;

import test.interfaces.Account;

import javax.ejb.*;

public class BaseTellerBean {
    /**
     * Deposit account.
     *
     * @ejb.interface-method view-type="remote"
     */
    public void deposit(Account account, float amount) {
        try {
            account.deposit(amount);
        }
        catch (java.rmi.RemoteException e) {
            throw new EJBException(e);
        }
    }
}