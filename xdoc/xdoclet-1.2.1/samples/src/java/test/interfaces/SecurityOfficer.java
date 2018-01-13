package test.interfaces;

import java.rmi.RemoteException;
import javax.ejb.EJBObject;

/**
    * This Bean serves as an example of a session bean that does not require a subclass to be generated, but is included in the deployment descriptor generation.  It is a _very_ simple stupid example.
    * 
    */
public interface SecurityOfficer
   extends EJBObject
{

/**
    */
public void patrolBank()
        throws RemoteException;
}
