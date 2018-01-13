/*
 * $Id: AddressBean.java,v 1.11 2002/09/19 07:09:16 stevensa Exp $
 */

package test.ejb;

import test.interfaces.AddressValue;
import test.interfaces.AddressUtil;

import javax.ejb.CreateException;
import javax.ejb.EntityBean;
import javax.ejb.FinderException;

/**
 * @ejb.bean
 *     name="Address"
 *     jndi-name="ejb/addr/Address"
 *     view-type="local"
 *     primkey-field="id"
 *
 * @ejb.finder
 *     signature="Collection findByStreet(java.lang.String street)"
 *     unchecked="true"
 *
 * @ejb.finder
 *     signature="Collection findByCity(java.lang.String city)"
 *
 * @ejb.finder
 *     signature="Collection findByOwner(test.interfaces.Customer owner)"
 *
 * @ejb.value-object
 *     name="Address"
 *     match="*"
 *
 * @ejb.persistence
 *     table-name="address"
 *
 * @jonas.bean
 *     ejb-name="Address"
 *     jndi-name="AddressHome"
 * @jonas.jdbc-mapping
 *     jndi-name="jdbc_1"
 *     jdbc-table-name="address"
 * @jonas.finder-method-jdbc-mapping
 *     method-name="findByStreet"
 *     jdbc-where-clause="street = ?"
 * @jonas.finder-method-jdbc-mapping
 *     method-name="findByCity"
 *     jdbc-where-clause="city = ?"
 *
 * @author  <a href="mailto:youremail@yourdomain.com">youremail@yourdomain.com</a>
 */
public abstract class AddressBean extends BaseEntityBean implements EntityBean {
    /** @ejb.create-method */
    public String ejbCreate(AddressValue v) throws CreateException {
        setId(AddressUtil.generateGUID(this));
        return null;
    }

    public void ejbPostCreate(AddressValue v) throws CreateException {
        // CMR relations must be set in ejbPostCreate
        setAddressValue(v);
    }

    //========== VALUE OBJECT ==========//

    /** @ejb.interface-method */
    public abstract AddressValue getAddressValue();

    /**
     * @ejb.interface-method
     * @ejb.transaction
     *     type="RequiresNew"
     */
    public abstract void setAddressValue(AddressValue v);

    //========== ATTRIBUTES ==========//

    /**
     * @ejb.pk-field
     * @ejb.persistent-field
     * @ejb.persistence
     *     column-name="id"
     *     sql-type="VARCHAR"
     * 
     * @jonas.cmp-field-jdbc-mapping
     *     field-name="id"
     *     jdbc-field-name="id" 
     */
    public abstract String getId();

    /**
     * No interface method for setId(..). See page 130 of the EJB 2.0 specification:
     * "Once the primary key for an entity bean has been set, the Bean Provider must
     * not attempt to change it by use of set accessor methods on the primary key
     * cmp-fields. The Bean provider should therefore not expose the set accessor
     * methods for the primary key cmp-fields in the component interface of the
     * entity bean.". A work around would be to remove and then an re-create the bean.
     */
    public abstract void setId(String id);

    /**
     * @ejb.persistent-field
     * @ejb.persistence
     *     column-name="street"
     *     sql-type="VARCHAR"
     * 
     * @jonas.cmp-field-jdbc-mapping
     *     field-name="street"
     *     jdbc-field-name="street"
     */
    public abstract String getStreet();

    /**
     * @ejb.persistent-field
     * @ejb.persistence
     *     column-name="city"
     *     sql-type="VARCHAR"
     * 
     * @jonas.cmp-field-jdbc-mapping
     *     field-name="city"
     *     jdbc-field-name="city"
     */
    public abstract String getCity();

    /** @ejb.select query="SELECT a.street FROM Address AS a WHERE a.street = 'Cinnamon Street'" */
    public abstract String ejbSelectMostCrowdedStreet() throws FinderException;

}
