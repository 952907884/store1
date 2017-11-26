package cn.privilege.domain;

import java.util.List;

public class Roles {
	private Integer id;
	private String name;
	private String description;
	private List<Privileges> priList;
	
	public List<Privileges> getPriList() {
		return priList;
	}
	public void setPriList(List<Privileges> priList) {
		this.priList = priList;
	}
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
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Roles(String name, String description) {
		this.name = name;
		this.description = description;
	}
	public Roles() {
	}
	@Override
	public String toString() {
		return "Roles [id=" + id + ", name=" + name + ", description=" + description + "]";
	}
	
	
	

}
