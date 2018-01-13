/*
 * Copyright (c) 2002 The XDoclet team
 * All rights reserved.
 */
package test.jdo;

/**
 * @jdo.persistence-capable
 *     identity-type="datastore"
 *     requires-extent="true"
 *
 * @author  <a href="mailto:youremail@yourdomain.com">youremail@yourdomain.com</a>
 */
public class MapValue {
    /**
     * @jdo.field
     *     embedded="true"
     */
    private MapKey owner;

    /**
     * @jdo.field
     * @tjdo.field
     *     map-field="superMap"
     */
   private Super tjdoOwner;

   private MapKey tjdoKey;

}
