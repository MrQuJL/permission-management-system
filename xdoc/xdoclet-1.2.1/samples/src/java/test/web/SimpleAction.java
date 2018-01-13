package test.web;

/**
 * Simple WebWork action.
 *
 * <p>WebWork is a web application framework for J2EE. It is based on a concept called "Pull HMVC"
 * Pull Hierarchical Model View Controller). It supports an arrange of view technologies - XSLT, JSP,
 * Velocity, Applet, Jasper Reports, and more.</p>
 *
 * <p>Actions are central to WebWork (WW) as they are the controllers in your application. For more
 * information, check the <a href="http://www.opensymphony.com/webwork/">WebWork Documentation</a>.
 *
 * @webwork.action
 *     name="foo"
 *     views="a=tjo.jsp,b=blah.jsp,c=duh.jsp"
 *
 * @webwork.action
 *     name="bar"
 *     views="qwe=tjo.jsp,rty=blah.jsp,xyz=duh.jsp"
 *
 * @webwork.action
 *     name="xyzzy"
 *     error="blah.jsp"
 *     input="duh.jsp"
 *    success="tjo.jsp"
 *
 * @webwork.action
 *     name="myaction"
 *     error="blah.jsp"
 *     input="duh.jsp"
 *     success="tjo.jsp"
 *     views="login=login.jsp"
 *
 * @author  <a href="mailto:youremail@yourdomain.com">youremail@yourdomain.com</a>
 */
public class SimpleAction implements webwork.action.Action {
    /**
     * This method is where the logic of the action is executed. Parameters are passed
     * by calling set-methods, or by implementing the ParameterAware interface.
     */
    public String execute() {
        // Simple. Very simple.
        return SUCCESS;
    }

    /**
     * @webwork.command
     *     error="add_error.jsp"
     *     name="add"
     *     success="add_success.jsp"
     */
    public String doCmd1() {
        return SUCCESS;
    }

    /**
     * @webwork.command
     *     error="cmd2_error.jsp"
     *     success="cmd2_success.jsp"
     */
    public String doCmd2() {
        return SUCCESS;
    }
}