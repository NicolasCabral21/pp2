import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map.Entry;

public class Main {

	public static void main(String[] args) throws IllegalArgumentException, IllegalAccessException {
		Person p1 = new Person(1, 21, 37993831, "Nico");
		Car c1 = new Car(2020, 111, true, true);
		createClass(c1);
		generateCode("Hola");
	}
	
	public static String getClass(Object obj) {
		System.out.println(obj.getClass().getName());
		return obj.getClass().getName();
	}
	
	public static void generateCode(String string) {
		string = string.toLowerCase();
		// a cada numero le asigno una letra
		Character[] letras = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','ñ','o','p','q','r','s','t','u','v','w','x','y','z'};
		int count = letras.length;
		Integer[] numeros = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27};
		HashMap<Integer, Character> mapeo = new HashMap<Integer, Character>();
		for (int i = 0; i < 27; i++) {
			mapeo.put(numeros[i], letras[i]);
		}
		
		System.out.println(mapeo);
		// dada una palabra, me tiene que decir que numero es
		String palabraCodificada= "";
		for (int i = 0; i < string.length(); i++) {
			for (Entry<Integer, Character> entry : mapeo.entrySet()) {
				if(string.charAt(i)==entry.getValue()) {
					palabraCodificada = palabraCodificada+entry.getKey();
				}
			}
		}
		System.out.println(palabraCodificada);
		
//		for (Entry<Integer, Character> entry : mapeo.entrySet()) {
//		    System.out.println("clave=" + entry.getKey() + ", valor=" + entry.getValue());
//		}
		
	}
	
	public static void createClass(Object obj) throws IllegalArgumentException, IllegalAccessException {
		Field[] fields = obj.getClass().getFields();
		for(Field f : obj.getClass().getFields()) {
			System.out.println("tipo: "+f.getType()+" field: " + f.getName()+" valor: "+f.get(obj));
			if(f.getType() == int.class) {
				System.out.println("es int");
			}
			if(f.getType() == String.class) {
				System.out.println("es String");
			}
			if(f.getType() == Integer.class) {
				System.out.println("es Integer");
			}
		}
	}
}
