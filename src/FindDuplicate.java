
public class FindDuplicate {

	public static void main(String[] args) {
		String s = "abasbcrtb";

		for (int i = 0; i < s.length(); i++) {
			char currentChar = s.charAt(i);
			boolean duplicate = false;

			for (int j = i + 1; j < s.length(); j++) {
				if (currentChar == s.charAt(j)) {
					duplicate = true;
					break;
				}
			}
			if (duplicate) {
				System.out.println(currentChar);
			}
		}

	}

}
