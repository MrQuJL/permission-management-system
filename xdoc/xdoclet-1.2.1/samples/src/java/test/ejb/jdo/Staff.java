package test.ejb.jdo;

import java.util.Date;

/**
 * A simple test class to test for generation of Castor's mapping.xml.
 *
 * @castor.class
 *    id="id"
 *    table="staff"
 * @author Dmitri Colebatch (dim@bigpond.net.au)
 */
public class Staff
{
    private int id;
    private String name;
    private Date startDate;

    /**
     * @castor.field
     * @castor.field-sql
     *    type="integer"
     * @castor.field-xml
     */
    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    /**
     * @castor.field
     * @castor.field-sql
     *    type="varchar"
     * @castor.field-xml
     */
    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    /**
     * @castor.field
     * @castor.field-sql
     *    type="date"
     * @castor.field-xml
     */
    public Date getStartDate()
    {
        return startDate;
    }

    public void setStartDate(Date startDate)
    {
        this.startDate = startDate;
    }
}
