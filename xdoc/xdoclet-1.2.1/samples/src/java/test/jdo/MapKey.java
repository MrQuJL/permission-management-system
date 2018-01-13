/*
 * Copyright (c) 2002 The XDoclet team
 * All rights reserved.
 */
package test.jdo;

/**
 * @jdo.persistence-capable
 *     identity-type="datastore"
 *     objectid-class="java.lang.Long"
 *     requires-extent="false"
 *
 * @author  <a href="mailto:youremail@yourdomain.com">youremail@yourdomain.com</a>
 */
public class MapKey {
    /**
     * @jdo.field
     *    embedded="true"
     */
    private Super owner;
}
