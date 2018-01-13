package test.ejb;

import test.interfaces.PersonData;

import javax.ejb.*;
import java.util.Collection;

/**
 * This is a person bean. It is an example of how to use the XDoclet tags.
 *
 * @ejb.finder
 *    role-name="Teller"
 *    signature="Collection findAll()"
 *    transaction-type="NotSupported"
 *
 * @ejb.transaction
 *    type="Required"
 *
 * @ejb.data-object
 *    equals="true"
 *    implements="test.interfaces.Identifiable"
 *    ver-uid="7523967970034398950L"
 *
 * @ejb.pk
 *    generate="false"
 *
 * @ejb.env-entry
 *    name="blabla"
 *    type="java.lang.Integer"
 *    value="12345"
 *
 * @ejb.env-entry
 *    description="test value with description"
 *    name="foo"
 *    type="java.lang.String"
 *    value="bar"
 *
 * @ejb.persistence
 *    table-name="person"
 * @jboss.create-table "true"
 * @jboss.remove-table "true"
 * @jboss.tuned-updates "true"
 * @jboss.read-only "false" Struts form bean specific
 * @struts.form
 *    name="Names"
 * @struts.form
 *    include-pk="false"
 *    name="Contact"
 * @struts.form
 *    include-all="true"
 *    name="Full"
 *
 * @jonas.bean
 *    ejb-name="Person"
 *    jndi-name="PersonHome"
 * @jonas.shared true
 * @jonas.jdbc-mapping
 *    jndi-name="jdbc_1"
 *    jdbc-table-name="person"
 * @jonas.finder-method-jdbc-mapping
 *    method-name="findAll"
 *    jdbc-where-clause=""
 */

public abstract class PersonBean
        extends BaseEntityBean
        implements EntityBean {
    private EntityContext ctx;

    /**
     * Id of this person.
     *
     * @ejb.pk-field
     * @ejb.persistent-field
     * @ejb.persistence
     *    column-name="id"
     * @ejb.value-object
     *    match="*"
     *
     * @jonas.cmp-field-jdbc-mapping
     *    field-name="id"
     *    jdbc-field-name="id"
     */
    public abstract String getId();

    /**
     * @ejb.interface-method
     * @ejb.permission
     *    role-name="Administrator"
     */
    public abstract void setId(String id);

    /**
     * Name of the person.
     *
     * @ejb.interface-method
     * @ejb.transaction
     *    type="Supports"
     * @ejb.permission
     *    role-name="Customer"
     * @ejb.permission
     *    role-name="Administrator"
     * @ejb.persistent-field
     * @ejb.persistence
     *    column-name="name"
     * @struts.form-field
     *    form-name="Names"
     * @ejb.value-object
     *    match="normal"
     *
     * @jonas.cmp-field-jdbc-mapping
     *    field-name="name"
     *    jdbc-field-name="name"
     */
    public abstract String getName();

    /**
     * Name of the customer.
     *
     */
    public abstract void setName(String name);

    /**
     * FirstName of the person.
     *
     * @ejb.interface-method
     * @ejb.transaction
     *    type="Supports"
     * @ejb.permission
     *    role-name="Customer"
     * @ejb.permission
     *    role-name="Administrator"
     * @ejb.persistent-field
     * @ejb.persistence
     *    column-name="first_name"
     * @struts.form-field
     *    form-name="Names"
     * @ejb.value-object
     *    match="normal"
     *
     * @jonas.cmp-field-jdbc-mapping
     *    field-name="firstName"
     *    jdbc-field-name="first_name"
     */
    public abstract String getFirstName();

    /**
     * @ejb.interface-method
     * @ejb.permission
     *    role-name="Administrator"
     */
    public abstract void setFirstName(String firstName);

    /**
     * phone of the person.
     *
     * @ejb.interface-method
     * @ejb.transaction
     *    type="Supports"
     * @ejb.permission
     *    role-name="Customer"
     * @ejb.permission
     *    role-name="Administrator"
     * @ejb.persistent-field
     * @ejb.persistence
     *    column-name="phone"
     * @struts.form-field
     *    form-name="Contact"
     *
     * @jonas.cmp-field-jdbc-mapping
     *    field-name="phone"
     *    jdbc-field-name="phone"
     */
    public abstract String getPhone();

    /**
     * @ejb.interface-method
     * @ejb.permission
     *    role-name="Administrator"
     */
    public abstract void setPhone(String phone);

    /**
     * fax of the person.
     *
     * @ejb.interface-method
     * @ejb.transaction
     *    type="Supports"
     * @ejb.permission
     *    role-name="Customer"
     * @ejb.permission
     *    role-name="Administrator"
     * @ejb.persistent-field
     * @ejb.persistence
     *    column-name="fax"
     * @struts.form-field
     *    form-name="Contact"
     *
     * @jonas.cmp-field-jdbc-mapping
     *    field-name="fax"
     *    jdbc-field-name="fax"
     */
    public abstract String getFax();

    /**
     * @ejb.interface-method
     * @ejb.permission
     *    role-name="Administrator"
     */
    public abstract void setFax(String fax);

    /**
     * This field will be included in the PersonFullForm,
     * even if it's not a persistent field. Note the absence
     * of the form-name attribute, indicating it will be
     * included only in forms marked with include-all="true" 
     *
     * @struts.form-field
     */
    public Integer getNonPersistentFormField()
    {
        return new Integer(0);
    }

    public void setNonPersistentFormField(Integer i)
    {

    }

    /**
     * Generated bulk accessor.  Not remote, but could be.
     *
     */
    public void setData(PersonData data) {
        setId(data.getId());
        setName(data.getName());
    }

    /**
     * @ejb.interface-method
     */
    public void talkTo() {
        ;
    }

    /**
     * Create person.
     *
     */
    public void ejbPostCreate(PersonData data)
            throws CreateException {
    }

    /**
     * Custom Finders
     *
     */
    public Collection ejbFindCustomFinder(int a, String b) {
        return null;
    }

    /**
     */
    public java.util.Collection ejbFindCustomFinderInSuper() {
        return null;
    }

    /**
     * WLS 6.0+ EJB 1.1 finder
     *
     * @weblogic.finder
     *    find-for-update="true"
     *    finder-query="(== phone $0)"
     */
    public java.util.Collection ejbFindByPhone(String phone) {
        return null;
    }

    /**
     * @struts.form-field
     *    form-name="Names"
     */
    public String getComputedField() {
        return "abc";
    }

}
