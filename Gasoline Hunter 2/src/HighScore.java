import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.File;
import javax.swing.JOptionPane;
import java.util.Scanner;



public class HighScore{
   static String x;
   static String []ax=new String[15];
   static int k=0;
	public HighScore(Score a) {
		
		x=a.getScore();
		
		
	}
	public static void writeFile(){

	
		BufferedWriter writer = null;
        try {
           
            File myFile = new File("HighScores.txt");
   
           // writer = new BufferedWriter(new FileWriter(myFile));
            writer = new BufferedWriter(new FileWriter(myFile, true)); 
            
            writer.write(x);
            writer.newLine();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
               
                writer.close();
            } catch (Exception e) {
            }
        
    }
	}
	
	public static String readFile(String fileName) throws IOException{
		BufferedReader reader =new BufferedReader(new FileReader(fileName));
		try{
			StringBuilder sb=new StringBuilder();
			String line = reader.readLine();
			while(line!=null){
				sb.append(line);
				ax[k]=line;
				sb.append("\n");
				k++;
				line = reader.readLine();
			
			}
			return sb.toString();
		}
		finally{
			reader.close();
		}
	}
	public static String getHighScore(Score a) throws IOException{
		
		return a.getScore();
		
	}
	public static String getHighScores() throws IOException{
		readFile("HighScores.txt");
		String highS="";
		for(int i=0;i<ax.length;i++){
			highS+=""+ ax[i]+"\n";
			
		}
		return highS;
		
	}
	
}

		
	



