// Tae Yeon Kim (taeyeonk) 15-437

package controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import model.Model;
import model.UserDAO;

import org.genericdao.DuplicateKeyException;
import org.genericdao.RollbackException;
import org.mybeans.form.FormBeanFactory;
import org.mybeans.form.FormBeanException;



import databean.User;


public class RegisterAction extends Action {
	
	//private FormBeanFactory<RegisterForm> formBeanFactory = FormBeanFactory.getInstance(RegisterForm.class);
	private UserDAO userDAO;
	
	public RegisterAction(Model model) {
		userDAO = model.getUserDAO();
	}
	
	public String getName() { return "register.do"; }
    
    public String perform(HttpServletRequest request) {
    	 HttpSession session = request.getSession();
     	
     	// If user is already logged in, redirect to home.do
         if (session.getAttribute("user") != null) {
         	return "home.do";
         }
    	
        List<String> errors = new ArrayList<String>();
        request.setAttribute("errors",errors);
        
        return "register.jsp";
        
        /*try {
        	RegisterForm form2 = formBeanFactory.create(request);
	        request.setAttribute("form2",form2);
	        
	        if (!form2.isPresent()) {
	            return "register.jsp";
	        }
	        
	        errors.addAll(form2.getValidationErrors());
	        if (errors.size() != 0) {
	            return "register.jsp";
	        }
	        
	        User newUser = new User();
	        newUser.setFirstName(form2.getFirstName());
	        newUser.setLastName(form2.getLastName());
	        newUser.setUserName(form2.getUserName());
	     	newUser.setPassword(form2.getPassword());
	     	newUser.setTimeZone(form2.getTimeZone());
	     	newUser.setProfileText("");
	     	newUser.setFriends(0);
	     		
	     	try {
	     		userDAO.createAutoIncrement(newUser);
	     			
	     	} catch (DuplicateKeyException e) {
	     		errors.add("A user with this name already exists");
	     	     return "register.jsp";
	     	}
	        
	        session.setAttribute("user", newUser);
			return "home.jsp";
	        
       		
        } catch (RollbackException e) {
        	errors.add(e.getMessage());
        	return "error.jsp";
        } catch (FormBeanException e) {
        	errors.add(e.getMessage());
        	return "error.jsp";
        }*/
    }
    
}
