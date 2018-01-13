
package test.web;

import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;

/**
 * Simple context listener, prints changes to the console.
 *
 * <p>A ServletContextListener recieves notifications about changes to the servlet context of the web
 * application they are part of. NOTE: this is a Servlet 2.3 only feature.</p>
 *
 * <p>A HttpSessionListener receives notifications about changes to the list of active sessions in
 * a web application. NOTE: this is a Servlet 2.3 only feature.</p>
 *
 * @web.listener
 *
 * @author  <a href="mailto:youremail@yourdomain.com">youremail@yourdomain.com</a>
 */
public final class SimpleListener implements ServletContextListener, HttpSessionListener {
    /** Constructs a new SimpleListener. */
    public SimpleListener() {}

    /** Notification that the web application is ready to process requests. */
    public void contextInitialized(ServletContextEvent sce) {
        sce.getServletContext().log("The servlet context has been initialized, the web application is ready to process requests.");
    }

    /** Notification that the servlet context is about to be shut down. */
    public void contextDestroyed(ServletContextEvent sce) {
        sce.getServletContext().log("The servlet context is about to be shut down.");
    }

    /** Notification that a session was created. */
    public void sessionCreated(HttpSessionEvent hse) {
        HttpSession session = hse.getSession();
        session.getServletContext().log("A session was created, id: " + session.getId());
    }

    /** Notification that a session was invalidated. */
    public void sessionDestroyed(HttpSessionEvent hse) {
        HttpSession session = hse.getSession();
        session.getServletContext().log("A session was invalidated, id: " + session.getId());
    }
}