package com.testrides.ride;

public class Ride {
	private int id;
	private String name;
	private String type;
	private int capacity;
	
	public Ride(int id, String name, String type, int capacity) {
		super();
		this.id = id;
		this.name = name;
		this.type = type;
		this.capacity = capacity;
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

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	@Override
	public String toString() {
		return "Ride [id=" + id + ", name=" + name + ", type=" + type + ", capacity=" + capacity + "]";
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
		
		return (obj instanceof Ride && ((Ride) obj).getId() == this.id);
	}
	
}
