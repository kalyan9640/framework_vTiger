package task;

public class StringTask {
public static void main(String[] args) {
	String s="manojkumarama";
	String s1="*";
	String s3="*";
	String s2="";
	for (int i = 0; i < s.length(); i++) {
		if (s.charAt(i)=='a') {
			s2=s2+s1;
			s1=s1+s3;
			
		} else {
			s2=s2+s.charAt(i);
		}
		
	}
	System.out.println(s2);
	
	String k1="";
	int count=0;
	for (int i = 0; i < s.length(); i++) {
		if (s.charAt(i)=='a') {
			count++;
			k1=k1+"*".repeat(count);
		}else {
			k1=k1+s.charAt(i);
		}
	}
	
	System.out.println(k1);
}
}
