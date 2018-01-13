package test.javabean;

/**
 * Example of a JavaBean with tags to generate the associated BeanInfo class.
 *
 * @javabean.class
 *     displayName="Simple Bean"
 *     name="SimpleBean"
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
 */
public class SimpleBean {
    /** An int field. */
    protected int count = 0;
    /** A boolean field. */
    protected boolean flag = false;
    /** A String field. */
    protected String name = "";
    /** A Class field. */
    protected Class parent = null;

    /** Constructs a new SimpleBean. */
    public SimpleBean() {
    }

    /**
     * The first method
     *
     * @javabean.method
     *    displayName="My First Method"
     *    name="myFirstMethod"
     *    shortDescription="Example of method without parameters"
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
	/**	
	 * @javabean.property displayName="Class" bound="true" hidden="false" shortDescription="Class of the entry"
	 */
	public boolean isFlag() {
		return flag;
	}
	
	public void setFlag(boolean flag) {
		this.flag = flag;
	}
	
	
	public String getName() {
		return name;
	}
	/**
	 * @javabean.property displayName="Name" shortDescription="Name of the entry"
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * @javabean.property displayName="Message(s)" shortDescription="Number of messages in Queue"
	 * readOnly="true"
	 */
	public int getCount() {
		return count;
	}
	/**
	 * @javabean.property displayName="Full Path"
	 *     shortDescription="Absolute path of the context"
	 */	
	public Class getParent() {
		return parent;
	}
}