package vn.iotstar.entities;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;

@Entity
@Table(name = "categories")
@NamedQuery(name="CategoryEntity.findAll", query="SELECT c FROM CategoryEntity c")
public class CategoryEntity implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cate_id")
	private int cateid;
	
	@Column(name="cate_name", columnDefinition = "NVARCHAR(255)")
	private String catename;
	
	@Column(name = "icons", columnDefinition = "NAVCHAR(MAX)")
	private String icon;

	@Column(name = "user_id", columnDefinition = "INT")
	private int userid;
	
	public CategoryEntity() {
		super();
	}

	public CategoryEntity(int cateid, String catename, String icon, int userid) {
		super();
		this.cateid = cateid;
		this.catename = catename;
		this.icon = icon;
		this.userid = userid;
	}

	public int getCateid() {
		return cateid;
	}

	public void setCateid(int cateid) {
		this.cateid = cateid;
	}

	public String getCatename() {
		return catename;
	}

	public void setCatename(String catename) {
		this.catename = catename;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}
	
	
}
