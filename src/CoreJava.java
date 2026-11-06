import java.util.*;

public class CoreJava {
    public static void main(String[] args) {
        //Given String is Palindrome
        String str = "madam";
        int i = 0;
        int j = str.length() - 1;

        while (i < j) {
            if (str.charAt(i++) == str.charAt(j--)) {
                System.out.println(str + " Is Palindrome");
                break;
            } else {
                System.out.println("Is Not Palindrome");
                break;
            }
        }

        //Given number is prime or not
        int n = 6;
        if (n <= 1) {
            System.out.println(n + " Is not prime number");
        } else {
            for (i = 2; i <= Math.sqrt(n); i++) {
                if (n % i == 0) {
                    System.out.println(n + " Is not prime number");
                } else {
                    System.out.println(n + " Is prime number");
                }
            }

        }

        //Fibonacci Series
        int a = 0, b = 1;
        for (i = 0; i < n; i++) {
            System.out.print(a + ", ");
            int sum = a + b;
            a = b;
            b = sum;
        }
        System.out.println("\n");

        //Swap Two numbers without Third Variable
        a = 5;
        b = 10;
        a = a + b;
        b = a - b;
        a = a - b;
        System.out.println(a + " " + b);

        //Armstrong Number
        int number = 153;
        int original = number;
        int sum = 0;

        while (number > 0) {
            int digit = number % 10;
            sum += digit * digit * digit;
            number /= 10;
        }

        if (sum == original) {
            System.out.println(original + " is armstrong number");
        } else {

            System.out.println(original + " is not armstrong number");
        }

        //Anagram checks
        String string1 = "listen";
        String string2 = "silent";

        char[] stringArray1 = string1.toCharArray();
        char[] stringArray2 = string2.toCharArray();

        Arrays.sort(stringArray1);
        Arrays.sort(stringArray2);

        System.out.println(Arrays.equals(stringArray1, stringArray2) ? "Anagram" : "Not Anagram");
    }
}
