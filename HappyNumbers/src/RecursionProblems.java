import java.util.ArrayList;

public class RecursionProblems {
   public static void main(String[] args) {
      //System.out.println(palindrome("racecar"));
      //System.out.println(palindrome("blurg"));
      //
      //System.out.println(isPrime(49, 2));
      //System.out.println(isPrime(10, 2));
      //
      //timesTwo(80);
      //timesTwo(68);
      //
      //System.out.println(tri(6));
      //System.out.println(tri(24));
      
      //System.out.println(penta(4));
      //System.out.println(penta(2));
	   
	  // 6.   The merchant could have more than 5 children, as it is not specified what the exact number of
	  //      children he has. Out of all the children he has, half could still be daughters.
      
      //System.out.println(arraySum(new int[]{1, 2, 3, 4, 5}, 0));

	   //System.out.println(reverseString("emordnilap"));
       //printReverse("emordnilap");
	   
	   //9. The name of the fifth is "What", as a question is never posed, but instead What is stated as the fifth's name.
     
      //System.out.println(isPowerOfN(1048576, 2));
      //System.out.println(isPowerOfN(25, 3));
      
      //System.out.println(curlyString("what's {all this} then"));
      
      //printPattern2(16);
      
      //printSquares(5);
      //printSquares(8);
      
      //System.out.println(wordWrap("hello, how are you doing today?", 13));
	   
   }
   
//
   

   public static boolean palindrome(String s) {
 	  int n = s.length();
 	  int i = 0;
 	  
 	  if (s.substring(i, i + 1).contains(s.substring(n - i - 1, n - i))) {
 		 i++;
 		 String newStr = s.substring(i, n - i);
 		 if (newStr.length() < 2) {
 			 return true;
 		 }
		 return palindrome(newStr);
 	  }
 	  else {
 		  return false;
 	  }
   }
   
   public static boolean isPrime(int i, int j) {
	   if (i / 2 <= j) {
		   return true;
	   }
	   
	   if (i % j == 0) {
		   return false;
	   }
	   
	   else {
		   j++;
			return isPrime(i, j);
		}
		
   }
   
   public static void timesTwo(int i) {
		if (i % 2 == 0) {
			System.out.print("2 * ");
			i /= 2;
			timesTwo(i);
		}
		else {
			System.out.println(i);
		}
		
	}
   
   public static int tri(int i) {
		if (i == 0) {
			return 0;
		}
		else {
			return i + tri(i - 1);
		}
	}
   
   public static int penta(int n) {
		if (n == 0) {
			return 1;
		}
		else {
			return tri(n - 1) * 2 + tri(n) ;
		}
 }
      
   public static int arraySum(int[] a, int ind) {
		if (ind == a.length) {
			return 0;
		}
		else {
			return a[ind] + arraySum(a, ind + 1);
		}
	}
   
   public static String reverseString(String s) {
	   int n = s.length();
	   int i = 0;
	 	  
	   if (i == n) {
		   return "";
	   }
	   else {
		   i++;
		   return s.substring(n - i, n - i + 1) + reverseString(s.substring(0, n - i));
	   }
   }
   
   public static void printReverse(String s) {
	   int n = s.length();
	   int i = 0;
	 	  
	   if (i == n) {
		   System.out.println();
	   }
	   else {
		   System.out.print(s.substring(n - i - 1, n - i));
		   i++;
		   printReverse(s.substring(0, n - i));
		   
	   }
   }
   
   public static boolean isPowerOfN(int num, int base) {
	    if (base * base == num) {
	    	return true;
	    }
	    else if (num % base == 0) {
			num /= base;
			isPowerOfN(num, base);
			return true;
		}
		else {
			return false;
		}
	}
   
   
   public static String curlyString(String s) {
	   //return s.substring(s.indexOf("{") + 1, s.indexOf("}"));
	   
	   if (s.indexOf("{") != -1) {
		   return curlyString(s.substring(s.indexOf("{") + 1));
	   }
	   else if (s.indexOf("}") != -1) {
		   return curlyString(s.substring(0, s.indexOf("}")));
	   }
	   else {
		   return s;
	   }
   }
   
   public static void printPattern2(int i) {
	   if (i < 0) {
		   System.out.println(i);
	   }
	   else {
		   System.out.println(i);
		   printPattern2(i - 5);
		   System.out.println(i);
	   }
   }
   
   public static void printSquares(int i) {
	   if (i == 1) {
		   System.out.print(1 + ", ");
	   }
	   else {
		   if (i % 2 == 1) {
			   System.out.print(i * i + ", ");
			   printSquares(i - 2);
			   i--;
			   System.out.print(i * i + ", ");
		   }
		   else {
			   i--;
			   printSquares(i);
			   
		   }
		   
	   }
   }
   
   public static String wordWrap(String line, int width) {
	   if (line.length() > width) {
		   String y = line.substring(0, width + 1) + "\n";
		   String s = line.substring(width + 1, line.length());
		   return y + wordWrap(s, width);
	   }
	   else {
		   return line;
	   }
   }
   
}