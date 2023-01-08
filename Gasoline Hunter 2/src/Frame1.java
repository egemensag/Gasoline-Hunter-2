import javax.swing.*;
import java.awt.event.*;
import java.io.IOException;
import java.awt.*;
//importing all the classes from awt and Swing package
public class Frame1 extends GameScreen{
	private JFrame frame1;
	private JTextField textfield1;
	//Creating frame and textfield objects
	
	public static void main(String[]args){
		
		Frame1 frame=new Frame1();
		//Creating Frame1 Object
	}
	
	public Frame1(){  
		frame1 = new JFrame();  //Creating new frame with name frame1
		frame1.setTitle("Gas Hunter 2"); //Setting title
		frame1.getContentPane().setBackground(new Color(0,0,0)); //Setting background color as black
		frame1.setBounds(100, 100, 500, 350); 
		frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		

		JButton newGame= new JButton("New Game"); //Creating 3 buttons for guide the user
		final JButton howtoplay=new JButton("How To Play");
		JButton highscores=new JButton("High Scores");
		
		
		newGame.addActionListener(new ActionListener(){
			   public void actionPerformed(ActionEvent e){
			    String name = JOptionPane.showInputDialog(frame1, "What's your name?");
			    if(name!=""){
//			    	GameScreen game = new GameScreen();
			    	initilaze(name);
			    	frame1.setVisible(false);
			    
			    }
			   }
			   
			  });
		
		howtoplay.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent x){
				JOptionPane.showMessageDialog(howtoplay, "You can control the car" + "\nby using left and right arrow keys."+"\nTry to avoid crash with other cars."+"\nCollect the gas cans for reach long distances."+"\nGood luck! Have Fun!"  );
			}
		});
		
		highscores.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent x){
				try {
					JOptionPane.showMessageDialog(null, raytır.getHighScores());
				} catch (HeadlessException | IOException e1) {
					e1.printStackTrace();
				}
				
			}
		});
		
		
		
		frame1.getContentPane().setLayout(null); //Setting layout
		
		
		JLabel label1=new JLabel(); //Creating new label named as label1
		label1.setIcon(new ImageIcon("image/picture.jpg")); // Setting an image on label
		label1.setBounds(0, 100, 300, 250);//Label's x,y-axis and height,weight properties
		frame1.getContentPane().add(label1); //Adding label to our frame
		
		
		newGame.setBounds(359, 140, 117, 29); //Creating new game buttons with custom coordinates
		howtoplay.setBounds(359,165,117,29);
		highscores.setBounds(359, 190, 117, 29);
		frame1.getContentPane().add(newGame); //Adding buttons to frame
		frame1.getContentPane().add(howtoplay);
		frame1.getContentPane().add(highscores);
		
		frame1.setResizable(false);
		
		
		frame1.setVisible(true);//At the end setting frame as visible,we done it at the end otherwise we can just see menu buttons and black ground
	    
	    }

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	
	}
	

