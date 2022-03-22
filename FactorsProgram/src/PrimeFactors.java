import java.util.*;
public class PrimeFactors {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        in.close();
        System.out.print("Enter number : "); 
        int num = in.nextInt();
        while (num != 0) {
            PrimeFactors test = new PrimeFactors();
            test.primeFactors(num);
            System.out.println();
            System.out.print("Enter number: "); 
            num = in.nextInt();
        } 
    }
    public void primeFactors(int num) {
        int count = 0;
        int n = num;
        int[] primefactors = new int[num];
        if (n == 2) {
            primefactors[0] = 2;
        }
        
        else {
           for (int i = 2; i < n; i++) {
               while (n % i == 0) {
                   primefactors[count] = i;
                   count++;
                   n = n/i;
               }
           }
           if (n > 2) {
               primefactors[count] = n;;
           }
        }
        
        System.out.print("Prime factorization for " + num + " is ");
        
        for (int i  = 0; i < num; i ++) {   
           if (primefactors[i] != 0) {
              System.out.print(" " + primefactors[i]);
           }
        }
    }
}
