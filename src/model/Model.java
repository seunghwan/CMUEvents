// Tae Yeon Kim (taeyeonk) 15-437

package model;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;

import org.genericdao.ConnectionPool;
import org.genericdao.DAOException;

public class Model {
	private UserDAO userDAO;

	
	public Model(ServletConfig config) throws ServletException {
		try {
			String jdbcDriver = config.getInitParameter("jdbcDriverName");
			String jdbcURL    = config.getInitParameter("jdbcURL");
			//initialize dao's and connection pool in 1 place
			ConnectionPool pool = new ConnectionPool(jdbcDriver,jdbcURL);
			
			userDAO  = new UserDAO("users", pool);
		

		} catch (DAOException e) {
			throw new ServletException(e);
		}
	}

	public UserDAO getUserDAO()  { return userDAO; }

}

