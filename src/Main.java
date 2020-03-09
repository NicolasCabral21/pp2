import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map.Entry;

public class Main {
	
	public static HashMap<Integer, Character> mapeo = new HashMap<Integer, Character>();

	public static void main(String[] args) throws IllegalArgumentException, IllegalAccessException {
		Person p1 = new Person(21, 37993831, "Nico", "Cabral");
		System.out.println(p1.toString());
		setMap();
		getType(p1);
		System.out.println(p1.toString());
	}

	public static HashMap<Integer, Character> setMap() {
		// a cada numero le asigno una letra
		Character[] letras = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'ñ', 'o', 'p', 'q',
				'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z' };
		Integer[] numeros = { 1, 3, 5, 7, 9, 11, 13, 15, 17, 19, 21, 23, 25, 27, 29, 31, 33, 35, 37, 39, 41, 43, 45, 47,
				49, 51, 53 };
		
		for (int i = 0; i < 27; i++) {
			mapeo.put(numeros[i], letras[i]);
		}
		System.out.println(mapeo);
		return mapeo;
	}

	/**
	 * Dada una palabra, me tiene que decir que numero es
	 * @param string
	 * @return
	 */
	public static String convertWord(Object string) {
		String word = string.toString().toLowerCase();
		String palabraCodificada = "";
		for (int i = 0; i < word.length(); i++) {
			for (Entry<Integer, Character> entry : mapeo.entrySet()) {
				if (word.charAt(i) == entry.getValue()) {
					palabraCodificada = palabraCodificada + entry.getKey() + "0";
				}
			}
		}
		return palabraCodificada;
	}
	
	/**
	 * Genera un codigo con numeros randoms en prefijo y sufijo
	 * @param field
	 * @return
	 */
	public static String generateCode(String field) {
		int prefix = (int) (Math.random()*100);
		int sufix = (int) (Math.random()*100);
		return prefix+field+sufix;
	}

	/**
	 * Dado un objeto, verifica tipo de campos y aplica logica para setear en el ID el codigo unico
	 * @param obj
	 * @throws IllegalArgumentException
	 * @throws IllegalAccessException
	 */
	public static void getType(Object obj) throws IllegalArgumentException, IllegalAccessException {
		String campos = "";
		
		for (Field field : obj.getClass().getFields()) {
			if(field.get(obj) != null) {
				//convierto los strings en numeros
				if (field.getType() == String.class) {
					String word = convertWord(field.get(obj));
					campos = campos+word;
				}else {
					//concateno los enteros
					campos=campos+field.get(obj);	
				}
			}	
		}
		//genero codigo a partir de los campos
		String code = generateCode(campos);
		//seteo en el id del objeto, el codigo generado
		for (Field field : obj.getClass().getFields()) {
			if(field.getName().toUpperCase().equals("ID")) {
				field.set(obj, code);
				break;
			}
		}
		
	}	
}
