
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

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Integer getDni() {
		return dni;
	}

	public void setDni(Integer dni) {
		this.dni = dni;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
}
