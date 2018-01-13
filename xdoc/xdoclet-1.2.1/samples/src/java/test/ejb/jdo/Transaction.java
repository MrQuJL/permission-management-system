package test.ejb.jdo;

import java.util.Date;
import java.util.Vector;

/**
 * A simple test class to test for generation of Castor's mapping.xml.
 *
 * @castor.class
 *    id="reference"
 *    table="tx"
 * @version $Revision: 1.4 $
 * @author Dmitri Colebatch (dim@bigpond.net.au)
 */
public class Transaction
{
    /**
     * The tx reference - also the tx's id.
     */
    private int reference;

    /**
     * The tx amount.
     */
    private double amount;

    /**
     * The 'from' account id.
     */
    private int fromAccountId;

    /**
     * The 'to' account id.
     */
    private int toAccountId;

    /**
     * The date of the tx.
     */
    private Date date;

    /**
     * Silly field - a tx has a collection of staff that are involved in it.
     */
    private Vector staff;

    /**
     * @castor.field
     * @castor.field-sql
     *    type="integer"
     * @castor.field-xml
     */
    public int getReference()
    {
        return reference;
    }

    /**
     */
    public void setReference(int reference)
    {
        this.reference = reference;
    }

    /**
     * @castor.field
     * @castor.field-sql
     *    type="float"
     * @castor.field-xml
     */
    public double getAmount()
    {
        return amount;
    }

    /**
     */
    public void setAmount(double amount)
    {
        this.amount = amount;
    }

    /**
     * @castor.field
     * @castor.field-sql
     *    type="integer"
     * @castor.field-xml
     */
    public int getFromAccountId()
    {
        return fromAccountId;
    }

    /**
     */
    public void setFromAccountId(int fromAccountId)
    {
        this.fromAccountId = fromAccountId;
    }

    /**
     * @castor.field
     * @castor.field-sql
     *    type="integer"
     * @castor.field-xml
     */
    public int getToAccountId()
    {
        return toAccountId;
    }

    /**
     */
    public void setToAccountId(int toAccountId)
    {
        this.toAccountId = toAccountId;
    }

    /**
     * @castor.field
     * @castor.field-sql
     *    type="date"
     * @castor.field-xml
     */
    public Date getDate()
    {
        return date;
    }

    /**
     */
    public void setDate(Date date)
    {
        this.date = date;
    }

    /**
     * @castor.field collection="vector" type="test.ejb.jdo.Staff"
     */
    public Vector getStaff()
    {
        return staff;
    }

    public void setStaff(Vector staff)
    {
        this.staff = staff;
    }
}
