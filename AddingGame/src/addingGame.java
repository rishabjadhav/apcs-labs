import java.util.*;
public class addingGame {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        System.out.println("Time to play the Adding Game! Good Luck!");
        System.out.println("Solve the problems that will be listed below.");
        int a = 0;
        int points = 0;
        int lives = 3;
        int b = 0;
        while (lives > 0) {
            int c = (int)(Math.random()*(3+1)+2);
            b = 0;
            for (int i = 0; i <= c; i++) {
                a = (int)(Math.random()* (9+1)+1);
                b += a;
                if (i == c) {
                    System.out.println(a + " = ");
                    System.out.println("Please enter what you think the answer is.");
                    int answer = console.nextInt();
                    if (answer == b) {
                        points++;    
                        System.out.println("Correct! You have a total points value of : " + points);
                    }
                    else {
                        lives--;
                        System.out.println("Wrong! the answer was " + b);
                        if (lives == 0)
                        {
                            System.out.println("You earned " + points + " points."); 
                        }
                    }
                }
                
                else {
                    System.out.print(a + " + ");    
                }
            }  
        }
        System.out.println("Game over!");
        console.close();
    }
}
