package Snake;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class Ventana extends JFrame {
	public static boolean empezo = false;
	
	private static ImageIcon negro = new ImageIcon("src/Snake/img/negro.png");
	private static ImageIcon azul = new ImageIcon("src/Snake/img/azul.png");
	private static ImageIcon verde = new ImageIcon("src/Snake/img/verde.png");
	
	
	public Ventana(){	
		
		setVisible(true);
		
		setBounds(400,100,Const.COLUMNAS*20+15,Const.FILAS*20+15);
		setResizable(false);
		setTitle(Const.TITULO_VENTANA);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		add(new LayerPrincipal());
		addKeyListener(new AccionesDeTeclas());
		
	}
	
	public static void start(){	
		Cuadradito.snake.add(Cuadradito.posicion);
		Cuadradito.colorearSnake();
		empezo = true;
		Main.pausa = false;
		Mover.direccion = Const.RIGHT;
		LayerPrincipal.ponerCosito();
	}
	
	public static void restart(){
		pintarTodos();
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Cuadradito.snake.clear();
		Main.score = 0;
		Main.perdio = false;
		Cuadradito.posicion = Const.COLUMNAS +1;
		start();
	}
	
	private static void pintarTodos(){
		for (int i =0; i<Const.COLUMNAS*Const.FILAS;i++){
			LayerPrincipal.cuadrados[i].setIcon(negro);
			LayerPrincipal.cuadrados[i].isCosito = false;
		}
	}

}
