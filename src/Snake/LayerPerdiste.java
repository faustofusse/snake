package Snake;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class LayerPerdiste extends JPanel implements ActionListener{
	private Image background;
	
	public LayerPerdiste(){
		JButton hola = new JButton("Holawa");
		hola.addActionListener(this);
		add(hola);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	 

}
