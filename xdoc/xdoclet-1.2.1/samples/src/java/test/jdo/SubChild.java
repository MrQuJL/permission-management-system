/*
 * Copyright (c) 2002 The XDoclet team
 * All rights reserved.
 */
package test.jdo;

import java.util.ArrayList;
import java.util.List;

/**
 * @jdo.persistence-capable
 *     persistence-capable-superclass="test.jdo.SuperChild"
 *
 * @author  <a href="mailto:youremail@yourdomain.com">youremail@yourdomain.com</a>
 */
public class SubChild extends SuperChild {
    /**
     * @jdo.field
     *     collection-type="List"
     *     default-fetch-group="true"
     *     element-type="test.jdo.Sub"
     */
    private List subParents = new ArrayList();

    /**
     * @jdo.field
     *     collection-type="List"
     *     element-type="test.jdo.SubChild"
     */
    private List friends = new ArrayList();
}
