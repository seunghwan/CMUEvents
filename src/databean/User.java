// Tae Yeon Kim (taeyeonk) 15-437

package databean;
import org.genericdao.PrimaryKey;

@PrimaryKey("id")

public class User {
	private int id;
	private String userName;
	private String firstName;
	private String lastName;
	private String password;
	private String timeZone;
	private String profileText;
	private int friends;

	public int getId() {
		return id;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public String getUserName() {
		return userName;
	}
	
	public String getPassword() {
		return password;
	}
	
	public String getTimeZone() {
		return timeZone;
	}

	public String getProfileText() {
		return profileText;
	}

	public int getFriends() {
		return friends;
	}


	public void setFirstName(String firstName) {
		this.firstName =firstName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public void setTimeZone(String timeZone) {
		this.timeZone = timeZone;
	}

	public void setId(int id) {
		this.id = id;
		
	}
	
	public void setProfileText(String profileText) {
		this.profileText = profileText;
	}
	
	public void setFriends(int friends) {
		this.friends = friends;
	}

	
}

