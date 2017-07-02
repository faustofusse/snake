package Snake;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Main{

	public static Mover mov;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Ventana ventana1 = new Ventana();
		ventana1.setVisible(true);
		
		mov = new Mover();
		mov.mover = true;
		mov.dir = "right";
		mov.run();
	}

}
