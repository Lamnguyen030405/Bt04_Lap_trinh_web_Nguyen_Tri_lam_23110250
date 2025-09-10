package vn.iotstar.entities;

import java.io.Serializable;
import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;

@Entity
@Table(name = "users")
@NamedQuery(name="UserEntity.findAll", query="SELECT u FROM UserEntity u")
public class UserEntity implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name="username", columnDefinition = "NVARCHAR(100)")
	private String username;
	
	@Column(name="password", columnDefinition = "NVARCHAR(100)")
	private String password;
	
	@Column(name="images", columnDefinition = "NVARCHAR(MAX)")
	private String image;
	
	@Column(name="fullname", columnDefinition = "NVARCHAR(100)")
	private String fullname;
	
	@Column(name="email", columnDefinition = "NVARCHAR(100)")
	private String email;
	
	@Column(name="phone", columnDefinition = "NVARCHAR(20)")
	private String phone;
	
	@Column(name="roleid", columnDefinition = "INT")
	private int roleid;
	
	@Column(name="createDate", columnDefinition = "DATETIME")
	private Date createdate;
	
	@Column(name="code", columnDefinition = "NVARCHAR(50)")
	private String code;
	
	@Column(name="status", columnDefinition = "INT")
	private int status;

	public UserEntity() {
		super();
	}

	public UserEntity(int id, String username, String password, String image, String fullname, String email,
			String phone, int roleid, Date createdate, String code, int status) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.image = image;
		this.fullname = fullname;
		this.email = email;
		this.phone = phone;
		this.roleid = roleid;
		this.createdate = createdate;
		this.code = code;
		this.status = status;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public int getRoleid() {
		return roleid;
	}

	public void setRoleid(int roleid) {
		this.roleid = roleid;
	}

	public Date getCreatedate() {
		return createdate;
	}

	public void setCreatedate(Date createdate) {
		this.createdate = createdate;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}
	
}
