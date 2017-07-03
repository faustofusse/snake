package Snake;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class Ventana extends JFrame {
	public static boolean empezo = false;
	
	private ImageIcon negro = new ImageIcon("src/Snake/img/negro.png");
	private ImageIcon azul = new ImageIcon("src/Snake/img/azul.png");
	private ImageIcon verde = new ImageIcon("src/Snake/img/verde.png");
	
	
	public Ventana(){	
		
		setVisible(true);
		
		setBounds(400,100,Const.COLUMNAS*20+15,Const.FILAS*20+15);
		setResizable(false);
		setTitle(Const.TITULO_VENTANA);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		add(new LayerPrincipal());
		addKeyListener(new AccionesDeTeclas());
		
		empezar(5);
	}
	
	public static void empezar(int tamanio){
		
		Cuadradito.snake.add(Cuadradito.posicion);

		Cuadradito.colorearSnake();
		
	}
	

}
