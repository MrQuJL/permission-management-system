package test.jmx;

/**
 * Example of a very simple JMX MBean
 *
 * @jmx.mbean
 *   name=":service=SimpleJMX"
 * @jboss.service
 *   servicefile="jboss-simple"
 * @jboss.service
 *   classpath="lib"
 * @jboss.service
 *   classpath="otherPath"
 *   archives="someLib.jar"
 */
public class SimpleJMX implements test.jmx.SimpleJMXMBean {
    /**
     * Create a greeting.
     *
     * @jmx.managed-operation
     */
    public String hello(String name) {
        return "Hello" + name + "!";
    }

}
