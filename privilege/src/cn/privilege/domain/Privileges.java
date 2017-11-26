package cn.privilege.domain;

public class Privileges {
	private Integer id ;
	private String name;
	private String fnpath;
	private String description;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getFnpath() {
		return fnpath;
	}
	public void setFnpath(String fnpath) {
		this.fnpath = fnpath;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Privileges(String name, String fnpath, String description) {
		this.name = name;
		this.fnpath = fnpath;
		this.description = description;
	}
	public Privileges() {
	}
	@Override
	public String toString() {
		return "Privileges [id=" + id + ", name=" + name + ", fnpath=" + fnpath + ", description=" + description + "]";
	}
	
	
}
