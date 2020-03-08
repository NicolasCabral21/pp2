import java.util.Random;

public class Person {
	public Integer id;
	public Integer age;
	public Integer dni;
	public String name;
	public String lastname;
	
	public Person(Integer id, Integer age, Integer dni, String name, String lastname) {
		this.id = id;
		this.age = age;
		this.dni = dni;
		this.name = name;
		this.lastname = lastname;
	}
	
	public String toString() {
		   return getClass().getName() + '@' + Integer.toHexString(hashCode());
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
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
	
	public static void main(String[] args) {
		Random random = new Random();
		int numero = random.nextInt(5);
//		System.out.println(numero);
		String field = "111111111111111111111111111111111111111111111111111111111111111111111111111111111111111";
		int prefix = (int) (Math.random()*100);
		int sufix = (int) (Math.random()*100);
		System.out.println(prefix);
		System.out.println(sufix);
		
		System.out.println(prefix+field+sufix);
		
	}
}
