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
public class SuperChild {
    /**
     * @jdo.field
     *     default-fetch-group="true"
     *     embedded="false"
     */
    private Super superParent;

    /**
     * @jdo.field
     * @tjdo.field
     *     collection-field="superList"
     *     map-field="superMap"
     */
   private Super tjdoOwner;
}
