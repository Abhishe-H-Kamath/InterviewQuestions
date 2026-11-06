
public class CountChar {

	public static void main(String[] args) {
		String str = "PallaviNayak";
		
		int count;
		
		for(int i = 0 ; i<str.length(); i++) {
			char currentChar = str.charAt(i);
			count = 0;
			
			for(int j = 0; j<str.length(); j++) {
				if(currentChar == str.charAt(j)) {
					count ++;
				}
			}
			System.out.println(currentChar+ " = "+count);
		}
	}

}
