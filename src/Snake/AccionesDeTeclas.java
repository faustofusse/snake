package Snake;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class AccionesDeTeclas implements KeyListener{
	
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void keyPressed(KeyEvent e) {
	
		if (e.getKeyCode() == 37 || e.getKeyCode() == 65){
			//LEFT
			if (Mover.direccion != Const.RIGHT){
				Mover.direccion = Const.LEFT;
			}
		}else if (e.getKeyCode() == 38 || e.getKeyCode() == 87){
			//UP
			if (Mover.direccion != Const.DOWN){
				Mover.direccion = Const.UP;
			}
		}else if (e.getKeyCode() == 39 || e.getKeyCode() == 68){
			//RIGHT
			if (Mover.direccion != Const.LEFT){
				Mover.direccion = Const.RIGHT;
			}
		}else if (e.getKeyCode() == 40 || e.getKeyCode() == 83){
			//DOWN
			if (Mover.direccion != Const.UP){
				Mover.direccion = Const.DOWN;
			}
		}else if (e.getKeyCode() == 80){
			//P
			if (Main.pausa && !Main.perdio){
				Main.pausa=false;
			}else if (!Main.perdio){
				System.out.println("PAUSA");
				Main.pausa=true;
			}
		}else if (e.getKeyCode() == 10){
			//ENTER
			if (!Main.iniciado){
				Ventana.start();
				Main.iniciado = true;
			}else if (Main.perdio){
				Ventana.restart();
			}
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
		
		
	}

}
