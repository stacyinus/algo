import java.util.HashMap;

//Implement an algorithm to determine if a string has all unique characters. What if you
//can not use additional data structures?
public class CC1_1 {
	public static void main(String[] args){
		String s1 = "";
		String s2 = "a";
		String s3 = "abcdefg";
		String s4 = "acbdec";
		String s5 = "aa";
		System.out.printf("String %s has all unique characters %b\n", s1, allUnique1(s1) );
		System.out.printf("String %s has all unique characters %b\n", s1, allUnique2(s1) );
		System.out.printf("String %s has all unique characters %b\n", s2, allUnique1(s2) );
		System.out.printf("String %s has all unique characters %b\n", s2, allUnique2(s2) );
		System.out.printf("String %s has all unique characters %b\n", s3, allUnique1(s3) );
		System.out.printf("String %s has all unique characters %b\n", s3, allUnique2(s3) );
		System.out.printf("String %s has all unique characters %b\n", s4, allUnique1(s4) );
		System.out.printf("String %s has all unique characters %b\n", s4, allUnique2(s4) );
		System.out.printf("String %s has all unique characters %b\n", s5, allUnique1(s5) );
		System.out.printf("String %s has all unique characters %b\n", s5, allUnique2(s5) );
		
	}
	public static boolean allUnique1(String s ){
		HashMap<Character,Integer> map = new HashMap<Character, Integer>();
		char[] chars = s.toCharArray();
		for(char c : chars)
		{
			if(!map.containsKey(c))
				map.put(c, 1);
			else
				return false;
		}
		return true;
	}
	// Precondition: the characters should be all lower cases
	public static boolean allUnique2(String s ){
		int value = 0;
		char[] chars = s.toCharArray();
		for(char c : chars) 
		{	
			int i = c -'a';
			if(((1<<i+1)&value)>0)
				return false;
			value = value | (1<<i+1);
		}
		return true;
	}
}
