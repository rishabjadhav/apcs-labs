import java.util.*;
import java.io.*;

public class Runner
{
    public static void main(String[]args)
    {

        try {
            Scanner input = new Scanner(new File("players.txt"));

            int p = 0;
            if(input.hasNextInt()){
                p = input.nextInt();   
            }
            Team indy = new Team(p);
           //int i = 0;
            while(input.hasNextLine()){
                //indy.addPlayer(new Player(input.next(), input.nextInt(), input.nextInt(),input.nextInt()),i);
                //i++;                
            }
            indy.printTeamStats();
        }
        catch (IOException e) {
            System.out.println("Can't find the file!");
        }

    }
}
