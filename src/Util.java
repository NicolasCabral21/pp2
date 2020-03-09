import java.util.List;

public class Util {

	public static String convertStringsToOne(List<String> strings) {
		String stringGlobal = "";
		for (String string : strings) {
			stringGlobal = stringGlobal + convertWord(string);
		}
		return stringGlobal;
	}
	
	private static String convertWord(String string) {
		return null;
	}

	public static String getNumber(List<Integer> numbers) {
		String numberBase = "";
		for (Integer number : numbers) {
			numberBase = numberBase + number;
		}
		return numberBase;
	}
}
