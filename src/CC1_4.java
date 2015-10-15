import java.util.HashMap;

/**
 * Write a method to decide if two strings are anagrams or not.
 * 
 * @author yue
 *
 */
public class CC1_4 {
	public static void main(String[] args) {
		String s1=null;
		String s2=null;
		System.out.printf("%s and %s %s anagrams\n", s1, s2, anagrams1(s1,s2)?"are":"are not");
		s1="";
		System.out.printf("%s and %s %s anagrams\n", s1, s2, anagrams1(s1,s2)?"are":"are not");
		s2="";
		System.out.printf("%s and %s %s anagrams\n", s1, s2, anagrams1(s1,s2)?"are":"are not");
		s1="a";
		s2="aa";
		System.out.printf("%s and %s %s anagrams\n", s1, s2, anagrams1(s1,s2)?"are":"are not");
		s1="aa";
		System.out.printf("%s and %s %s anagrams\n", s1, s2, anagrams1(s1,s2)?"are":"are not");
		s1="acbdefgaaacccbbb";
		s2="fgaaabbbacbdeccc";
		System.out.printf("%s and %s %s anagrams\n", s1, s2, anagrams1(s1,s2)?"are":"are not");
	}

	// with additional memory usage, O(n)
	public static boolean anagrams1(String s1, String s2) {
		if (s1 == null && s2 == null)
			return true;
		if (s1 != null && s2 != null && s1.length() == s2.length()) {
			char[] charS1 = s1.toCharArray();
			HashMap<Character, Integer> map = new HashMap<Character, Integer>();
			for (int i = 0; i < charS1.length; i++) {
				int value = 1;
				if (map.containsKey(charS1[i]))
					value = map.get(charS1[i]) + 1;
				map.put(charS1[i], value);
			}
			char[] charS2 = s2.toCharArray();
			for (int i = 0; i < charS2.length; i++) {
				if (!map.containsKey(charS2[i]))
					return false;
				int value = map.get(charS2[i]) - 1;
				if (value == 0)
					map.remove(charS2[i]);
				else {
					map.put(charS2[i], value);
				}
			}
			if (map.isEmpty())
				return true;
		}
		return false;
	}
	// without additional memory usage, O(nlog(n))
		public static boolean anagrams2(String s1, String s2) {
			return true;
		}
}
