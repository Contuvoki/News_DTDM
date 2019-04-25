package Model;

import java.sql.Date;

public class TinTuc {
	public TinTuc() {
		super();
		// TODO Auto-generated constructor stub
	}
	private int id;
	private String header;
	private String content;
	private String userName;
	private String ngayDang;
	public int getId() {
		return id;
	}
	public TinTuc(int id, String header, String content) {
		super();
		this.id = id;
		this.header = header;
		this.content = content;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getHeader() {
		return header;
	}
	public void setHeader(String header) {
		this.header = header;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getNgayDang() {
		return ngayDang;
	}
	public void setNgayDang(String ngayDang) {
		this.ngayDang = ngayDang;
	}
	public TinTuc(String header, String content, String userName, String ngayDang) {
		super();
		this.header = header;
		this.content = content;
		this.userName = userName;
		this.ngayDang = ngayDang;
	}
	public TinTuc(int id, String header, String content, String userName, String ngayDang) {
		super();
		this.id = id;
		this.header = header;
		this.content = content;
		this.userName = userName;
		this.ngayDang = ngayDang;
	}
	
	
}