package test.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.actions.DispatchAction;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

/**
 * Simple class to test Jakarta Struts generation (Jakarta Struts 1.2 beta 2 only).
 *
 * @struts.action
 *    path="/struts/bar"
 *
 * @struts.action-forward
 *    name="success"
 *    path="/struts/getAll.do"
 *    redirect="false"
 *
 */
public final class StrutsDispatchAction extends DispatchAction
{
    public ActionForward execute(ActionMapping mapping, ActionForm form,
                                 HttpServletRequest request, HttpServletResponse response)
    {
        return mapping.findForward("success");
    }
}
