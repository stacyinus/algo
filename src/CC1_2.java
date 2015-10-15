/**
 * Write code to reverse a C-Style String. (C-String means that “abcd” is represented as
 * five characters, including the null character.)
 * @author yue
 *
 */
public class CC1_2 {
	public static void main(String[] args)
	{
		String s1 = "";
		String s2 = "a";
		String s3 = "abcd2egdshj";
		String s4 = "ab    wegxc";
		reverse(stringToCstringCharArray(s1));
		reverse(stringToCstringCharArray(s2));
		reverse(stringToCstringCharArray(s3));
		reverse(stringToCstringCharArray(s4));
	}
	
	public static void reverse( char[] str )
	{
		System.out.println(str);
		int beginIndex = 0;
		int endIndex = str.length-2;
		char temp;
		while( beginIndex <= endIndex )
		{
			temp = str[beginIndex];
			str[beginIndex]=str[endIndex];
			str[endIndex]=temp;
			beginIndex++;
			endIndex--;
		}
		System.out.println(str);
	}
	public static char[] stringToCstringCharArray( String str )
	{
		char[] strInChar = str.toCharArray();
		char strInChar2[] = new char[strInChar.length+1];
		int i = 0;
		for(;i<strInChar.length;i++)
			strInChar2[i] = strInChar[i];
	return strInChar2;
	}
}
