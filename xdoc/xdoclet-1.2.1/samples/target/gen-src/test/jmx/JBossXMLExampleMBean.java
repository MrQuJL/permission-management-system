/*
 * Generated file - Do not edit!
 */
package test.jmx;

/**
 * MBean interface.
 * @xdoclet-generated at 28-04-04
 * @copyright The XDoclet Team
 * @author XDoclet
 * @version 1.2.1
 */
public interface JBossXMLExampleMBean {

   /**
    * Get the String value.
    * @return the String value.
    */
  java.lang.String getString() ;

   /**
    * Get the Strings value.
    * @return the Strings value.
    */
  java.lang.String[][] getStrings() ;

   /**
    * Set the String value.
    * @param newString The new String value.
    */
  void setString(java.lang.String newString) ;

   /**
    * Get the Id value.
    * @return the Id value.
    * @param newId The new Id value.
    */
  java.lang.Integer getId() ;

   /**
    * Set the Id value.
    */
  void setId(java.lang.Integer newId) ;

   /**
    * Get the Value value.
    * @return the Value value.
    */
  java.lang.Integer getValue() ;

   /**
    * Get the Ref value.
    * @return the Ref value.
    */
  javax.management.ObjectName getRef() ;

   /**
    * Set the Ref value.
    * @param newRef The new Ref value.
    */
  void setRef(javax.management.ObjectName newRef) ;

   /**
    * Does something.
    * @param p1 a <code>String</code> value
    * @param p2 an <code>Integer</code> value
    */
  java.lang.String doSomething(java.lang.String p1,java.lang.Integer p2) ;

}
