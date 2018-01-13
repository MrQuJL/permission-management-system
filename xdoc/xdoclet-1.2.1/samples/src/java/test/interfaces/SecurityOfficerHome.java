package test.interfaces;

import java.rmi.RemoteException;
import javax.ejb.CreateException;

/**
    * This Bean serves as an example of a session bean that does not require a subclass to be generated, but is included in the deployment descriptor generation.  It is a _very_ simple stupid example.
    * 
    */
public interface SecurityOfficerHome
   extends javax.ejb.EJBHome
{

/**
    */
public SecurityOfficer create()
      throws CreateException, RemoteException;
}
