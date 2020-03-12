package Util;
import java.util.HashMap;

public class Registry {
	
	public static HashMap<Integer, Character> mapeo = new HashMap<Integer, Character>();
	
	public static HashMap<Integer, Character> setMap() {
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
}
