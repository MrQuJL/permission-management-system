package test.ejb.cmr;

/**
    * This class is part of Middlegen airlines, and it is a CMP EJB accessing the city table.
    *
    * @author <a href="http://middlegen.codehaus.org/">Middlegen</a>
    * @todo generate create methods which don't take pk as arg (and use an arbitrary pk generator internally)
    * @ejb.bean
    *    cmp-version="2.x"
    *    local-jndi-name="airline.CityLocalHome"
    *    name="City"
    *    primkey-field="cityId"
    *    type="CMP"
    *    view-type="local"
    * @ejb.finder
    *    method-intf="LocalHome"
    *    query="SELECT OBJECT(o) FROM City o"
    *    result-type-mapping="Local"
    *    signature="java.util.Collection findAll()"
    * @ejb.finder
    *    method-intf="LocalHome"
    *    query="SELECT DISTINCT OBJECT(o) FROM City o WHERE o.name = ?1"
    *    result-type-mapping="Local"
    *    signature="java.util.Collection findByName(java.lang.String name)"
    * @ejb.persistence
    *    table-name="city"
    * @weblogic.data-source-name airline.database
    * @XXweblogic.data-source-name $table.datasourceName
    * @XXweblogic.resource-description
    * @orion.bean
    *    data-source="airline.database"
    */
public abstract class CityBean implements javax.ejb.EntityBean {

   /**
    * Context set by container
    */
   private javax.ejb.EntityContext _entityContext;

   /**
    * Returns the cityId
    *
    * @todo support OracleClob,OracleBlob on WLS
    * @return the cityId
    * @ejb.persistent-field
    * @ejb.persistence
    *    column-name="city_id"
    * @ejb.interface-method
    *    view-type="local"
    * @ejb.pk-field
    */
   public abstract java.lang.Integer getCityId();

   /**
    * Sets the cityId
    *
    * @param java.lang.Integer the new cityId value
    */
   public abstract void setCityId(java.lang.Integer cityId);

   /**
    * Returns the countryIdFk
    *
    * @todo support OracleClob,OracleBlob on WLS
    * @return the countryIdFk
    * @ejb.persistent-field
    * @ejb.persistence
    *    column-name="country_id_fk"
    */
   public abstract java.lang.Integer getCountryIdFk();

   /**
    * Sets the countryIdFk
    *
    * @param java.lang.Integer the new countryIdFk value
    */
   public abstract void setCountryIdFk(java.lang.Integer countryIdFk);

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
    * Returns a collection of related test.ejb.cmr.LanguageLocal
    *
    * @return a collection of related test.ejb.cmr.LanguageLocal
    * @ejb.interface-method
    *    view-type="local"
    * @ejb.relation
    *    name="city-language"
    *    role-name="city-has-language"
    * @weblogic.relation
    *    join-table-name="language_city"
    * @weblogic.column-map
    *    foreign-key-column="city_id_fk"
    *    key-column="city_id"
    * @jboss.relation
    *    fk-column="language_id_fk"
    *    related-pk-field="languageId"
    */
   public abstract java.util.Collection getLanguages();

   /**
    * Sets a collection of related test.ejb.cmr.LanguageLocal
    *
    * @param a collection of related test.ejb.cmr.LanguageLocal
    * @ejb.interface-method
    *    view-type="local"
    * @param languages the new CMR value
    */
   public abstract void setLanguages(java.util.Collection languages);

    /**
    * This create method takes only mandatory (non-nullable) parameters. The pk columns must be provided. When the client invokes a create method, the EJB container invokes the ejbCreate method. Typically, an ejbCreate method in an entity bean performs the following tasks: <UL> <LI>Inserts the entity state into the database.</LI> <LI>Initializes the instance variables.</LI> <LI>Returns the primary key.</LI> </UL>
    *
    * @param cityId the cityId value
    * @param name the name value
    * @return the primary key of the new instance
    * @ejb.create-method
    */
   public java.lang.Integer ejbCreate( java.lang.Integer cityId, java.lang.String name ) throws javax.ejb.CreateException {
      setCityId(cityId);
      setName(name);
      // EJB 2.0 spec says return null for CMP ejbCreate methods.
      return null;
   }

   /**
    * The container invokes thos method immediately after it calls ejbCreate.
    *
    * @param cityId the cityId value
    * @param name the name value
    */
   public void ejbPostCreate( java.lang.Integer cityId, java.lang.String name ) throws javax.ejb.CreateException {
      // Set CMR fields
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
