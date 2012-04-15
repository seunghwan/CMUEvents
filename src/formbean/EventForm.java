package formbean;

import java.util.ArrayList;
import java.util.List;

import org.mybeans.form.FormBean;

public class EventForm extends FormBean{

	    private String action;
	    private String event;
	    
	    public String getEvent() { return event; }
	    public String getAction()    { return action; }
		
	    public void setEvent(String s) { event = s.trim(); }
	    public void setAction(String s)    { action   = s;        }
	    
	    public List<String> getValidationErrors() {
	        List<String> errors = new ArrayList<String>();
	        
	        if (event == null || event.length() == 0) errors.add("Event Name is required");
	      
	        if (action == null) errors.add("Button is required");

	        if (errors.size() > 0) return errors;

	        if (!action.equals("Submit")) errors.add("Invalid button");
	        
	        if (event.indexOf("<") >= 0 || event.indexOf(">") >= 0) 
				errors.add("Event Name must not contain the < or > characters.");
			
			
	        return errors;
	    }
	
}
