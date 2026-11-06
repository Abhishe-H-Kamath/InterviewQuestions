
public class DuplicateWord {

	public static void main(String[] args) {
		int count;
		String word = "here we go again and again but again is not here";
		String [] strArray = word.split(" ");
		
		for(int i = 0; i<=strArray.length-1; i++) {
			count =1;
			for(int j =i+1; j<=strArray.length-1; i++) {
				if(strArray[i].equals(strArray[j])) {
					count ++;
				}
			}
			System.out.println(strArray[i]+ " = "+count);
		}

	}

}
