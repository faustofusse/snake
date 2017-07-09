package Snake;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class LayerPerdiste extends JPanel{
	public static String score; 
	public static Cuadradito[] cuadrados = new Cuadradito[Const.COLUMNAS * Const.FILAS];
	private static ImageIcon negro = new ImageIcon("src/Snake/img/negro.png");
	private static ImageIcon azul = new ImageIcon("src/Snake/img/azul.png");
	private static ImageIcon verde = new ImageIcon("src/Snake/img/verde.png");
	
	public LayerPerdiste(int score){
		setLayout(new GridLayout(Const.COLUMNAS, Const.FILAS));
		setBackground(Color.black); 
		for(int i = 0 ; i< Const.COLUMNAS * Const.FILAS; i++){
			cuadrados[i] = new Cuadradito();
			asignarValores(i);
			add(cuadrados[i]);
		}
		
	}
	
	public static void asignarValores(int i){
		cuadrados[i].setNumero(i);
		cuadrados[i].setArriba(Cuadradito.obtenerVecinos(i)[1]);
		cuadrados[i].setAbajo(Cuadradito.obtenerVecinos(i)[6]);
		cuadrados[i].setDerecha(Cuadradito.obtenerVecinos(i)[4]);
		cuadrados[i].setIzquierda(Cuadradito.obtenerVecinos(i)[3]);
	}
}
