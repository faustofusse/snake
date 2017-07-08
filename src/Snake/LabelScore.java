package Snake;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;


public class LabelScore extends JLabel{
	
	private javax.swing.border.Border border;
	private EmptyBorder margin = new EmptyBorder(201,215,0,0);
	
	public LabelScore(){
		
		border = this.getBorder(); 
		
		this.setText(String.valueOf(Main.score));
		  
		this.setForeground(Color.white);
		  
		this.setFont(new Font("Arial", 0, 23));
		
		this.setBorder(new CompoundBorder(border, margin));
	}
	
}
