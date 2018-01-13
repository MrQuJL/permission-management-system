
package test.web;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import org.apache.velocity.servlet.VelocityServlet;

/**
 * Simple Servlet. This servlet illustrates that your servlet can be any
 * subclass of HttpServlet, as long as all the classes
 * in the hierarchy (and any classes they depend on) are on the classpath.
 *
 * @web.servlet
 *     display-name="Simple Servlet"
 *     load-on-startup="1"
 *     name="SimpleServlet"
 *
 * @web.servlet-init-param
 *     name="param1"
 *     value="value1"
 *
 * @web.servlet-init-param
 *     name="param2"
 *     value="value2"
 *
 * @web.servlet-mapping
 *     url-pattern="/simple/*"
 *
 * @web.resource-ref
 *     name="Queue"
 *     auth="Container"
 *     description="Test resource reference"
 *     type="javax.jms.Queue"
 *
 * @web.ejb-ref
 *     name="Account"
 *     description="A test reference to the Account EJB"
 *     home="test.interfaces.AccountHome"
 *     link="Account"
 *     remote="test.interfaces.Account"
 *     type="Entity"
 *
 * @jboss.resource-ref
 *     jndi-name="queue/A"
 *     res-ref-name="Queue"
 *
 * @jboss.ejb-ref-jndi
 *     jndi-name="ejb/bank/Account"
 *     ref-name="Account"
 *
 * @author  <a href="mailto:youremail@yourdomain.com">youremail@yourdomain.com</a>
 */
public class SimpleServlet extends VelocityServlet {
    /**
     * Called by the server (via the service method) to allow a servlet to handle a POST request.
     * The HTTP POST method allows the client to send data of unlimited length to the Web server
     * a single time and is useful when posting information such as credit card numbers.
     */
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        // just print Hi!
        response.getWriter().println("Hi!");
    }
}