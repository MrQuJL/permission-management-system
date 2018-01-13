/*
 * Copyright (c) 2001, 2002 The XDoclet team
 * All rights reserved.
 */

package test.jmx;

import javax.management.ObjectName;


/**
    * JBossXMLExample.java Created: Sun Feb 17 23:10:04 2002
    *
    * @author <a href="mailto:d_jencks@users.sourceforge.net">David Jencks</a>
    * @version
    * @jmx.mbean
    *    name="jboss.test.xdoclet:service=Sample"
    *    currencyTimeLimit="10"
    *    description="sample for jboss xmbean.dtd"
    *    persistLocation="pl1"
    *    persistName="JBossXMLExample1"
    *    persistPeriod="10"
    *    persistPolicy="Never"
    *    state-action-on-update="RESTART"
    *    display-name="Sample xmbean for jboss"
    *    persistence-manager="org.jboss.mx.persistence.ObjectStreamPersistenceManager"
    * @jmx.descriptor
    *    name="classdescriptor"
    *    value="classdescriptorvalue"
    * @jmx.notification
    *    currencyTimeLimit="20"
    *    description="first notification"
    *    name="javax.management.SomeEvent"
    *    notificationType="xd.example.first,xd.example.second"
    *    persistLocation="pl2"
    *    persistName="JBossXMLExample2"
    *    persistPeriod="20"
    *    persistPolicy="Never"
    * @jmx.notification
    *    description="second notification"
    *    name="javax.management.SomeOtherEvent"
    *    notificationType="xd.example.third,xd.example.fourth"
    *
    * @jmx.managed-attribute
    *    name="ArtificialAttribute"
    *    description="artificial attribute not impemeneted in class"
    *    type="java.lang.String"
    *
    * @jmx.managed-operation
    *    name="artificialOperation"
    *    description="artificial operation not implemented in class"
    *    return-type="java.lang.String"
    *    interceptor-classes="org.jboss.TestMBeanInterceptor"
    * @jmx.managed-parameter
    *    managed-operation="artificialOperation"
    *    name="firstParam"
    *    type="java.lang.Integer"
    * @jmx.managed-parameter
    *    managed-operation="artificialOperation"
    *    name="secondParam"
    *    type="java.lang.String"
    *
    * @jboss.service servicefile="jboss"
    * @jboss.xmbean
    *
    * @jboss.depends object-name="jmx.test:service=Test1"
    * @jboss.depends object-name="jmx.test:service=Test2"
    */

public class JBossXMLExample
{

   private String string;
   private Integer id;
   private ObjectName ref;

   /**
    * Creates a new <code>JBossXMLExample</code> instance.
    *
    * @jmx:managed-constructor description="default constructor"
    */
   public JBossXMLExample ()
   {

   }

   /**
    * Creates a new <code>JBossXMLExample</code> instance.
    *
    * @param string a <code>String</code> value
    * @param id an <code>Integer</code> value
    * @jmx:managed-constructor servicefile="jboss"
    * @jmx.managed-parameter name="stringParam" type="java.lang.String" value="Hi"
    * @jmx.managed-parameter name="intParam" type="java.lang.Integer" value="3"
    */
   public JBossXMLExample (String string, Integer id)
   {
      this.string = string;
      this.id = id;
   }


   /**
    * Get the String value.
    *
    * @return the String value.
    * @jmx.managed-attribute
    *    access="read-only"
    *    currencyTimeLimit="30"
    *    description="string attribute"
    *    persistPeriod="30"
    *    persistPolicy="Never"
    *    value="this is a string"
    * @jmx.descriptor
    *    name="attributedescriptor"
    *    value="attributedescriptorvalue"
    */
   public String getString()
   {
      return string;
   }

   /**
    * Get the Strings value.
    *
    * @return the Strings value.
    * @jmx.managed-attribute
    *    access="read-only"
    *    currencyTimeLimit="30"
    *    description="strings attribute"
    *    persistPeriod="30"
    *    persistPolicy="Never"
    *    value="these are strings"
    * @jmx.descriptor
    *    name="attributedescriptor"
    *    value="attributedescriptorvalue"
    */
  public String[][] getStrings()
  {
    return new String[][]{ new String[] {"one", "two", "three"},
                         new String[] {"uno", "dos", "tres"}};
  }

   /**
    * Set the String value.
    *
    * @param newString The new String value.
    * @jmx.managed-attribute
    */
   public void setString(String newString)
   {
      this.string = newString;
   }


   /**
    * Get the Id value.
    *
    * @return the Id value.
    * @param newId The new Id value.
    * @jmx.managed-attribute
    *    access="write-only"
    *    currencyTimeLimit="40"
    *    description="id attribute"
    *    persistPeriod="40"
    *    persistPolicy="Never"
    *    value="5"
    */
   public Integer getId()
   {
      return id;
   }

   /**
    * Set the Id value.
    *
    * @jmx.managed-attribute
    */
   public void setId(Integer newId)
   {
      this.id = newId;
   }

   Integer value;

   /**
    * Get the Value value.
    *
    * @return the Value value.
    * @jmx.managed-attribute
    *    access="read-write"
    *    currencyTimeLimit="50"
    *    description="id attribute"
    *    persistPeriod="50"
    *    persistPolicy="Never"
    *    state-action-on-update="KEEP_RUNNING"
    */
   public Integer getValue()
   {
      return value;
   }

   /**
    * Set the Value value.
    *
    * @param newValue The new Value value.
    */
   public void setValue(Integer newValue)
   {
      this.value = newValue;
   }


   /**
    * Get the Ref value.
    *
    * @return the Ref value.
    * @jmx.managed-attribute
    *    access="read-write"
    *    description="Object Name attribute"
    *    value="xdoclet.test:service=RefTest"
    */
   public ObjectName getRef()
   {
      return ref;
   }

   /**
    * Set the Ref value.
    *
    * @param newRef The new Ref value.
    * @jmx.managed-attribute
    */
   public void setRef(ObjectName newRef)
   {
      this.ref = newRef;
   }



   /**
    * Does something.
    *
    * @param p1 a <code>String</code> value
    * @param p2 an <code>Integer</code> value
    * @jmx.managed-operation
    *    description="operation with 2 arguments"
    *    impact="INFO"
    * @jmx.managed-parameter name="stringParam1" type="java.lang.String" description="first string param"
    * @jmx.managed-parameter name="integerParam2" type="java.lang.Integer" description="other param"
    * @jmx.descriptor
    *    name="operationdescriptor"
    *    value="operationdescriptorvalue"
    */
   public String doSomething(String p1, Integer p2)
   {
      return p1 + p2;
   }

}// JBossXMLExample

/*
This breaks the build of the samples

class PackageLevelClass {
}
*/
