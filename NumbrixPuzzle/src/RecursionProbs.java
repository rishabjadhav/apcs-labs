public class RecursionProbs {
   public static void main(String[] args) {
//      System.out.println(numEars(10));
//      countdown(5);   
//      System.out.println(factorial(5));
//      System.out.println(cheerlead("Go team!", 3));
//      System.out.println(pow(2, 5));
//      System.out.println(fibonacci(7));
//      printPattern(16);
//      printPattern(10);
//      System.out.println(countNumA("applebanana"));
//      printAtoBbyC(10, 30, 5);
//      System.out.println();
//      System.out.println(countOdds(12334596));
      System.out.println(sumDigits(12598));
      
      
   }
   
   public static int sumDigits(int i) {
	   int sum = 0;
	   if (i == 0) {
		   return 0;
	   }
	   else {
		   sum += (i % 10);
		   return sum + sumDigits((i - (i % 10)) / 10);
	   }
}

   public static int countOdds(int i) {
	   int counter = 0;
	   if (i == 0) {
		   return 0;
	   }
	   else if (i % 2 == 0) {
		   i -= i % 10;
		   i /= 10;
		   return counter + countOdds(i);
	   }
	   else if (i % 2 == 1) {
		   counter++;
		   i -= i % 10;
		   i /= 10;
		   return counter + countOdds(i);
	   }
	   else {
		   return 0;
	   }
	}

   public static void printAtoBbyC(int a, int b, int c) {
	   System.out.print(a + ", ");
	   if (a + c != b) {
		   a += c;
		   printAtoBbyC(a, b, c);
	   }
	   else {
		   System.out.println(b);
	   }
	
}

   public static int countNumA(String string) {
	   String str = string;
	   int counter = 0;
	   if (str.contains("a")) {
		   str = string.substring(string.indexOf("a") + 1);
		   counter++;
		   return counter + countNumA(str);
	   }	else {
		   return 0;
	   }
   }

   public static void printPattern(int i)
   {
       if (i > 0)
       {
    	   System.out.print(i + ", ");
           printPattern(i - 5);
       }
       else
       {
           System.out.println(i);
       }
   }

   public static int fibonacci(int i)
   {
       if (i > 2) {
    	   return fibonacci(i - 2) + fibonacci(i - 1);
       }	else {
    	   return 1;
       }
   }

   public static int pow(int i, int j) {
	   if (i == 0) {
		   return -1;
	   }
	   int dupeI = i;
	   int dupeJ = j;
	   int ans = dupeI;
	   
	   if (dupeJ > 1) {
		   dupeJ--;
		   return dupeI * pow(ans, dupeJ);
	   }	else {
		   return i;
		   
	   }
}

   public static String cheerlead(String string, int i) {
	   	int dupe = i;
	   	String str = "";
	   	if (dupe > 1) {
	   		dupe--;
	   		str += string + " ";
	   		return str += cheerlead(str, dupe);
	   	}	else {
	   		return string;
	   	}
   }

   public static int factorial(int i) {
	   int dupe = i;
	   if (dupe > 1) {
		   dupe--;
		   return i * factorial(dupe);
	   }
	   else {
		   return 1;
	   }
   }

   public static int numEars(int bunnies) {
	   int dupe = bunnies;
	   if (dupe > 1) {
		   return 2 + numEars(dupe - 1);
	   }
	   
	   else {
		   return 2;
	   }
   }
   
   public static void countdown (int num) {
	   if (num == 0) {
		   System.out.println("blastoff!");
	   }
	   else {
		   System.out.print(num + ", ");
		   num--;
		   countdown(num);
		   
	   }
   }
   
}