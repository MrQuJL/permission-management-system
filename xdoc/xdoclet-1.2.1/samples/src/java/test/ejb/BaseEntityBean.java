package test.ejb;

import javax.ejb.*;

/**
 * SuperClass for all entity beans, implementing common entity bean methods.
 *
 * @author  <a href="mailto:youremail@yourdomain.com">youremail@yourdomain.com</a>
 * @version $Revision: 1.6 $
 */
public abstract class BaseEntityBean {
    /** Reference to EntityContext. */
    protected EntityContext entityContext = null;

    /**
     * The creation-date of the entity. This field is purely to track when
     * this entity was created, and should be set in ejbCreate
     * (<code>setCreationDate(new Date());</code>.
     * It is not included in the value object.
     *
     * <p>We use the qualified name here because XDoclet doesn't copy imports from
     * base classes into the generated interfaces.</p>
     *
     * @ejb.persistence column-name="creationDate"
     * @ejb.interface-method
     *
     * @ejb.value-object exclude="true" match="*"
     *
     */
    public abstract java.util.Date getCreationDate();

    /** @ejb.interface-method */
    public abstract void setCreationDate(java.util.Date creationDate);

    /**
     * Gets the EntityContext. To be used by classes extending this.
     * @return the EntityContext of the EJB
     */
    protected EntityContext getEntityContext() {
        return entityContext;
    }

    /** Required to implement EntityBean. Sets the EntityContext. */
    public void setEntityContext(EntityContext entityContext) throws EJBException {
        this.entityContext = entityContext;
    }

    /** Required to implement EntityBean. Sets the EntityContext to null. */
    public void unsetEntityContext() throws EJBException {
        entityContext = null;
    }

    /** Required to implement EntityBean. Not implemented. */
    public void ejbActivate() throws EJBException { }

    /** Required to implement EntityBean. Not implemented. */
    public void ejbPassivate() throws EJBException { }

    /** Required to implement EntityBean. Not implemented. */
    public void ejbLoad() throws EJBException { }

    /** Required to implement EntityBean. Not implemented. */
    public void ejbStore() throws EJBException { }

    /** Required to implement EntityBean. Not implemented. */
    public void ejbRemove() throws RemoveException, EJBException { }
}