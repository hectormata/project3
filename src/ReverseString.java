
public class ReverseString {

	public static String reverse(String s) {
		
		int n = s.length();
		char[] a = s.toCharArray();
		
		for (int i = 0; i < n / 2; i++) {
			
			char tmp = a[i];
			a[i] = a [n - i - 1];
			a[n - i - 1] = tmp;
		}
		
		return new String(a);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(reverse("Hello, World!"));
	}

}
