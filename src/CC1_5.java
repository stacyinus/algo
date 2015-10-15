/**
 * Write a method to replace all spaces in a string with ‘%20’.
 * @author yue
 *
 */
public class CC1_5{
	public static void main(String[] args){
		String s = "";
	}
	public static String replaceSpace(String s ){
		StringBuilder sb = new StringBuilder();
		for(int i = 0;i<s.length();i++)
			if(s.charAt(i)==' ')
				sb.append("%20");
			else
				sb.append(s.charAt(i));
			return sb.toString();
	}
}
