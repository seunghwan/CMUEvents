// Tae Yeon Kim (taeyeonk) 15-437

package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import databean.User;
import model.Model;

public class Controller extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void init() throws ServletException {
        Model model = new Model(getServletConfig());

        Action.add(new MonthCalendarAction(model));
        Action.add(new RegisterAction(model));

    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
    //given request perform action that sets what next page is
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nextPage = performTheAction(request);
        sendToNextPage(nextPage,request,response);
    }
    
    /*
     * Extracts the requested action and (depending on whether the user is logged in)
     * perform it (or make the user login).
     * @param request
     * @return the next page (the view)
     */
    private String performTheAction(HttpServletRequest request) {
        HttpSession session     = request.getSession(true);
        String      servletPath = request.getServletPath();
        String      action = getActionName(servletPath);//delete slash off
        
        if (action.equals("welcome")) {
        	// User is logged in, but at the root of our web app
			return Action.perform("monthCalendar.do",request);
        }
        
      	// Let the logged in user run his chosen action
		return Action.perform(action,request);
		
    }
    
    /*
     * If nextPage is null, send back 404
     * If nextPage ends with ".do", redirect to this page.
     * If nextPage ends with ".jsp", dispatch (forward) to the page (the view)
     *    This is the common case
     */
    private void sendToNextPage(String nextPage, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
    	if (nextPage == null) {//scnotfound is 404 error
    		response.sendError(HttpServletResponse.SC_NOT_FOUND,request.getServletPath());
    		return;
    	}
    	
    	if (nextPage.charAt(0) == '/') {
			String host  = request.getServerName();
			String port  = ":"+String.valueOf(request.getServerPort());
			if (port.equals(":80")) port = "";
			response.sendRedirect("http://"+host+port+nextPage);
			return;
    	}
    	
   		RequestDispatcher d = request.getRequestDispatcher("/"+nextPage);
   		d.forward(request,response);
    }

	/*
	 * Returns the path component after the last slash removing any "extension"
	 * if present.
	 */
    private String getActionName(String path) {
    	// We're guaranteed that the path will start with a slash
        int slash = path.lastIndexOf('/');
        return path.substring(slash+1);
    }
}

