package test.ejb.cmr;

/**
    * This class is part of Middlegen airlines, and it is a CMP EJB accessing the language table.
    *
    * @author <a href="http://middlegen.codehaus.org/">Middlegen</a>
    * @todo generate create methods which don't take pk as arg (and use an arbitrary pk generator internally)
    * @ejb.bean
    *    cmp-version="2.x"
    *    local-jndi-name="airline.LanguageLocalHome"
    *    name="Language"
    *    primkey-field="languageId"
    *    type="CMP"
    *    view-type="local"
    * @ejb.finder
    *    method-intf="LocalHome"
    *    query="SELECT OBJECT(o) FROM Language o"
    *    result-type-mapping="Local"
    *    signature="java.util.Collection findAll()"
    * @ejb.finder
    *    method-intf="LocalHome"
    *    query="SELECT DISTINCT OBJECT(o) FROM Language o WHERE o.languageCode = ?1"
    *    result-type-mapping="Local"
    *    signature="java.util.Collection findByLanguageCode(test.ejb.cmr.LanguageCodeLocal languageCode)"
    * @ejb.finder
    *    method-intf="LocalHome"
    *    query="SELECT DISTINCT OBJECT(o) FROM Language o WHERE o.name = ?1"
    *    result-type-mapping="Local"
    *    signature="java.util.Collection findByName(java.lang.String name)"
    * @ejb.persistence
    *    table-name="language"
    * @weblogic.data-source-name airline.database
    * @XXweblogic.data-source-name $table.datasourceName
    * @XXweblogic.resource-description
    * @orion.bean
    *    data-source="airline.database"
    */
public abstract class LanguageBean implements javax.ejb.EntityBean {

   /**
    * Context set by container
    */
   private javax.ejb.EntityContext _entityContext;

   /**
    * Returns the languageId
    *
    * @todo support OracleClob,OracleBlob on WLS
    * @return the languageId
    * @ejb.persistent-field
    * @ejb.persistence
    *    column-name="language_id"
    * @ejb.interface-method
    *    view-type="local"
    * @ejb.pk-field
    */
   public abstract java.lang.Integer getLanguageId();

   /**
    * Sets the languageId
    *
    * @param java.lang.Integer the new languageId value
    */
   public abstract void setLanguageId(java.lang.Integer languageId);

   /**
    * Returns the languageCodeIdFk
    *
    * @todo support OracleClob,OracleBlob on WLS
    * @return the languageCodeIdFk
    * @ejb.persistent-field
    * @ejb.persistence
    *    column-name="language_code_id_fk"
    */
   public abstract java.lang.Integer getLanguageCodeIdFk();

   /**
    * Sets the languageCodeIdFk
    *
    * @param java.lang.Integer the new languageCodeIdFk value
    */
   public abstract void setLanguageCodeIdFk(java.lang.Integer languageCodeIdFk);

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
    * Returns the related test.ejb.cmr.LanguageCodeLocal
    *
    * @return the related test.ejb.cmr.LanguageCodeLocal
    * @ejb.interface-method
    *    view-type="local"
    * @ejb.relation
    *    name="language-language_code"
    *    role-name="language-has-language_code"
    * @weblogic.column-map
    *    foreign-key-column="language_code_id_fk"
    * @jboss.relation
    *    fk-column="language_code_id_fk"
    *    related-pk-field="languageCodeId"
    */
   public abstract test.ejb.cmr.LanguageCodeLocal getLanguageCode();

   /**
    * Sets the related test.ejb.cmr.LanguageCodeLocal
    *
    * @param test.ejb.cmr.LanguageLocal the related languageCode
    * @ejb.interface-method
    *    view-type="local"
    * @param languageCode the new CMR value
    */
   public abstract void setLanguageCode(test.ejb.cmr.LanguageCodeLocal languageCode);

   /**
    * Returns a collection of related test.ejb.cmr.CityLocal
    *
    * @return a collection of related test.ejb.cmr.CityLocal
    * @ejb.interface-method
    *    view-type="local"
    * @ejb.relation
    *    name="city-language"
    *    role-name="language-has-city"
    * @weblogic.relation
    *    join-table-name="language_city"
    * @weblogic.column-map
    *    foreign-key-column="language_id_fk"
    *    key-column="language_id"
    * @jboss.relation
    *    fk-column="city_id_fk"
    *    related-pk-field="cityId"
	*
	*    PLEASE note that jboss.relation declares the *related* PK
	*    field and the FK column in the *current* mapped table.
    */
   public abstract java.util.Collection getCities();

   /**
    * Sets a collection of related test.ejb.cmr.CityLocal
    *
    * @param a collection of related test.ejb.cmr.CityLocal
    * @ejb.interface-method
    *    view-type="local"
    * @param cities the new CMR value
    */
   public abstract void setCities(java.util.Collection cities);

    /**
    * This create method takes only mandatory (non-nullable) parameters. The pk columns must be provided. When the client invokes a create method, the EJB container invokes the ejbCreate method. Typically, an ejbCreate method in an entity bean performs the following tasks: <UL> <LI>Inserts the entity state into the database.</LI> <LI>Initializes the instance variables.</LI> <LI>Returns the primary key.</LI> </UL>
    *
    * @param languageId the languageId value
    * @param name the name value
    * @param languageCode mandatory CMR field
    * @return the primary key of the new instance
    * @ejb.create-method
    */
   public java.lang.Integer ejbCreate( java.lang.Integer languageId, java.lang.String name, test.ejb.cmr.LanguageCodeLocal languageCode ) throws javax.ejb.CreateException {
      setLanguageId(languageId);
      setName(name);
      // EJB 2.0 spec says return null for CMP ejbCreate methods.
      return null;
   }

   /**
    * The container invokes thos method immediately after it calls ejbCreate.
    *
    * @param languageId the languageId value
    * @param name the name value
    * @param languageCode mandatory CMR field
    */
   public void ejbPostCreate( java.lang.Integer languageId, java.lang.String name, test.ejb.cmr.LanguageCodeLocal languageCode ) throws javax.ejb.CreateException {
      // Set CMR fields
      setLanguageCode(languageCode);
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
