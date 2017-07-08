package Snake;

import javax.swing.JFrame;

public class VentanaPerdiste extends JFrame{
	
	public VentanaPerdiste(){
		setSize(200, 150);
		setBounds(500,220,(Const.COLUMNAS*20)/2,(Const.FILAS*20)/4+50);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		add(new LayerPerdiste());
	}
	
}
