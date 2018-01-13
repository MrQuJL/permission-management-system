
package test.web;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * Timer filter that logs the request processing time in milliseconds to the console.
 *
 * <p>A filter is an object that performs filtering tasks on either the request to a resource
 * (a servlet or static content), or on the response from a resource, or both.</p>
 *
 * <p>For more information on filters, check the <a href="http://java.sun.com/products/servlet/2.3/javadoc/">javadoc</a>
 * or read the <a href="http://www.javaworld.com/javaworld/jw-06-2001/jw-0622-filters_p.html">Filter code with Servlet 2.3 model</a>
 * article at <a href="http://www.javaworld.com">JavaWorld</a>.</p>
 *
 * @web.filter
 *     display-name="Timer Filter"
 *     name="TimerFilter"
 *
 * @web.filter-init-param
 *     name="param1"
 *     value="value1"
 *
 * @web.filter-init-param
 *     name="param2"
 *     value="value2"
 *
 * @web.filter-mapping
 *     url-pattern="*.xml"
 *
 * @author  <a href="mailto:youremail@yourdomain.com">youremail@yourdomain.com</a>
 */
public class TimerFilter implements Filter {
    /**
     * A filter configuration object used by a servlet container used to pass information to
     * a filter during initialization. This is set in the <code>init(FilterConfig config)</code> method.
     */
    private FilterConfig config = null;

    /** Called by the web container to indicate to a filter that it is being placed into service. */
    public void init(FilterConfig config) throws ServletException {
        this.config = config;
    }

    /** Called by the web container to indicate to a filter that it is being taken out of service. */
    public void destroy() {
        config = null;
    }

    /**
     * Logs the time it took in milliseconds to process the request.
     *
     * <p>The <code>doFilter</code> method of the Filter is called by the container each time a
     * request/response pair is passed through the chain due to a client request for a
     * resource at the end of the chain.
     */
    public void doFilter(ServletRequest request, ServletResponse response,
                         FilterChain chain) throws IOException, ServletException {
        long before = System.currentTimeMillis();

        // pass the request and response to the filter chain
        chain.doFilter(request, response);

        long after = System.currentTimeMillis();

        String name = "";
        if (request instanceof HttpServletRequest)
            name = ((HttpServletRequest) request).getRequestURI();

        // log the difference in time, check the console for output
        config.getServletContext().log(name + ": " + (after - before) + "ms");
    }
}