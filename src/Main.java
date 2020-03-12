import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map.Entry;

import Util.Registry;
import model.Person;

public class Main {
	
	public static void main(String[] args) throws IllegalArgumentException, IllegalAccessException {
		Person p1 = new Person(21, 37993831, "Nico", "Cabral");
		System.out.println(p1.toString());
		
		String fields = Clazz.getType(p1);
		String code = Clazz.generateCode(fields);
		Clazz.setCodeId(code, p1);
		System.out.println(p1.toString());
	}
}
