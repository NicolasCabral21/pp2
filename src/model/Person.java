package model;

public class Person {
	public String id;
	public Integer age;
	public Integer dni;
	public String name;
	public String lastname;
	
	public Person(Integer age, Integer dni, String name, String lastname) {
		this.age = age;
		this.dni = dni;
		this.name = name;
		this.lastname = lastname;
	}
	
	public String toString() {
		return "id: "+this.id+" age: "+this.age+" dni: "+this.dni+" name: "+this.name+" lastname: "+this.lastname;
	}
}
