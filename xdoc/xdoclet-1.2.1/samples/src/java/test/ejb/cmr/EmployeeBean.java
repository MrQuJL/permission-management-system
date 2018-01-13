/*
 * $Id: EmployeeBean.java,v 1.3 2003/03/04 04:48:48 topping Exp $
 */
package test.ejb.cmr;

import javax.ejb.EntityBean;
import javax.ejb.CreateException;

import test.ejb.cmr.EmployeeAddressLocal;
import test.ejb.cmr.EmployeeValue;

/**
 * @ejb.bean
 *   name="Employee"
 *   type="CMP"
 *   cmp-version="2.x"
 *   primkey-field="id"
 *   view-type="local"
 *
 * @ejb.persistence
 *   table-name="employee"
 * @ejb.value-object
 *   name="Employee"
 *   match="*"
 *
 * @author Marcus Brito
 * @version $Revision: 1.3 $ $Date: 2003/03/04 04:48:48 $
 */
public abstract class EmployeeBean implements EntityBean
{
    /**
     * @ejb.interface-method
     *   view-type="local"
     * @ejb.persistence
     *   column-name="employee_id"
     */
    public abstract Integer getId();
    public abstract void setId(Integer id);

    /**
     * @ejb.interface-method
     *   view-type="local"
     * @ejb.persistence
     *   column-name="employee_name"
     */
    public abstract String getName();

    /**
     * @ejb.persistence
     *   view-type="local"
     */
    public abstract void setName(String name);

    /**
     * @ejb.interface-method
     *   view-type="local"
     * @ejb.relation
     *   name="Employee-HomeAddress"
     *   relation-name="employee-has-home-address"
     *   target-ejb="EmployeeAddress"
     *   target-role-name="address-belongs-to-employee"
     * @ejb.value-object
     *   aggregate="test.ejb.cmr.EmployeeAddressValue"
     *   aggregate-name="HomeAddress"
     *   relation="external"
     */
    public abstract EmployeeAddressLocal getHomeAddress();

    /**
     * @ejb.interface-method
     *   view-type="local
     */
    public abstract void setHomeAddress(EmployeeAddressLocal address);

    /**
     * @ejb.interface-method
     *   view-type="local"
     * @ejb.relation
     *   name="Employee-WorkAddress"
     *   relation-name="employee-has-work-address"
     *   target-ejb="EmployeeAddress"
     *   target-role-name="address-belongs-to-employee"
     * @ejb.value-object
     *   aggregate="test.ejb.cmr.EmployeeAddressValue"
     *   aggregate-name="WorkAddress"
     *   relation="external"
     */
    public abstract EmployeeAddressLocal getWorkAddress();

    /**
     * @ejb.interface-method
     *   view-type="local
     */
    public abstract void setWorkAddress(EmployeeAddressLocal address);

    /**
     * @ejb.interface-method
     *   view-type="local"
     */
    public abstract EmployeeValue getEmployeeValue();

    /**
     * @ejb.interface-method
     *   view-type="local"
     */
    public abstract void setEmployeeValue(EmployeeValue value);

    /**
     * @ejb:create-method
     */
    public Integer ejbCreate(EmployeeValue ev) throws CreateException {
        setId(ev.getId());
        return ev.getId();
    }
}
