import java.util.*;
public class Factors {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);  
        System.out.print("Enter number: "); 
        int n = in.nextInt();
        while (n != 0) {
            Factors test = new Factors();
            test.factors(n);
            System.out.println();
            System.out.print("Enter number: "); 
            n = in.nextInt();
        } 
        in.close();
    }
    public void factors(int n) {
        int count = 0;
        int[] factors = new int[n];
        for (int i = 2; i < n; i++) {
            if (n % i == 0) {
                count++;
                factors[i] = i;
            }
        }
        
        System.out.print("There are " + count + " factors for the number " + n + ":");
        
        for (int i : factors) {   
            if (factors[i] != 0) {
                System.out.print(" " + factors[i]);
            }
        }
    }
}