
public class Person {
	public int id;
	public int age;
	public int dni;
	public String name;
	
	
	public Person() {
	}
	
	public Person(int id, int age, int dni, String name) {
		this.id = id;
		this.age = age;
		this.dni = dni;
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getDni() {
		return dni;
	}

	public void setDni(int dni) {
		this.dni = dni;
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
	
}
