package Snake;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Ventana extends JFrame {
	public static boolean empezo = false;
	
	private static ImageIcon negro = new ImageIcon("src/Snake/img/negro.png");
	private static ImageIcon azul = new ImageIcon("src/Snake/img/azul.png");
	private static ImageIcon verde = new ImageIcon("src/Snake/img/verde.png");

	private static ImageIcon r = new ImageIcon("src/Snake/img/r.png");
	private static ImageIcon e = new ImageIcon("src/Snake/img/e.png");
	private static ImageIcon n = new ImageIcon("src/Snake/img/n.png");
	private static ImageIcon p = new ImageIcon("src/Snake/img/p.png");
	private static ImageIcon s = new ImageIcon("src/Snake/img/s.png");
	private static ImageIcon t = new ImageIcon("src/Snake/img/t.png");
	
	public Ventana(){	
		
		setVisible(true);
		
		setBounds(400,100,Const.COLUMNAS*20+15,Const.FILAS*20+15);
		setResizable(false);
		setTitle(Const.TITULO_VENTANA);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		add(new LayerPrincipal());
		addKeyListener(new AccionesDeTeclas());
		
		pintarIntro();
	}
	
	public static void start(){	
		pintarTodos();
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
		Mover.velocidad = Const.VELOCIDAD;
		Cuadradito.posicion = Const.COLUMNAS +1;
		start();
	}
	
	private static void pintarTodos(){
		for (int i =0; i<Const.COLUMNAS*Const.FILAS;i++){
			LayerPrincipal.cuadrados[i].setIcon(negro);
			LayerPrincipal.cuadrados[i].isCosito = false;
		}
	}
	
	private static void pintarIntro(){
		pintarTodos();
		int pos = 9*Const.FILAS+Const.COLUMNAS/5;
		LayerPrincipal.cuadrados[pos].setIcon(p);
		LayerPrincipal.cuadrados[pos+1].setIcon(r);
		LayerPrincipal.cuadrados[pos+2].setIcon(e);
		LayerPrincipal.cuadrados[pos+3].setIcon(s);
		LayerPrincipal.cuadrados[pos+4].setIcon(s);
		
		LayerPrincipal.cuadrados[pos+6].setIcon(e);
		LayerPrincipal.cuadrados[pos+7].setIcon(n);
		LayerPrincipal.cuadrados[pos+8].setIcon(t);
		LayerPrincipal.cuadrados[pos+9].setIcon(e);
		LayerPrincipal.cuadrados[pos+10].setIcon(r);
	}
	
	public static void mensajePerdio(){
			    
	    //JOptionPane.showMessageDialog(frame,"Has perdido...");
		//JOptionPane.showMessageDialog(null, "Has perdido", "Perdiste!!!", JOptionPane.ERROR_MESSAGE);
		
		int resp = JOptionPane.showConfirmDialog(null,"Puntos obtenidos: "+ Main.score + " \n Queres volver a empezar?", "Perdiste!", JOptionPane.YES_NO_OPTION, JOptionPane.ERROR_MESSAGE);
		if(resp == JOptionPane.YES_OPTION){ 
			//Aca le das para que empiece
			Ventana.restart();
		}else{
			//Aca finaliza el programa
			System.exit(0);	
		}
	    
	}

}
