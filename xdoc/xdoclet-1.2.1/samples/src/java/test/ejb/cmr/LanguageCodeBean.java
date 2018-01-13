package test.ejb.cmr;

/**
    * This class is part of Middlegen airlines, and it is a CMP EJB accessing the language_code table.
    *
    * @author <a href="http://middlegen.codehaus.org/">Middlegen</a>
    * @todo generate create methods which don't take pk as arg (and use an arbitrary pk generator internally)
    * @ejb.bean
    *    cmp-version="2.x"
    *    local-jndi-name="airline.LanguageCodeLocalHome"
    *    name="LanguageCode"
    *    primkey-field="languageCodeId"
    *    type="CMP"
    *    view-type="local"
    * @ejb.finder
    *    method-intf="LocalHome"
    *    query="SELECT OBJECT(o) FROM LanguageCode o"
    *    result-type-mapping="Local"
    *    signature="java.util.Collection findAll()"
    * @ejb.finder
    *    method-intf="LocalHome"
    *    query="SELECT DISTINCT OBJECT(o) FROM LanguageCode o WHERE o.language = ?1"
    *    result-type-mapping="Local"
    *    signature="java.util.Collection findByLanguage(test.ejb.cmr.LanguageLocal language)"
    * @ejb.finder
    *    method-intf="LocalHome"
    *    query="SELECT DISTINCT OBJECT(o) FROM LanguageCode o WHERE o.name = ?1"
    *    result-type-mapping="Local"
    *    signature="java.util.Collection findByName(java.lang.String name)"
    * @ejb.persistence
    *    table-name="language_code"
    * @weblogic.data-source-name airline.database
    * @XXweblogic.data-source-name $table.datasourceName
    * @XXweblogic.resource-description
    * @orion.bean
    *    data-source="airline.database"
    */
public abstract class LanguageCodeBean implements javax.ejb.EntityBean {

   /**
    * Context set by container
    */
   private javax.ejb.EntityContext _entityContext;

   /**
    * Returns the languageCodeId
    *
    * @todo support OracleClob,OracleBlob on WLS
    * @return the languageCodeId
    * @ejb.persistent-field
    * @ejb.persistence
    *    column-name="language_code_id"
    * @ejb.interface-method
    *    view-type="local"
    * @ejb.pk-field
    */
   public abstract java.lang.Integer getLanguageCodeId();

   /**
    * Sets the languageCodeId
    *
    * @param java.lang.Integer the new languageCodeId value
    */
   public abstract void setLanguageCodeId(java.lang.Integer languageCodeId);

   /**
    * Returns the name
    *
    * @todo support OracleClob,OracleBlob on WLS
    * @return the name
    * @ejb.persistent-field
    * @ejb.persistence
    *    column-name="name"
    * @ejb.interface-method
    *    view-type="local"
    */
   public abstract java.lang.String getName();

   /**
    * Sets the name
    *
    * @param java.lang.String the new name value
    * @ejb.interface-method
    *    view-type="local"
    */
   public abstract void setName(java.lang.String name);

    /**
    * Returns the related test.ejb.cmr.LanguageLocal
    *
    * @return the related test.ejb.cmr.LanguageLocal
    * @ejb.interface-method
    *    view-type="local"
    * @ejb.relation
    *    name="language-language_code"
    *    role-name="language_code-has-language"
    * @weblogic.target-column-map
    *    foreign-key-column="language_code_id_fk"
    * @jboss Unidirectional 1->N relationship unsupported by XDoclet
    */
   public abstract test.ejb.cmr.LanguageLocal getLanguage();

   /**
    * Sets the related test.ejb.cmr.LanguageLocal
    *
    * @param test.ejb.cmr.LanguageCodeLocal the related language
    * @ejb.interface-method
    *    view-type="local"
    * @param language the new CMR value
    */
   public abstract void setLanguage(test.ejb.cmr.LanguageLocal language);

    /**
    * This create method takes only mandatory (non-nullable) parameters. The pk columns must be provided. When the client invokes a create method, the EJB container invokes the ejbCreate method. Typically, an ejbCreate method in an entity bean performs the following tasks: <UL> <LI>Inserts the entity state into the database.</LI> <LI>Initializes the instance variables.</LI> <LI>Returns the primary key.</LI> </UL>
    *
    * @param languageCodeId the languageCodeId value
    * @param name the name value
    * @param language mandatory CMR field
    * @return the primary key of the new instance
    * @ejb.create-method
    */
   public java.lang.Integer ejbCreate( java.lang.Integer languageCodeId, java.lang.String name, test.ejb.cmr.LanguageLocal language ) throws javax.ejb.CreateException {
      setLanguageCodeId(languageCodeId);
      setName(name);
      // EJB 2.0 spec says return null for CMP ejbCreate methods.
      return null;
   }

   /**
    * The container invokes thos method immediately after it calls ejbCreate.
    *
    * @param languageCodeId the languageCodeId value
    * @param name the name value
    * @param language mandatory CMR field
    */
   public void ejbPostCreate( java.lang.Integer languageCodeId, java.lang.String name, test.ejb.cmr.LanguageLocal language ) throws javax.ejb.CreateException {
      // Set CMR fields
      setLanguage(language);
   }

     // Implementation of the javax.ejb.EntityBean interface methods

   /**
    * The container invokes setEntityContext just once - when it creates the bean instance.
    *
    */
   public void setEntityContext(javax.ejb.EntityContext entityContext) {
      _entityContext = entityContext;
   }

   /**
    * At the end of the life cycle, the container removes the instance from the pool and invokes this method.
    *
    */
   public void unsetEntityContext() {
      _entityContext = null;
   }

   /**
    * The container invokes this method to instruct the instance to synchronize its state by loading it state from the underlying database.
    *
    */
   public void ejbLoad() {
   }

   /**
    * The container invokes this method when the instance is taken out of the pool of available instances to become associated with a specific EJB object.
    *
    */
   public void ejbActivate() {
   }

   /**
    * The container invokes this method on an instance before the instance becomes disassociated with a specific EJB object.
    *
    */
   public void ejbPassivate() {
   }

   /**
    * The container invokes this method before it removes the EJB object that is currently associated with the instance.
    *
    */
   public void ejbRemove() throws javax.ejb.RemoveException {
   }

   /**
    * The container invokes this method to instruct the instance to synchronize its state by storing it to the underlying database.
    *
    */
   public void ejbStore() {
   }
}
