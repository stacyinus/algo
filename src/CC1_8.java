//Assume you have a method isSubstring which checks if one word is a substring of
//another. Given two strings, s1 and s2, write code to check if s2 is a rotation of s1 using
// one call to isSubstring (i.e., “waterbottle” is a rotation of “erbottlewat”).
public class CC1_8 {
	public static void main(String[] args) {
		String s1 = "waterbottle";
		String s2 = "erbottlewat";
		System.out.printf("%s and %s %s rotations.\n", s1, s2, isRotation(s1, s2) ? "are" : "aren't");
		System.out.printf("%s and %s %s rotations.\n", s1, s2, isRotation2(s1, s2) ? "are" : "aren't");
		s1 = "aba";
		s2 = "bab";
		System.out.printf("%s and %s %s rotations.\n", s1, s2, isRotation(s1, s2) ? "are" : "aren't");
		System.out.printf("%s and %s %s rotations.\n", s1, s2, isRotation2(s1, s2) ? "are" : "aren't");
	}

	//Using this function, isSubstring is probably called more than once.
	public static boolean isRotation(String s1, String s2) {
		if (s1.length() != s2.length())
			return false;
		int length = s1.length();
		for (int i = 0; i < length; i++) {
			if (s1.charAt(i) == s2.charAt(0) && isSubstring(s1.substring(i, length), s2)
					&& s1.substring(0, i).equals(s2.substring(length - i, length)))
				return true;
		}
		return false;
	}
	
	public static boolean isRotation2(String s1,String s2){
		if (s1.length() != s2.length())
			return false;
		String newString = s2.concat(s2);
		if(isSubstring(s1, newString))
			return true;
		else 
			return false;
	}

	// Assume s1Length <= s2Length
	private static boolean isSubstring(String s1, String s2) {
		int s1length = s1.length();
		int s2length = s2.length();
		for (int i = 0; i <= s2length - s1length; i++) {
			if (s2.substring(i, i + s1length).equals(s1))
				return true;
		}
		return false;

	}
}
