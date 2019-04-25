package Model;

public class taikhoan {
	private String userName;
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassWord() {
		return passWord;
	}
	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	private String passWord;
	private String email;
	public int getRole() {
		return role;
	}
	public void setRole(int role) {
		this.role = role;
	}
	private int role;
	
	
	
	public taikhoan() {
		super();
		// TODO Auto-generated constructor stub
	}
	public taikhoan(String userName, String passWord, String email,int role) {
		super();
		this.userName = userName;
		this.passWord = passWord;
		this.email = email;
		this.role=role;
	}
	
	
	
}
