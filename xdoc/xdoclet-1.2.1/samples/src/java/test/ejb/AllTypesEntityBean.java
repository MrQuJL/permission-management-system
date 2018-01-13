
package test.ejb;

import test.interfaces.AllTypesEntityUtil;

import javax.ejb.EntityBean;
import javax.ejb.EntityContext;
import javax.ejb.CreateException;
import javax.ejb.RemoveException;
import java.rmi.RemoteException;
import java.util.Date;

/**
 * This bean demonstrates all possible data types.
 *
 * @ejb.bean        name="AllTypesEntity"
 *                  jndi-name="test/AllTypesEntity"
 *                  local-jndi-name="test/LocalAllTypesEntity"
 *                  view-type="both"
 *                  
 *
 * @ejb.persistence
 *     table-name="alltypes"
 *
 * @ejb.pk unchecked="true"
 * @version $Revision: 1.7 $
 * @author  <a href="mailto:youremail@yourdomain.com">youremail@yourdomain.com</a>
 */
public abstract class AllTypesEntityBean extends BaseEntityBean implements EntityBean {
    /** @ejb.create-method */
    public String ejbCreate(boolean aBoolean, byte aByte, short aShort, char aChar, int anInt) throws CreateException {
        // set the primary key
        setId(AllTypesEntityUtil.generateGUID(this));

        setABoolean(aBoolean);
        setAByte(aByte);
        setAShort(aShort);
        setAChar(aChar);
        setAnInt(anInt);

        return null;
    }

    public void ejbPostCreate(boolean aBoolean, byte aByte, short aShort, char aChar, int anInt) throws CreateException {
    }
   /**
    * @ejb.persistent-field
    * @ejb.interface-method
    * @ejb.pk-field 
    */ 
   public abstract int[] getIVOwnerHdl(); 
   public abstract void setVOwnerHdl(int[] bb);
    /**
     * @ejb.pk-field
     * @ejb.interface-method
     * @ejb.persistent-field
     *
     * @ejb.persistence column-name="types_id"
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
     * Abstract CMP 2.0 field getter for field aBoolean.
     *
     * @ejb.interface-method
     * @ejb.persistent-field
     *
     * @ejb.persistence column-name="boolean"
     */
    public abstract boolean getABoolean();

    /**
     * Abstract CMP 2.0 field setter for field aBoolean.
     *
     * @ejb.interface-method
     */
    public abstract void setABoolean(boolean aBoolean);

    /**
     * Abstract CMP 2.0 field getter for field aByte.
     *
     * @ejb.interface-method
     * @ejb.persistent-field
     *
     * @ejb.persistence column-name="byte"
     */
    public abstract byte getAByte();

    /**
     * Abstract CMP 2.0 field setter for field aByte.
     *
     * @ejb.interface-method
     */
    public abstract void setAByte(byte aByte);

    /**
     * Abstract CMP 2.0 field getter for field aShort.
     *
     * @ejb.interface-method
     * @ejb.persistent-field
     *
     * @ejb.persistence column-name="short"
     */
    public abstract short getAShort();

    /**
     * Abstract CMP 2.0 field setter for field aShort.
     *
     * @ejb.interface-method
     */
    public abstract void setAShort(short aShort);

    /**
     * Abstract CMP 2.0 field getter for field aChar.
     *
     * @ejb.interface-method
     * @ejb.persistent-field
     *
     * @ejb.persistence column-name="char"
     */
    public abstract char getAChar();

    /**
     * Abstract CMP 2.0 field setter for field aChar.
     *
     * @ejb.interface-method
     */
    public abstract void setAChar(char aChar);

    /**
     * Abstract CMP 2.0 field getter for field anInt.
     *
     * @ejb.interface-method
     * @ejb.persistent-field
     *
     * @ejb.persistence column-name="int"
     */
    public abstract int getAnInt();

    /**
     * Abstract CMP 2.0 field setter for field anInt.
     *
     * @ejb.interface-method
     */
    public abstract void setAnInt(int anInt);

    /**
     * Abstract CMP 2.0 field getter for field aLong.
     *
     * @ejb.interface-method
     * @ejb.persistent-field
     *
     * @ejb.persistence column-name="long"
     */
    public abstract long getALong();

    /**
     * Abstract CMP 2.0 field setter for field aLong.
     *
     * @ejb.interface-method
     */
    public abstract void setALong(long aLong);

    /**
     * Abstract CMP 2.0 field getter for field aFloat.
     *
     * @ejb.interface-method
     * @ejb.persistent-field
     *
     * @ejb.persistence column-name="float"
     */
    public abstract float getAFloat();

    /**
     * Abstract CMP 2.0 field setter for field aFloat.
     *
     * @ejb.interface-method
     */
    public abstract void setAFloat(float aFloat);

    /**
     * Abstract CMP 2.0 field getter for field aDouble.
     *
     * @ejb.interface-method
     * @ejb.persistent-field
     *
     * @ejb.persistence column-name="double"
     */
    public abstract double getADouble();

    /**
     * Abstract CMP 2.0 field setter for field aDouble.
     *
     * @ejb.interface-method
     */
    public abstract void setADouble(double aDouble);

    /**
     * Abstract CMP 2.0 field getter for field anObject.
     * NOTE: most CMP engines will store the Object class as a serialized
     * object in a BLOB data type.
     *
     * @ejb.interface-method
     * @ejb.persistent-field
     *
     * @ejb.persistence column-name="object"
     */
    public abstract Object getAnObject();

    /**
     * Abstract CMP 2.0 field setter for field anObject.
     *
     * @ejb.interface-method
     */
    public abstract void setAnObject(Object anObject);

    /**
     * Abstract CMP 2.0 field getter for field anObjectArray.
     *
     * @ejb.interface-method
     * @ejb.persistent-field
     *
     * @ejb.persistence column-name="objectArray"
     */
    public abstract Object[] getAnObjectArray();

    /**
     * Abstract CMP 2.0 field setter for field anObjectArray.
     *
     * @ejb.interface-method
     */
    public abstract void setAnObjectArray(Object[] anObjectArray);

    /**
     * Abstract CMP 2.0 field getter for field aBooleanArray.
     *
     * @ejb.interface-method
     * @ejb.persistent-field
     *
     * @ejb.persistence column-name="booleanArray"
     */
    public abstract boolean[] getABooleanArray();

    /**
     * Abstract CMP 2.0 field setter for field aBooleanArray.
     *
     * @ejb.interface-method
     */
    public abstract void setABooleanArray(boolean[] aBooleanArray);

    /**
     * Abstract CMP 2.0 field getter for field aByteArray.
     *
     * @ejb.interface-method
     * @ejb.persistent-field
     *
     * @ejb.persistence column-name="byteArray"
     */
    public abstract byte[] getAByteArray();

    /**
     * Abstract CMP 2.0 field setter for field aByteArray.
     *
     * @ejb.interface-method
     */
    public abstract void setAByteArray(byte[] aByteArray);

    /**
     * Abstract CMP 2.0 field getter for field aCharArray.
     *
     * @ejb.interface-method
     * @ejb.persistent-field
     *
     * @ejb.persistence column-name="charArray"
     */
    public abstract char[] getACharArray();

    /**
     * Abstract CMP 2.0 field setter for field aCharArray.
     *
     * @ejb.interface-method
     */
    public abstract void setACharArray(char[] aCharArray);

    /**
     * Abstract CMP 2.0 field getter for field aShortArray.
     *
     * @ejb.interface-method
     * @ejb.persistent-field
     *
     * @ejb.persistence column-name="shortArray"
     */
    public abstract short[] getAShortArray();

    /**
     * Abstract CMP 2.0 field setter for field aShortArray.
     *
     * @ejb.interface-method
     */
    public abstract void setAShortArray(short[] aShortArray);

    /**
     * Abstract CMP 2.0 field getter for field anIntArray.
     *
     * @ejb.interface-method
     * @ejb.persistent-field
     *
     * @ejb.persistence column-name="intArray"
     */
    public abstract int[] getAnIntArray();

    /**
     * Abstract CMP 2.0 field setter for field anIntArray.
     *
     * @ejb.interface-method
     */
    public abstract void setAnIntArray(int[] anIntArray);

    /**
     * Abstract CMP 2.0 field getter for field aLongArray.
     *
     * @ejb.interface-method
     * @ejb.persistent-field
     *
     * @ejb.persistence column-name="longArray"
     */
    public abstract long[] getALongArray();

    /**
     * Abstract CMP 2.0 field setter for field aLongArray.
     *
     * @ejb.interface-method
     */
    public abstract void setALongArray(long[] aLongArray);

    /**
     * Abstract CMP 2.0 field getter for field aFloatArray.
     *
     * @ejb.interface-method
     * @ejb.persistent-field
     *
     * @ejb.persistence column-name="floatArray"
     */
    public abstract float[] getAFloatArray();

    /**
     * Abstract CMP 2.0 field setter for field aFloatArray.
     *
     * @ejb.interface-method
     */
    public abstract void setAFloatArray(float[] aFloatArray);

    /**
     * Abstract CMP 2.0 field getter for field aDoubleArray.
     *
     * @ejb.interface-method
     * @ejb.persistent-field
     *
     * @ejb.persistence column-name="doubleArray"
     */
    public abstract double[] getADoubleArray();

    /**
     * Abstract CMP 2.0 field setter for field aDoubleArray.
     *
     * @ejb.interface-method
     */
    public abstract void setADoubleArray(double[] aDoubleArray);
}