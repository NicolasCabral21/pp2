import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map.Entry;

import Util.Registry;

public class Clazz {
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
	 * Dado un objeto, verifica tipo de campos y aplica logica para setear el codigo unico en el ID
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
