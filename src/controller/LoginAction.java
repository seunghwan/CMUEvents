// Tae Yeon Kim (taeyeonk) 15-437

package controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.genericdao.MatchArg;
import org.genericdao.RollbackException;
import org.mybeans.form.FormBeanException;
import org.mybeans.form.FormBeanFactory;

import databean.User;

import formbean.LoginForm;

import model.Model;

import model.UserDAO;

public class LoginAction extends Action{
	
	private FormBeanFactory<LoginForm> formBeanFactory = FormBeanFactory.getInstance(LoginForm.class);
	
	private UserDAO userDAO;


	public LoginAction(Model model) {
		userDAO = model.getUserDAO();

	}

	public String getName() { return "login.do"; }
    
    public String perform(HttpServletRequest request) {
        HttpSession session = request.getSession();
        
    	// If user is already logged in, redirect to home.do
        if (session.getAttribute("user") != null) {
        	return "home.do";
        }
        
        List<String> errors = new ArrayList<String>();
        request.setAttribute("errors",errors);
        
        try {
	    	LoginForm form = formBeanFactory.create(request);
	        request.setAttribute("form",form);
	      

	      
	        // If no params were passed, return with no errors so that the form will be
	        // presented (we assume for the first time).
	        if (!form.isPresent()) {
	            return "welcome.jsp";
	        }

	        // Any validation errors?
	        errors.addAll(form.getValidationErrors());
	        if (errors.size() != 0) {
	            return "welcome.jsp";
	        }

	        // Look up the user
	        User[] users = userDAO.match(MatchArg.equals("userName",form.getUserName()));
	        
	        if(users.length == 0)
			{
				errors.add("User Name not found");
				return "welcome.jsp";
			}
	        
	        User user = users[0];

	        // Check the password
	        if (!user.getPassword().equals(form.getPassword())) {
	            errors.add("Incorrect password");
	            return "welcome.jsp";
	        }
	
	        // Attach (this copy of) the user bean to the session
	        session.setAttribute("user",user);
	        
	        // If redirectTo is null, redirect to the "home.do" action
			return "home.jsp";
        } catch (RollbackException e) {
        	errors.add(e.getMessage());
        	return "error.jsp";
        } catch (FormBeanException e) {
        	errors.add(e.getMessage());
        	return "error.jsp";
        }
    }
}
