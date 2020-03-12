import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map.Entry;

import Util.Registry;
import model.Person;

public class Main {
	
	public static void main(String[] args) throws IllegalArgumentException, IllegalAccessException {
		Person p1 = new Person(21, 37993831, "Nico", "Cabral");
		System.out.println(p1.toString());
		
		String fields = getType(p1);
		String code = generateCode(fields);
		setCodeId(code, p1);
		System.out.println(p1.toString());
	}

	/**
	 * Dada una palabra, me tiene que decir que numero es
	 * @param string
	 * @return
	 */
	public static String convertWord(HashMap<Integer, Character> mapeo, Object string) {
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
		int code = 0;
		for (int i = 0; i < field.length(); i++) {
			code = code + Integer.parseInt(String.valueOf(field.charAt(i)));
		}
		int prefix = (int) (Math.random()*100);
		int sufix = (int) (Math.random()*100);
		return prefix+String.valueOf(code)+sufix;
	}

	/**
	 * Dado un objeto, verifica tipo de campos y aplica logica para setear en el ID el codigo unico
	 * @param obj
	 * @throws IllegalArgumentException
	 * @throws IllegalAccessException
	 */
	public static String getType(Object obj) throws IllegalArgumentException, IllegalAccessException {
		String campos = "";
		HashMap<Integer, Character> mapeo = Registry.setMap();
		
		for (Field field : obj.getClass().getFields()) {
			if(field.get(obj) != null) {
				if (field.getType() == String.class) {
					String word = convertWord(mapeo, field.get(obj));
					campos = campos+word;
				}else {
					campos=campos+field.get(obj);	
				}
			}
		}
		return campos;
	}
	public static void setCodeId(String code, Object obj) throws IllegalArgumentException, IllegalAccessException {
		//seteo en el id del objeto, el codigo generado
		for (Field field : obj.getClass().getFields()) {
			if(field.getName().toUpperCase().equals("ID")) {
				field.set(obj, code);
				break;
			}
		}
	}
}
