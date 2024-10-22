import java.util.*;
import java.util.stream.Collectors;
public class prg1{
	public static List<Character> convertStringToCharList(String str){
		List<Character> chars = str .chars().mapToObj(e -> (char)e).collect(Collectors.toList());
		return chars;
	}
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		String str=sc.nextLine();
		List<Character> chars= convertStringToCharList(str);
		ArrayList<Character> upperChars= chars.stream().filter(x -> Character.isUpperCase(x)).collect(Collectors.toCollection(ArrayList::new));
		ArrayList<Character> lowerChars= chars.stream().filter(x -> Character.isLowerCase(x)).collect(Collectors.toCollection(ArrayList::new));
		ArrayList<Character> digits = chars.stream().filter(x -> Character.isDigit(x)).collect(Collectors.toCollection(ArrayList::new));
		System.out.println("Upper Case Characters in the given string are: "+upperChars);
		System.out.println("Lower Case Characters in the given string are: "+lowerChars);
		System.out.println("Digits in the given string are: "+digits);
	}
}
