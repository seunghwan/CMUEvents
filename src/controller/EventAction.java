package controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import model.Model;


import org.genericdao.RollbackException;
import org.mybeans.form.FormBeanException;
import org.mybeans.form.FormBeanFactory;


/*
 * Processes the parameters from the form in register.jsp.
 * If successful:
 *   (1) creates a new User bean
 *   (2) sets the "user" session attribute to the new User bean
 *   (3) redirects to view the originally requested photo.
 * If there was no photo originally requested to be viewed
 * (as specified by the "redirect" hidden form value),
 * just redirect to manage.do to allow the user to add some
 * photos.
 */
public class EventAction extends Action {
	
	
	public EventAction(Model model) {
		
	}

	public String getName() { return "events.do"; }

    public String perform(HttpServletRequest request) {
        List<String> errors = new ArrayList<String>();
        request.setAttribute("errors",errors);

      
	       
	            return "hello.jsp";
	       
       
    }
}
