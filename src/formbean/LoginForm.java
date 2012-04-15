// Tae Yeon Kim (taeyeonk) 15-437

package formbean;

import java.util.ArrayList;
import java.util.List;

import org.mybeans.form.FormBean;


public class LoginForm extends FormBean{
	private String userName;
    private String password;
    private String action;
	private int count;
	private int friendCount;
	
    public String getUserName()  { return userName; }
    public String getPassword()  { return password; }
    public String getAction()    { return action; }
    public int getCount()    { return count; }
    public int getFriendCount()    { return friendCount; }
   
    public void setUserName(String s)  { userName = s.trim(); }
    public void setPassword(String s)  { password = s.trim(); }
    public void setAction(String s)    { action   = s;        }
    public void setCount(int c)    { count   = c;        }
    public void setFriendCount(int c)    { friendCount   = c; }
    
    public List<String> getValidationErrors() {
        List<String> errors = new ArrayList<String>();

        if (userName == null || userName.length() == 0) errors.add("User Name is required");
        if (password == null || password.length() == 0) errors.add("Password is required");
        if (action == null) errors.add("Button is required");

        if (errors.size() > 0) return errors;

        if (!action.equals("Login")) errors.add("Invalid button");
        if (userName.indexOf("<") >= 0 || userName.indexOf(">") >= 0) 
        	errors.add("User Name must not contain the < or > characters.");
		
        return errors;
    }
}
