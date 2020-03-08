import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.Random;
import java.util.UUID;

public class Main {

	public static List<Integer> numbersBase = new ArrayList<Integer>();
	public static List<String> stringsBase = new ArrayList<String>();
	public static List<Object> fields = new ArrayList<Object>();

	public static void main(String[] args) throws IllegalArgumentException, IllegalAccessException {
		Person p1 = new Person(1, 21, 37993831, "Nico", "Cabral");
//		Car c1 = new Car(2020, 111, true, true);
		getType(p1);
		fields.add("123");
		System.out.println(generateCode("10001"));
	}

	public static String convertStringsToOne(List<String> strings) {
		String stringGlobal = "";
		for (String string : strings) {
			stringGlobal = stringGlobal + convertWord(string);
		}
		return stringGlobal;
	}

	public static String generateCode(String field) {
		int prefix = (int) (Math.random()*100);
		int sufix = (int) (Math.random()*100);
		return prefix+field+sufix;
	}

	public static HashMap<Integer, Character> map() {
		// a cada numero le asigno una letra
		Character[] letras = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'ñ', 'o', 'p', 'q',
				'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z' };
		Integer[] numeros = { 1, 3, 5, 7, 9, 11, 13, 15, 17, 19, 21, 23, 25, 27, 29, 31, 33, 35, 37, 39, 41, 43, 45, 47,
				49, 51, 53 };
		HashMap<Integer, Character> mapeo = new HashMap<Integer, Character>();
		for (int i = 0; i < 27; i++) {
			mapeo.put(numeros[i], letras[i]);
		}
//		System.out.println(mapeo);
		return mapeo;
	}

	public static String convertWord(String string) {
		HashMap<Integer, Character> map = map();
		string = string.toLowerCase();
		// dada una palabra, me tiene que decir que numero es
		String palabraCodificada = "";
		for (int i = 0; i < string.length(); i++) {
			for (Entry<Integer, Character> entry : map.entrySet()) {
				if (string.charAt(i) == entry.getValue()) {
					palabraCodificada = palabraCodificada + entry.getKey() + "0";
				}
			}
		}
		return palabraCodificada;
	}

	public static String getNumber(List<Integer> numbers) {
		String numberBase = "";
		for (Integer number : numbers) {
			numberBase = numberBase + number;
		}
		return numberBase;
	}

	public static void getType(Object obj) throws IllegalArgumentException, IllegalAccessException {
		for (Field field : obj.getClass().getFields()) {
			if (field.getType() == String.class) {
				stringsBase.add((String) field.get(obj));
			}
			if (field.getType() == Integer.class) {
				numbersBase.add((Integer) field.get(obj));
			}
		}
	}
}
