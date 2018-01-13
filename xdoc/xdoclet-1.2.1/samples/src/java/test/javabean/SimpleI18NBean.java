package test.javabean;

/**
 * Example of a JavaBean with tags to generate the associated BeanInfo class.
 *
 * @javabean.class
 *     displayName="Simple Bean"
 *     name="SimpleI18NBean"
 *     shortDescription="Simple example of JavaBean BeanInfo generation"
 *
 * @javabean.icons
 *     color16="/toolbarButtonGraphics/general/Stop16.gif"
 *
 * @javabean.attribute
 *    name="literal"
 *    value="A sample attribute"
 *
 * @javabean.attribute
 *    name="expression"
 *    value="new StringBuffer()"
 *    rtexpr="true"
 *
 */
public class SimpleI18NBean extends SimpleBean {
  
    /** Constructs a new SimpleI18NBean. */
    public SimpleI18NBean() {
    }

    /**
     * The first method
     *
     * @javabean.method
     *     displayName="My First Method"
     *     name="myFirstMethod"
     *     shortDescription="Example of method without parameters"
     */
    public void myFirstMethod() {
    }

    /**
     * The second method
     *
     * @param param1 Description of the Parameter 1
     * @param param2 Description of the Parameter 2
     *
     * @javabean.method
     *     displayName="My Second Method"
     *     name="mySecondMethod"
     *     shortDescription="Example of method with parameters"
     *
     * @javabean.param
     *     class="java.lang.String"
     *     displayName="Parameter 1"
     *     name="param1"
     *
     * @javabean.param
     *     class="boolean"
     *     displayName="Parameter 2"
     *     name="param2"
     */
    public void mySecondMethod(String param1, boolean param2) {
    }
}