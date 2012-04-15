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

public class MonthCalendarAction extends Action{
	
	private FormBeanFactory<LoginForm> formBeanFactory = FormBeanFactory.getInstance(LoginForm.class);
	
	private UserDAO userDAO;


	public MonthCalendarAction(Model model) {
		userDAO = model.getUserDAO();

	}

	public String getName() { return "monthCalendar.do"; }
    
    public String perform(HttpServletRequest request) {
        HttpSession session = request.getSession();
        
    	// If user is already logged in, redirect to home.do
        if (session.getAttribute("user") != null) {
        	return "home.do";
        }
        
        List<String> errors = new ArrayList<String>();
        request.setAttribute("errors",errors);

	    	return "welcome.jsp";

    }
}
