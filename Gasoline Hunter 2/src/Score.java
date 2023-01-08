import javax.swing.JLabel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;



public class Score{
public int score=0;
public JLabel tabela;
public String name;

Timer taym;
    public Score(String a) {
    	
    	name=a;
    	tabela =  new JLabel();
    	tabela.setBounds(0,0,100,100);
    	ActionListener increase;
    increase = new ActionListener() {
        
        public void actionPerformed(ActionEvent e) {
            score=score+2;
            tabela.setText(""+score);
        }	
    };
    taym = new Timer(50,increase);
    taym.start();
    }
    public String toString(){
    	return name+" \t" + score;
    }
    void broke(){
        taym.stop();
        
}
    public String getScore(){
    	
    	return name +":"+score;
    }
 
    
    
}