package Util;
import java.util.HashMap;

public class Registry {
	
	public static HashMap<Integer, Character> codeMap = new HashMap<Integer, Character>();
	
	/**
	 * Cada letra representa un numero primo del 1 al 53
	 * @return
	 */
	public static HashMap<Integer, Character> getCodeMap() {
		Character[] letras = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'ñ', 'o', 'p', 'q',
				'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z' };
		Integer[] numeros = { 1, 3, 5, 7, 9, 11, 13, 15, 17, 19, 21, 23, 25, 27, 29, 31, 33, 35, 37, 39, 41, 43, 45, 47,
				49, 51, 53 };
		
		for (int i = 0; i < 27; i++) {
			codeMap.put(numeros[i], letras[i]);
		}
		return codeMap;
	}
}
