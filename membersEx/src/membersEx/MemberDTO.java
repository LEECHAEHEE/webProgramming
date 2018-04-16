package membersEx;

import java.util.Date;

public class MemberDTO {
	private String name;
	private String id;
	private String pw;
	private String email;
	private String address;
	private Date rDate;
	
	public MemberDTO(String name, String id, String pw, String email, String address, Date rDate) {
		super();
		this.name = name;
		this.id = id;
		this.pw = pw;
		this.email = email;
		this.address = address;
		this.rDate = rDate;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Date getrDate() {
		return rDate;
	}

	public void setrDate(Date rDate) {
		this.rDate = rDate;
	}
	
	
}
