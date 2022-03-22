import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.AbstractAction;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Display {
	
	JLabel label;
	JFrame frame;
	JPanel panel;
	private String[] bfNameArray = {"Aldrich", "Alfred", "William", "Henry", "Walter", "Ralph", "Francis", "Nicholas", "Hugh", "Humphrey", "Simon", "Edmund", "Barnard", "Christopher", "Richard", "Philip"};
	private String[] gfNameArray = {"Alice", "Margaret", "Isabelle", "Matilda", "Eleanor", "Jane", "Rebecca", "Edith", "Margot", "Agnes", "Anne", "Emilia", "Mary", "Olivia", "Charlotte", "Amelia", "Geneviève"};
	private String[] lNameArray = {"Covington", "de Brygenhall", "Gutersworth", "Oglethorpe", "Richemond", "Whitchester", "Yorke", "Ryllyngton", "Knottingham", "Northefolk", "Middleton", "Lyons", "Leedes"};
	
	public Display() {
		frame = new JFrame();
		
		label = new JLabel("          *   generated name   *          ");
		panel = new JPanel();
		
		panel.setBorder(BorderFactory.createEmptyBorder(200, 300, 200, 300));
		panel.setLayout(new GridLayout(0,1));
		panel.add(mButton);
		panel.add(fButton);
		panel.add(label);
		
		frame.add(panel, BorderLayout.CENTER);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Random Name Generator");
		frame.pack();
		frame.setVisible(true);
	}
	
	public static void main (String[]args) {
		new Display();
	}

	JButton mButton = new JButton(new AbstractAction("Male") {
        @Override
        public void actionPerformed(ActionEvent e) {
        	Random rng = new Random();
        	String bfName = "Sir " + bfNameArray[rng.nextInt(bfNameArray.length)] + " " + lNameArray[rng.nextInt(lNameArray.length)];
			label.setText(bfName);
        }
    });

    JButton fButton = new JButton(new AbstractAction("Female") { 
        @Override
        public void actionPerformed(ActionEvent e) {
        	Random rng = new Random();
        	String gfName = "Lady " + gfNameArray[rng.nextInt(gfNameArray.length)] + " " + lNameArray[rng.nextInt(lNameArray.length)];
			label.setText(gfName);
        }
    });
}
