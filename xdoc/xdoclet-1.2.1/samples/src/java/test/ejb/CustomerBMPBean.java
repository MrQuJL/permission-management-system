package test.ejb;

import test.dao.*;
import test.interfaces.CustomerData;
import test.interfaces.CustomerPK;
import test.interfaces.CustomerNormalValue;

import java.util.*;
import javax.ejb.*;

/**
 * This is a customer bean. It is an example of how to use the XDoclet tags.
 *
 * @ejb.bean
 *    jndi-name="ejb/bank/CustomerBMP"
 *    name="CustomerBMP"
 *    type="BMP"
 *    use-soft-locking="true"
 *    view-type="remote"
 * @ejb.ejb-ref
 *    ejb-name="CustomerBMP"
 * @ejb.security-role-ref
 *    role-link="Administrator"
 *    role-name="admin"
 * @ejb.permission
 *    role-name="Teller"
 * @ejb.transaction
 *    type="Required"
 * @ejb.pk
 *    class="test.interfaces.CustomerPK"
 *    generate="false"
 * @ejb.interface
 *    generate="false"
 *    remote-class="test.interfaces.Customer"
 * @ejb.home
 *    generate="false"
 *    remote-class="test.interfaces.CustomerHome"
 * @ejb.data-object
 *    class="test.interfaces.CustomerData"
 *    generate="false"
 * @ejb.dao
 *    class="test.dao.CustomerDAO"
 *    impl-jndi="dao"
 * @jboss.ejb-ref-jndi
 *    jndi-name="ejb/bank/Account"
 *    ref-name="bank/Account"
 * @ejb.env-entry
 *    name="dao"
 *    type="java.lang.String"
 *    value="test.dao.CustomerExampleDAO"
 *
 * @jonas.bean ejb-name="CustomerBMP"
 *    jndi-name="CustomerBMPHome"
 * @jonas.ejb-ref ejb-ref-name="ejb/CustomerBMP"
 *    jndi-name="CustomerBMP"
 */
public abstract class CustomerBMPBean
        extends CustomerBean
{
    
    /**
     * @ejb.create-method
     */
    public Object ejbCreate(CustomerData detail)
            throws CreateException
    {
        throw new IllegalStateException("Creation of Customer is not possible");
    }
    
    public void ejbPostCreate(CustomerData detail) {}
    
    /**
     * @ejb.create-method
     */
    public Object ejbCreate(CustomerNormalValue detail)
            throws CreateException
    {
        throw new IllegalStateException("Creation of Customer is not possible");
    }
    
    public abstract Collection ejbFindAll()
            throws FinderException;
    
    public abstract CustomerPK ejbFindByPrimaryKey(CustomerPK pk)
            throws FinderException;
    
    /**
     * @ejb.home-method
     * @dao.call name="backup"
     */
    public void ejbHomeCopyToArchive(CustomerPK pk)
    {
        // does nothing with CMP, BMP will override
    }

}
