import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.Calendar;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.text.MaskFormatter;

/**
 * A class that validates user input, used as part of an input form
 */

//1
public class ValidateForm
{
    public ValidateForm() {
        //no vars to initialize
    }
    
    //2
    public boolean isAllAlpha(String str) {
       char[] chars = str.toCharArray();
       for (char c : chars) {
           if(!Character.isLetter(c)) {
               return false;
            }
        }
       return true; 
    }
    
    //3
    public boolean isNumeric(String str) {
       int decimal = 0;
       char[] chars = str.toCharArray();
       for (char c : chars) {
          if (!Character.isDigit(c)) {
            if (c == '.') {
               decimal++;
               if (decimal > 1) {
                   return false;
               }
               else {
                   return false;
               }
            }
          }
       }
       return true;
    }
    
    //4
    /** validate the user's entered name */
    public String checkName(String name) {
       if (!isAllAlpha(name)) {
            return "Invalid name!\n";
       }
       if (name.length() < 2) {
            return "Invalid name!\n";
       }
       return "";
    }
    
    //6
    /** validate the user's entered email */
    public String checkEmail(String email) {
        if (email.indexOf("@") < 1) {
            return "Invalid email!\n";
        }
        if (email.indexOf(".") == -1) {
            return "Invalid email!\n";
        }
        if (email.indexOf(".") < email.indexOf("@")) {
            return "Invalid email!\n";
        } 
        if ((email.length() - email.indexOf(".")) < 3)
            return "Invalid email!\n";
        return "";
    }
    
    //5
    /** validate the user's enter password */
    public String checkPW(String pw) {
        boolean characters = pw.length() >= 4;
        boolean uppercase = false;
        boolean lowercase = false;
        for (char c : pw.toCharArray()) {
            if (Character.isUpperCase(c))
                uppercase = true;
            if (Character.isLowerCase(c))
                lowercase = true;
        }
        if (!characters) {
            return "Invalid password!\n";
        }
        if (!lowercase) {
            return "Invalid password!\n";
        }
        if (!uppercase) {
            return "Invalid password!\n";
        }
        return "";
    }
    
    //7
    /** validate the user's entered zipcode */
    public String checkZip(String zip) {
        if (zip.length() > 5 || zip.length() < 3) {
            return "Invalid zip!\n";
        }
        if (!isNumeric(zip)) {
            return "Invalid zip!\n";
        }
        return "";
    }
    
    //8
    /** validate the user's entered birth year */
    public String checkBirth(String date) {
        int currentYear = Calendar.getInstance().get(Calendar.YEAR);
        int year = 0;
        try {
            year = Integer.parseInt(date);
            if (((currentYear - year) > 100) || (currentYear - year < 10)) {
                return "Invalid year!\n";
            }
        }
        catch (NumberFormatException ex) {
            return "Invalid year!\n";
        }
        return "";
    }
    
    //9
    /** validate the user's entered phone number */
    public String checkPhone(String phone) {
        String strNew = phone.replace("-","");
        if (!isNumeric(strNew)) {
            return "Invalid phone!\n";
        }
        return "";
    }

    /** main method for testing / setting up the GUI */
    public static void main(String[] args)
    {
        /*
         * you can add other method calls here for testing
         */
        //10
        ValidateForm test = new ValidateForm();
        System.out.println(test.isAllAlpha("test"));
        System.out.println(test.isAllAlpha("test123"));
        System.out.println(test.isNumeric("test123"));
        System.out.println(test.isNumeric("123"));
        System.out.println(test.isNumeric("123.123"));
        System.out.println(test.isNumeric("123.123.123"));
        
        //set up the GUI, you don't need to understand this code
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                //the frame is the GUI, it uses a ValidateForm object
                TextComponentFrame frame = new TextComponentFrame(new ValidateForm());
                frame.setVisible(true);
            }
        });
        
    }
}

/**
 * A frame (GUI) with simple text components to simulate a web form
 */
class TextComponentFrame extends JFrame 
{
    static final int DEFAULT_WIDTH  = 300;
    static final int DEFAULT_HEIGHT = 400;

    ValidateForm validater;

    public TextComponentFrame(ValidateForm v)
    {
        validater = v;

        initGUI();
        
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        super.setLocationRelativeTo(null); //center on screen
    }

    /** initialize the GUI components, e.g. buttons and text fields */
    private void initGUI()
    {
        setTitle("Subscription Form");
        setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);

        final JTextField personName = new JTextField();
        final JTextField emailField = new JTextField();
        final JTextField zipCode    = new JTextField();
        final JTextField birthDate  = new JTextField();

        MaskFormatter mfor = null;
        try {
            mfor = new MaskFormatter("###-###-####");
        }
        catch (ParseException e) {}

        final JFormattedTextField phoneNumber   = new JFormattedTextField(mfor);
        final JPasswordField      passwordField = new JPasswordField();

        JPanel northPanel = new JPanel();
        northPanel.setLayout(new GridLayout(6, 6)); //dimensions of layout
        northPanel.add(new JLabel("Name :  ", SwingConstants.RIGHT));
        northPanel.add(personName);
        northPanel.add(new JLabel("Password :  ", SwingConstants.RIGHT));
        northPanel.add(passwordField);
        northPanel.add(new JLabel("Email : ", SwingConstants.RIGHT));
        northPanel.add(emailField);
        northPanel.add(new JLabel("Zip Code (US) : ", SwingConstants.RIGHT));
        northPanel.add(zipCode);
        northPanel.add(new JLabel("Year of Birth: ", SwingConstants.RIGHT));
        northPanel.add(birthDate);
        northPanel.add(new JLabel("Phone Number: ", SwingConstants.RIGHT));
        northPanel.add(phoneNumber);

        add(northPanel, BorderLayout.NORTH);

        final JTextArea textArea = new JTextArea(8, 40);
        JScrollPane scrollPane   = new JScrollPane(textArea);

        add(scrollPane, BorderLayout.CENTER);

        // add button to listen for events, append text into the text area

        JPanel  southPanel   = new JPanel();
        JButton submitButton = new JButton("Submit");
        southPanel.add(submitButton);
        submitButton.addActionListener(new ActionListener() //make anonymous action listener
        {
            /** this method is called in response to an event, in this case the "Submit" button pressed */
            public void actionPerformed(ActionEvent event)
            {
                String name     = personName.getText() ;
                String email    = emailField.getText();
                String zip      = zipCode.getText();
                String birth    = birthDate.getText();
                String phone    = phoneNumber.getText(); 
                String password = new String(passwordField.getPassword());

                String result = ""; 

                result += validater.checkName(name);
                result += validater.checkPW(password);
                result += validater.checkEmail(email);
                result += validater.checkZip(zip);
                result += validater.checkBirth(birth);
                result += validater.checkPhone(phone);

                if (result.length() == 0)
                    result = "Input accepted!";

                textArea.setText(result);
            }
        });

        add(southPanel, BorderLayout.SOUTH);
    }
}
