/*
 * Copyright (c) 2002 The XDoclet team
 * All rights reserved.
 */
package test.jdo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @jdo.persistence-capable
 *     identity-type="datastore"
 *     persistence-capable-superclass="test.jdo.Super"
 *
 * @author  <a href="mailto:youremail@yourdomain.com">youremail@yourdomain.com</a>
 */
public class Sub extends Super {
    /**
     * @jdo.field
     *     embedded="true"
     *     null-value="default"
     */
    private int subInt;

    /**
     * @jdo.field
     */
    private String subString;

    /**
     * @jdo.field
     *     collection-type="collection"
     *     default-fetch-group="true"
     *     element-type="test.jdo.SubChild"
     */
    private List subList = new ArrayList();

    /**
     * @jdo.field
     *     collection-type="map"
     *     embedded-key="true"
     *     embedded-value="true"
     *     key-type="test.jdo.MapKey"
     *     value-type="test.jdo.MapValue"
     */
    private Map subMap = new HashMap();

    /**
     * @jdo.field
     *     collection-type="array"
     *     default-fetch-group="false"
     *     embedded-element="false"
     *     element-type="test.jdo.SubChild"
     */
    private SubChild[] subChildren = new SubChild[10];
}
