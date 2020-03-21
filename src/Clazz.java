import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map.Entry;

import Util.Registry;

public class Clazz {
	
	/**
	 * Dada una palabra devuelve la concatenacion de numeros que representa cada letra separados por '0'
	 * @param string palabra
 	 * @return 
	 */
	public static String wordToNumber(Object string) {
		
		HashMap<Integer, Character> mapeo = Registry.getCodeMap();
		
		String word = string.toString().toLowerCase();
		String number = "";
		for (int i = 0; i < word.length(); i++) {
			for (Entry<Integer, Character> entry : mapeo.entrySet()) {
				if (word.charAt(i) == entry.getValue()) {
					number = number + entry.getKey() + "0";
				}
			}
		}
		System.out.println("word: "+string+" - numero: "+number);
		return number;
	}
	
	/**
	 * Dado un objeto, devuelve un numero formado por los atributos de tipo Integer y String
	 * @param obj
	 * @throws IllegalArgumentException
	 * @throws IllegalAccessException
	 */
	public static String getNumberByObj(Object obj) throws IllegalArgumentException, IllegalAccessException {
		String number = "";
		
		for (Field field : obj.getClass().getFields()) {
			if(field.get(obj) != null) {
				if (field.getType() == String.class) {
					String word = wordToNumber(field.get(obj));
					number = number+word;
				}else {
					number=number+field.get(obj);
				}
			}
		}
		return number;
	}
	
	/**
	 * Genera un codigo a partir de la suma de los numeros y agrega prefijo y sufijo
	 * @param number
	 * @return
	 */
	public static String generateCode(String number) {
		int code = 0;
		for (int i = 0; i < number.length(); i++) {
			code = code + Integer.parseInt(String.valueOf(number.charAt(i)));
		}
		// de cero a noventa y nueve
		int prefix = (int) (Math.random()*100);
		int sufix = (int) (Math.random()*100);
		
		return prefix+String.valueOf(code)+sufix;
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
