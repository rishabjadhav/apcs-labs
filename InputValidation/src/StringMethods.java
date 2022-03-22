import java.util.*;

public class StringMethods {
    public StringMethods() {
        //constructor
    }
    
    //6
    public void unusualHello(String name) {
        System.out.println("Hello " + name + ", you dummy!");
    }
    
    //7
    public String stringRipper(String str) {
        return str.substring(0,1) + str.substring(str.length() - 1);
    }
    
    //8
    public boolean evenFooBar(String s) {
        int foo = 0;
        int bar = 0;
        for(int i = 0; i < s.length() - 2; i++) {
        if(s.substring(i, i + 3).equals("foo"))
            foo++;
        if(s.substring(i, i + 3).equals("bar"))
            bar++;
        }
        return foo==bar;
    }
    
    //10
    public int sumString(String str) {
        Scanner chopper = new Scanner(str);
        int sum = 0;
        while (chopper.hasNext())
        {
            if(chopper.hasNextInt()) {
                sum+= chopper.nextInt();
            }
            else {
                chopper.next();
            }
            chopper.close();
        }
        return sum;
    }
    //11
    public String decode(String key, String code) {
        String s = "";
        Scanner chopper = new Scanner(code);
        while (chopper.hasNextInt())
        {
            s+= key.charAt(chopper.nextInt());
        }
        chopper.close();
        return s;
    }
}
