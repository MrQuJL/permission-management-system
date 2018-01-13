package test.ejb.jdo;

import java.util.Date;

/**
 * A simple test class to test for generation of Castor's mapping.xml.  Tests that classes that
 * this class depends on are listed before this class in mapping.xml - in this case, Staff
 * would be listed after paycheck (alphabetical), but the depends tag changes that.
 *
 * @castor.class
 *    id="ref"
 *    table="paycheck"
 *    depends="test.ejb.jdo.Staff"
 * @author Dmitri Colebatch (dim@bigpond.net.au)
 */
public class Paycheck
{
    private String ref;
    private double amount;
    private Date date;

    /**
     * @castor.field
     */
    public String getRef()
    {
        return ref;
    }

    public void setRef(String ref)
    {
        this.ref = ref;
    }

    /**
     * @castor.field
     */
    public double getAmount()
    {
        return amount;
    }

    public void setAmount(double amount)
    {
        this.amount = amount;
    }

    /**
     * @castor.field
     */
    public Date getDate()
    {
        return date;
    }

    public void setDate(Date date)
    {
        this.date = date;
    }
}
