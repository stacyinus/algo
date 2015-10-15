/**
 * Design an algorithm and write code to remove the duplicate characters in a string
 * without using any additional buffer.
 * @author yue
 *
 */
public class CC1_3 {
	public static void main(String[] args) {
		String s = "";
		System.out.printf("Before %s, after %s\n", s, removeDuplicate1(s));
		System.out.printf("Before %s, after %s\n", s, removeDuplicate2(s));
		System.out.printf("Before %s, after %s\n", s, removeDuplicate3(s));
		s = null;
		System.out.printf("Before %s, after %s\n", s, removeDuplicate1(s));
		System.out.printf("Before %s, after %s\n", s, removeDuplicate2(s));
		System.out.printf("Before %s, after %s\n", s, removeDuplicate3(s));
		s = "a";
		System.out.printf("Before %s, after %s\n", s, removeDuplicate1(s));
		System.out.printf("Before %s, after %s\n", s, removeDuplicate2(s));
		System.out.printf("Before %s, after %s\n", s, removeDuplicate3(s));
		s = "aaaaaaaaaaaa";
		System.out.printf("Before %s, after %s\n", s, removeDuplicate1(s));
		System.out.printf("Before %s, after %s\n", s, removeDuplicate2(s));
		System.out.printf("Before %s, after %s\n", s, removeDuplicate3(s));
		s = "AAaaAAAaa";
		System.out.printf("Before %s, after %s\n", s, removeDuplicate1(s));
		System.out.printf("Before %s, after %s\n", s, removeDuplicate2(s));
		System.out.printf("Before %s, after %s\n", s, removeDuplicate3(s));
		s = "aAAaebe2dc3yyf";
		System.out.printf("Before %s, after %s\n", s, removeDuplicate1(s));
		System.out.printf("Before %s, after %s\n", s, removeDuplicate2(s));
		System.out.printf("Before %s, after %s\n", s, removeDuplicate3(s));
		
	}

	// inplace O(n3)
	public static String removeDuplicate1(String s) {
		if (s == null || s.length() == 0 || s.length() == 1)
			return s;
		char[] charArray = s.toCharArray();
		int endIndex = charArray.length - 1;
		for (int i = 0; i < endIndex; i++) {
			for (int j = i + 1; j <= endIndex; j++) {
				if (charArray[i] == charArray[j]) {
					int temp = j;
					while (temp < endIndex) {
						charArray[temp] = charArray[temp + 1];
						temp++;
					}
					charArray[endIndex] = 0;
					endIndex--;
					--j;//This is very important.
				}
			}
		}
		return String.valueOf(charArray);
	}

	//inplace, no additional memory cost O(n2)
	public static String removeDuplicate2(String s) {
		if (s == null || s.length() == 0 || s.length() == 1)
			return s;
		char[] str = s.toCharArray();
		int tail = 1;
		for (int i = 1; i < str.length; ++i) {
			int j;
			for (j = 0; j < tail; ++j) {
				if (str[i] == str[j])
					break;
			}
			if (j == tail) {
				str[tail] = str[i];
				++tail;
			}
		}
		for(int i = tail; i<str.length;i++ )
			str[i] = 0;
		return String.valueOf(str);
	}
	//inplace, with additional memory usage, O(n)
	public static String removeDuplicate3(String s) {
		if (s == null || s.length() == 0 || s.length() == 1)
			return s;
		char[] str = s.toCharArray();
		boolean[] flags = new boolean[256];
		for(int i = 0;i<256;i++)
			flags[i]=false;
		flags[str[0]]=true;
		int tail = 1;
		for(int i =1;i<str.length;i++)
		{
			if(!flags[str[i]])
			{
				str[tail] = str[i];
				flags[str[i]]=true;
				++tail;
			}
		}
		for(int i = tail; i<str.length;i++)
			str[i]=0;
		return String.valueOf(str);
	}
}
