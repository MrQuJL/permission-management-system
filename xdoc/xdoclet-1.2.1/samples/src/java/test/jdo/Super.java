/*
 * Copyright (c) 2002 The XDoclet team
 * All rights reserved.
 */
package test.jdo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *  NOTE!! PACKAGE EXTENSIONS DON"T WORK.  This is probably due to the
 *  "for all classes in package" iterator not being able to reset and
 *  scan the classes again.
 *
 * @jdo.persistence-capable
 *
 * @jdo.package-vendor-extension
 *      vendor-name="test"
 *      key="package-key1"
 *      value="package-value1"
 * @jdo.package-vendor-extension
 *      vendor-name="test"
 *      key="package-key2"
 *      value="package-value2"
 *      content="<extension vendor-name=\"test\" key=\"package-nested-key\" value=\"package-value3\">"
 *
 * @jdo.class-vendor-extension
 *      vendor-name="test"
 *      key="class-key1"
 *      value="class-value1"
 * @jdo.class-vendor-extension
 *      vendor-name="test"
 *      key="class-key2"
 *      value="class-value2"
 *      content="<extension vendor-name=\"test\" key=\"class-nested-key\" value=\"class-value3\">"
 *
 * @author  <a href="mailto:youremail@yourdomain.com">youremail@yourdomain.com</a>
 */
public class Super {
    /**
     * @jdo.field
     *     default-fetch-group="true"
     *     null-value="exception"
     * @jdo.field-vendor-extension
     *      vendor-name="test"
     *      key="field-key1"
     *      value="field-value1"
     * @jdo.field-vendor-extension
     *      vendor-name="test"
     *      key="field-key2"
     *      value="field-value2"
     *      content="<extension vendor-name=\"test\" key=\"field-nested-key\" value=\"field-value3\">"
     */
    private int superInt;

    /**
     * @jdo.field
     *     default-fetch-group="true"
     * @tjdo.field column-length="200"
     */
    private String superString;


    /**
     * @jdo.field
     *     default-fetch-group="true"
     * @tjdo.field column-length="15" column-precision="15" column-scale="5"
     */
    private BigDecimal superBigDecimal;

    /**
     * @jdo.field
     *     collection-type="collection"
     *     embedded-element="false"
     *     element-type="test.jdo.SuperChild"
     *     default-fetch-group="true"
     * @jdo.collection-vendor-extension
     *      vendor-name="test"
     *      key="collection-key1"
     *      value="collection-value1"
     * @jdo.collection-vendor-extension
     *      vendor-name="test"
     *      key="collection-key2"
     *      value="collection-value2"
     *      content="<extension vendor-name=\"test\" key=\"collection-nested-key\" value=\"collection-value3\">"
     * @tjdo.field
     *     owner-field="tjdoOwner"
     */
    private List superList = new ArrayList();

    /**
     * @jdo.field
     *     collection-type="map"
     *     default-fetch-group="true"
     *     key-type="test.jdo.MapKey"
     *     embedded-key="true"
     *     value-type="test.jdo.MapValue"
     *     embedded-value="false"
     * @jdo.map-vendor-extension
     *      vendor-name="test"
     *      key="map-key1"
     *      value="map-value1"
     * @jdo.map-vendor-extension
     *      vendor-name="test"
     *      key="map-key2"
     *      value="map-value2"
     *      content="<extension vendor-name=\"test\" key=\"map-nested-key\" value=\"map-value3\">"
     * @tjdo.field
     *     owner-field="tjdoOwner"
     *     key-field="tjdoKey"
     */
    private Map superMap = new HashMap();

    /**
     * @jdo.field
     *     collection-type="array"
     *     default-fetch-group="true"
     *     element-type="test.jdo.SuperChild"
     *     embedded="false"
     *     embedded-element="true"
     * @jdo.array-vendor-extension
     *      vendor-name="test"
     *      key="array-key1"
     *      value="array-value1"
     * @jdo.array-vendor-extension
     *      vendor-name="test"
     *      key="array-key2"
     *      value="array-value2"
     *      content="<extension vendor-name=\"test\" key=\"array-nested-key\" value=\"array-value3\">"
     */
    private SuperChild[] superChildren = new SuperChild[10];

    /**
     * @jdo.field
     *     collection-type="collection"
     *     embedded-element="true"
     *     element-type="java.lang.String"
     *     default-fetch-group="true"
     * @tjdo.field
     *     owner-field="tjdoOwner"
     *     element-length="256"
     */
    private List StringList = new ArrayList();

    /**
     * @jdo.field
     *     collection-type="map"
     *     default-fetch-group="true"
     *     key-type="java.lang.String"
     *     embedded-key="true"
     *     value-type="java.math.BigDecimal"
     *     embedded-value="true"
     * @tjdo.field
     *     owner-field="tjdoOwner"
     *     key-field="tjdoKey"
     *     key-length="30"
     *     value-precision="18"
     *     value-scale="6"
     */
    private Map lengthMap = new HashMap();

}
