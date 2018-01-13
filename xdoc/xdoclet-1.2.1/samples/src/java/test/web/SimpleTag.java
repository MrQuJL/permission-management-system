
package test.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspTagException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;
import java.io.IOException;

/**
 * Simple JSP tag.
 *
 * @jsp.tag name="simple" 
 *          display-name="SimpleTag" 
 *          body-content="empty" 
 *          description="Simple JSP tag."
 *
 * @author  <a href="mailto:youremail@yourdomain.com">youremail@yourdomain.com</a>
 */
public class SimpleTag extends TagSupport {
    private String action = null;

    /**
     * Sets the action attribute. This is included in the tld file.
     *
     * @jsp.attribute
     *     description="The action attribute"
     *     required="true"
     *     rtexprvalue="true"
     */
    public String getAction() {
        return this.action;
    }

    /**
     */
    public void setAction(String action) {
        this.action = action;
    }

    /** Process the start tag for this instance. */
    public int doStartTag() throws JspTagException {
        HttpServletRequest request = (HttpServletRequest) pageContext.getRequest();

        try {
            JspWriter out = pageContext.getOut();

            out.print("Simple tag started.");
        }
        catch (IOException ioe) {
            ioe.printStackTrace();
        }

        return EVAL_BODY_INCLUDE;
    }

    /** Process the end tag. This method will be called on all Tag objects. */
    public int doEndTag() {
        try {
            JspWriter out = pageContext.getOut();

            out.print("Simple tag ended.");
        }
        catch (IOException ioe) {
            ioe.printStackTrace();
        }

        return EVAL_PAGE;
    }
}