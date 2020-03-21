import model.Person;

public class Main {
	
	public static void main(String[] args) throws IllegalArgumentException, IllegalAccessException {
		System.out.println("objeto antes de logica:");
		
		Person p1 = new Person(21, 37993831, "Nico", "Cabral");
		System.out.println(p1.toString());
		
		String number = Clazz.getNumberByObj(p1);
		String code = Clazz.generateCode(number);
		Clazz.setCodeId(code, p1);
		
		System.out.println("objeto despues de logica:");
		
		System.out.println(p1.toString());
	}
}
