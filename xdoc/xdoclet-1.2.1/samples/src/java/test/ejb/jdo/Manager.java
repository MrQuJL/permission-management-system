package test.ejb.jdo;

import java.util.Vector;

/**
 * A simple test class to test for generation of Castor's mapping.xml.
 *
 * @castor.class
 *    extends="test.ejb.jdo.Staff"
 *    xml="manager"
 * @author Dmitri Colebatch (dim@bigpond.net.au)
 */
public class Manager extends Staff
{
    private Vector employees;

    /**
     * @castor.field collection="vector" type="test.ejb.jdo.Staff"
     */
    public Vector getEmployees()
    {
        return employees;
    }

    public void setEmployees(Vector employees)
    {
        this.employees = employees;
    }
}
