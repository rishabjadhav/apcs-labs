import java.util.*;
public class Tester {
    public static void main (String[] args) {
        System.out.println("Hello again, world!");
        
        //this is a comment!
        
        int numApples = 25;
        
        final int PRICE_OF_APPLES = 150;
        
        System.out.println("The total for " + numApples + " apples: \n" + numApples * PRICE_OF_APPLES + " cents");
        
        if (numApples * PRICE_OF_APPLES >= 2000) {
           System.out.println("Thank you valued customer!");
        }
        
        for (int n = 8; n > 0; n--) {
           System.out.print(n + " ");
        }
        
        System.out.println(" ");
        
        for (int multiple = 150; multiple <= 300; multiple += 3) {
           System.out.print(multiple + " ");
        }
        
        System.out.println(" ");
        
        int sum = 0;
        for (int i = 0; i <= 100; i++) {
           sum += i;
        }
        
        System.out.println(sum);
        System.out.println("");
        
        //Riddle : Silence
        
        Scanner console = new Scanner(System.in);
        System.out.println("Enter a double");
        double num = console.nextDouble();
        
        System.out.println(Math.sqrt(num));
        System.out.println("num^3 = " + Math.pow(num, 3));
        
        System.out.println("Enter 2 integers");
        int num1 = console.nextInt();
        int num2 = console.nextInt();
        
        if ((num1 - num2 <= 10) && (num1 - num2 > 0)) {
           System.out.println("Within 10");
        }
        else {
            if ((num2 - num1 <= 10) && (num2 - num1 > 0)) {
              System.out.println("Within 10");  
            }
            System.out.println("Not within 10");
        }
        
        int sumloop = 0;
        System.out.println("Enter integers");
        int eighteen = console.nextInt();
        int e = 0;
        while (eighteen != 0) {
           sumloop = eighteen + sumloop;
           eighteen = console.nextInt();
           e++;
        }
        double average = (sumloop / e);
        System.out.println("The total sum is " + sumloop);
        System.out.println("The average is " + average);
        
        double[] areas;
        areas = new double[20];
        
        areas[0] = 4.56;
        
        int length = areas.length;
        System.out.println("Length is " + length);
        
        boolean[] twentyTwo = {true, true, false, false, true};
        System.out.println(twentyTwo);
        
        //23 riddle : idk
        
        //29
        simpleMethod();
        sum(4, 2);
        sumTon(10);
        triangle(7);
        altCaps("aaaaaaaaa");

        //31
        Player player1 = new Player();
        System.out.println(player1.playerInfo());
        
        Player player2 = new Player("Jones", 11);
        System.out.println(player2.playerInfo());
        console.close();
    }
    public static void simpleMethod() {
         System.out.println("This is a method!");
    }
    
    public static int sum(int a, int b) {
         return a + b;
    }
    
    public static int sumTon(int n) {
      int sum = 0;
       for (int x = 1; x <= n; x++) {
        if ((x % 3 == 0) || (x % 5 == 0)) {
           sum += x;
        }
     }
      return sum;
    } 
    
    public static void triangle(int n) {
      for (int x = 1; x <= n; x++) {
           for (int y = 1; y <= x; y++) {
               System.out.print(x);
           }
           System.out.println(" ");
      }
    }
    
    public static String altCaps (String s) {
      String str = "";
      
      for (int x = 0; x < s.length(); x++) {
        char y  = s.charAt(x);
        if (Character.isLetter(y) == true) {
           if (x % 2 == 0) {
               y = Character.toUpperCase(y);
           }
          else {
               y = Character.toLowerCase(y);
           }
        }
        str += y;   
      }
      System.out.println(str);
      return str;
    }
}   