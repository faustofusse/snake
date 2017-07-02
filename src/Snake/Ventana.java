package Snake;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class Ventana extends JFrame implements KeyListener{
	public static boolean empezo = false;
	public static boolean pausa = false;
	public static int fijado = Constantes2.COLUMNAS +1;
	private ImageIcon negro = new ImageIcon("src/Snake/img/negro.png");
	private ImageIcon azul = new ImageIcon("src/Snake/img/azul.png");
	private ImageIcon verde = new ImageIcon("src/Snake/img/verde.png");
	
	
	public Ventana(){	
		setVisible(true);
		
		setBounds(400,100,Constantes2.COLUMNAS*20+15,Constantes2.FILAS*20+15);
		setResizable(false);
		setTitle("Snake");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		add(new LayerPrincipal());
		addKeyListener(this);
		
		Cuadraditos.snake.add(fijado);
		Cuadraditos.snake.add(fijado+1);
		Cuadraditos.snake.add(fijado+2);
		Cuadraditos.snake.add(fijado+3);
		Cuadraditos.snake.add(fijado+4);
		
		Cuadraditos.colorearSnake();
		
		
		
	}
	
	public static void setFijado(int num){
		fijado = num;
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		LayerPrincipal.ponerCosito();
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if (e.getKeyCode() == 37 || e.getKeyCode() == 65){
			//LEFT
			if (Mover.dir != "right"){
				Cuadraditos.mover("left");
			}
		}else if (e.getKeyCode() == 38 || e.getKeyCode() == 87){
			//UP
			if (Mover.dir != "down"){
				Cuadraditos.mover("up");
			}
		}else if (e.getKeyCode() == 39 || e.getKeyCode() == 68){
			//RIGHT
			if (Mover.dir != "left"){
				Cuadraditos.mover("right");
			}
		}else if (e.getKeyCode() == 40 || e.getKeyCode() == 83){
			//DOWN
			if (Mover.dir != "up"){
				Cuadraditos.mover("down");
			}
		}else if (e.getKeyCode() == 80){
			//P
			if (pausa){
				pausa=false;
				Main.mov.mover = true;
				Main.mov.run();
			}else{
				System.out.println("PAUSA");
				pausa=true;
				Main.mov.mover = false;
			}
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
		
		
	}

}
