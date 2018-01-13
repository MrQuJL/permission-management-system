package test.dao;

import test.interfaces.CustomerPK;
import test.ejb.CustomerBMPBean;
import java.util.*;
import javax.ejb.*;

/**
 * Example DAO implementation class
 */
public class CustomerExampleDAO
implements CustomerDAO
{
    
    /**
     * Initialise DAO
     */
    public void init()
    {
        // do JNDI lookup of Datasource resource ref
    }
    
    /**
     * Called by ejbLoad
     */
    public void load(CustomerPK pk, CustomerBMPBean bean)
    {
        // SELECT FROM datasource WHERE pkfields = pk.getX()
        // bean.setX(read values)
    }
    
    /**
     * Called by ejbStore
     */
    public void store(CustomerBMPBean bean)
    {
        // UPDATE datasource SET values = bean.getX()
    }
    
    /**
     * Called by create method(s)
     */
    public CustomerPK create(CustomerBMPBean bean)
    {
        CustomerPK pk = null;
        // INSERT INTO datasource (values) VALUES (bean.getX())
        // pk = new CustomerPK(pkfields)
        return pk;
    }
    
    /**
     * Called by ejbRemove
     */
    public void remove(CustomerPK pk)
    {
        // DELETE FROM datasource WHERE pkfields = pk.getX()
    }
    
    /**
     * Called by mandatory PK finder
     */
    public CustomerPK findByPrimaryKey(CustomerPK pk)
    {
        // SELECT FROM datasource WHERE pkfields = pk.getX()
        // if not found
        //   throw new ObjectNotFoundException();
        // pk = new CustomerPK(...);
        return pk;
    }
    
    /**
     * Finder that returns all rows
     */
    public Collection findAll()
    {
        List ret = new ArrayList();
        CustomerPK pk;
        // SELECT FROM datasource
        // for each resultset row
        //   pk = new CustomerPK(...);
        //   ret.add(pk);
        return ret;
    }
    
    /**
     * Non-lifecycle business method delegate
     */
    public void backup(CustomerPK pk)
    {
        // INSERT INTO datasource.Archive (fields)
        //   SELECT fields FROM Customer WHERE pkfields = pk.getX();
    }

}
