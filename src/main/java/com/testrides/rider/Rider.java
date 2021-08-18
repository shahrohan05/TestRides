package com.testrides.rider;

public class Rider {
	private int id;
	private String name;
	
	public Rider(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		return "Rider [id=" + id + ", name=" + name + "]";
	}
	
	@Override
	public int hashCode() {
		return id;
	}
	
	
	@Override
	public boolean equals(Object obj) {
		if(obj == null) {
			return false;
		}
		
		if(obj == this) {
			return true;
		}
		
		return (obj instanceof Rider && ((Rider) obj).getId() == this.id);
	}

}
