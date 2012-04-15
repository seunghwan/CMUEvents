// Tae Yeon Kim (taeyeonk) 15-437

package model;

import java.util.Comparator;

import org.genericdao.ConnectionPool;
import org.genericdao.DAOException;
import org.genericdao.GenericDAO;
import org.genericdao.MatchArg;
import org.genericdao.RollbackException;

import databean.User;

public class UserDAO extends GenericDAO<User>{
	public UserDAO(String tableName, ConnectionPool connectionPool) throws DAOException {
		super(User.class, tableName, connectionPool);
	}
	
	public User[] search(String name, String option) throws RollbackException {
		User [] users;
		// Get users that match the search name
		if (option.equals("First Name"))
			users = match((MatchArg.equalsIgnoreCase("firstName", name)).or(MatchArg.containsIgnoreCase("firstName",name)));
		else
			users = match((MatchArg.equalsIgnoreCase("lastName", name)).or(MatchArg.containsIgnoreCase("lastName",name)));
	
        return users;
	}
	
	public User[] getMostPopular() throws RollbackException {
		
		// Calls GenericDAO's match() method.
		// This no match constraint arguments, match returns all the User beans 
		User[] a = match();
		
		if (a.length == 0)
			return null;
		
		java.util.Arrays.sort(a, new Comparator<User>() {
    		public int compare(User user1, User user2) {
    			return user2.getFriends() - user1.getFriends();
    		}
		});

        return a;
	}
	
}
