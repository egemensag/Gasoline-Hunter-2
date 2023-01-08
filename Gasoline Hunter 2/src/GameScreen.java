import java.awt.*;
import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import java.util.TimerTask;
import javax.swing.JApplet;
import javax.swing.Timer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.*;
import java.awt.event.KeyListener;
import java.io.IOException;

public abstract class GameScreen implements KeyListener{
	
	JLabel lblNewLabel = new JLabel("New label");
	Timer tiempo;
	JLabel otherCar=new JLabel();
	JLabel otherCar2=new JLabel();
	JLabel otherCar3=new JLabel();
	JLabel otherCar4=new JLabel();
	JLabel serit1 = new JLabel("serit");
    JLabel serit2 = new JLabel("serit2");
    JLabel serit3 = new JLabel("serit3");
    JLabel serit4 = new JLabel("serit4");
    Score sikor;
    
    
	protected JFrame frame;
	static int x;
	static int y;
	int counter=1;
	static int oy=0;
	static int oyy=0;
	static int oyyy=0;
	static int ox=350;
	static int ox2=150;
	static int ox3=550;
	static int oyyyy=0;
	static int ox4=220;
	static int stopper;
	HighScore raytır;

	
	public GameScreen() {
		
		
	}
	
	public void initilaze(String name){
		frame = new JFrame();
		frame.setBounds(0,0,800, 600);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setFocusable(true);
		frame.addKeyListener(new KeyListener(){
			@Override
			public void keyPressed(KeyEvent x){
				int a=x.getKeyCode();
				if(a==KeyEvent.VK_LEFT || a==KeyEvent.VK_A){
					repaintLeft();
				}
				else if(a==KeyEvent.VK_RIGHT || a==KeyEvent.VK_D){
					repaintRight();
				}
//				else if(a==KeyEvent.VK_UP || a==KeyEvent.VK_W){
//					repaintUp();
//				}
//				else if(a==KeyEvent.VK_DOWN || a==KeyEvent.VK_S){
//					repaintDown();
//				}
			}

			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}

		
			
		});
		
		x=375;
		y=450;
		
		
		JLayeredPane layeredPane = new JLayeredPane();
		frame.getContentPane().add(layeredPane, BorderLayout.CENTER);
		layeredPane.setLayout(null);
		otherCar.setBounds(350, oy, 78, 100);
		otherCar.setIcon(new ImageIcon("image/araba2.png"));
		
		otherCar2.setBounds(150, oy, 78, 100);
		otherCar2.setIcon(new ImageIcon("image/araba3.png"));
		
		otherCar3.setBounds(550, oy, 78, 100);
		otherCar3.setIcon(new ImageIcon("image/araba4.png"));
		
		otherCar4.setBounds(230, oy, 78,100);
		otherCar4.setIcon(new ImageIcon("image/araba4.png"));
		
		sikor= new Score(name);
//		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(x, y, 78, 100);
		lblNewLabel.setIcon(new ImageIcon("image/Araba.png"));
		layeredPane.add(lblNewLabel);
		serit1.setBounds(0,0,800,600);
		serit2.setBounds(0,0,800,600);
		serit3.setBounds(0,0,800,600);
		serit4.setBounds(0,0,800,600);
		
		serit1.setIcon(new ImageIcon("image/serit1.png"));
		serit2.setIcon(new ImageIcon("image/serit2.png"));
		serit3.setIcon(new ImageIcon("image/serit3.png"));
		serit4.setIcon(new ImageIcon("image/serit4.png"));
		layeredPane.add(otherCar);
		layeredPane.add(otherCar2);
		layeredPane.add(otherCar3);
		layeredPane.add(otherCar4);
		layeredPane.add(serit1);
		layeredPane.add(serit2);
		layeredPane.add(serit3);
		layeredPane.add(serit4);
		layeredPane.add(sikor.tabela);
		otherCar.setVisible(true);
		otherCar2.setVisible(true);
		otherCar3.setVisible(true);
		sikor.tabela.setVisible(true);
		serit1.setVisible(false);
		serit3.setVisible(false);
		serit4.setVisible(false);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setBounds(0, 0, 800, 600);
		lblNewLabel_1.setIcon(new ImageIcon("image/yol.jpg"));
		layeredPane.add(lblNewLabel_1);
		frame.setVisible(true);
		
		
		ActionListener actionlistener = new ActionListener() {
            
            public void actionPerformed(ActionEvent e) {
            	if(stopper!=0){
            		tiempo.stop();
            		
            	}
                if(counter%4==1){
                    serit1.setVisible(true);
                    serit2.setVisible(false);
                    serit3.setVisible(false);
                    serit4.setVisible(false);
                    counter++;
                    oy+=45;
                    otherCar.setBounds(ox, oy, 78, 100);
                    if(oy>=600){
                    	oy=-150;
                    	int [] xCoor={325,335,350,365,380,395,410,425};
                    	int upX=(int)(Math.random()*8);
                    	ox=xCoor[upX];
                    	
                    	}
                    if(Math.abs(x-ox)<70 && Math.abs(y-oy)<90){
                      	stopper=6;
                      	sikor.broke();
                      	raytır=new HighScore(sikor);
                      	raytır.writeFile();
                      	try {
							JOptionPane.showMessageDialog(null, raytır.getHighScore(sikor));
						} catch (HeadlessException | IOException e1) {
							e1.printStackTrace();
						}

                      	
                      }
                   
                    
                   
//                    repaint();
                }
                else if(counter%4==2){
                    serit1.setVisible(false);
                    serit2.setVisible(true);
                    serit3.setVisible(false);
                    serit4.setVisible(false);
                    counter++;
                    oyy+=25;
                    otherCar2.setBounds(ox2, oyy, 78, 100);
                    if(oyy>=600){
                    	oyy=-150;
//                    repaint();
                }
                    if(Math.abs(x-ox2)<70 && Math.abs(y-oyy)<90){
           			 stopper=7;
           			sikor.broke();
           			raytır=new HighScore(sikor);
                  	raytır.writeFile();
                  	try {
						JOptionPane.showMessageDialog(null, raytır.getHighScore(sikor));
					} catch (HeadlessException | IOException e1) {
						e1.printStackTrace();
					}

           			
           		}
                }
                else if(counter%4==3){
                	serit1.setVisible(false);
                    serit2.setVisible(false);
                    serit3.setVisible(true);
                    serit4.setVisible(false);
                    counter++;
                    oyyy+=65;
                    otherCar3.setBounds(ox3, oyyy, 78, 100);
                    if(oyyy>=600){
                    	oyyy=-150;
                    	int [] xCoor3={570,510,555,495,540,530};
                    	int upX3=(int)(Math.random()*6);
                    	ox3=xCoor3[upX3];
                    	
                    	}
                    if(Math.abs(x-ox3)<70 && Math.abs(y-oyyy)<90){
           			 stopper=9;
           			sikor.broke();
           			raytır=new HighScore(sikor);
                  	raytır.writeFile();
                  	try {
						JOptionPane.showMessageDialog(null, raytır.getHighScore(sikor));
					} catch (HeadlessException | IOException e1) {
						e1.printStackTrace();
					}

           			
           		
           		
           			 }
//                    repaint();
                }
                else{
                	serit1.setVisible(false);
                    serit2.setVisible(false);
                    serit3.setVisible(false);
                    serit4.setVisible(true);
                    counter++;
//                    repaint();
                    oyyyy+=35;
                    otherCar4.setBounds(ox4, oyyyy, 78, 100);
                    if(oyyyy>=600){
                    	oyyyy=-150;
                    }
                    if(Math.abs(x-ox4)<70 && Math.abs(y-oyyyy)<90){
           			 stopper=10;
           			sikor.broke();
           			raytır=new HighScore(sikor);
                  	raytır.writeFile();
                  	try {
						JOptionPane.showMessageDialog(null, raytır.getHighScore(sikor));
					} catch (HeadlessException | IOException e1) {
						e1.printStackTrace();
					}
           			 } 
                }
            }
        };
        tiempo = new Timer(75,actionlistener);
        tiempo.start();
        frame.setVisible(true);
	}	
	public void repaintLeft(){
		int xxx=150;
		x-=15;
		if(x<=150){
			lblNewLabel.setBounds(xxx, y, 78, 100);
			x=xxx;		
		}
		else{	
		lblNewLabel.setBounds(x,y,78,100);
		}		
	}
	public void repaintRight(){
		int xx=570;
		x+=15;
		if(x>=570){
			lblNewLabel.setBounds(xx, y, 78, 100);
		x=xx;
		}
		else{
		lblNewLabel.setBounds(x, y, 78, 100);
		}	
}
}
