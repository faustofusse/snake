package Snake;

import java.awt.Color;
import java.awt.GridLayout;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class LayerPrincipal extends JPanel{
	public static Cuadradito[] cuadrados = new Cuadradito[Const.COLUMNAS * Const.FILAS];
	private static ImageIcon negro = new ImageIcon("src/Snake/img/negro.png");
	private static ImageIcon azul = new ImageIcon("src/Snake/img/azul.png");
	private static ImageIcon verde = new ImageIcon("src/Snake/img/verde.png");
	
	public LayerPrincipal(){
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
	
	public static void ponerCosito(){
		
		Random generadorAleatorios = new Random();
			
		int numeroAleatorio = generadorAleatorios.nextInt(Const.COLUMNAS*Const.COLUMNAS);
		for (int i = 0; i< Cuadradito.snake.size(); i++){
			if (numeroAleatorio == Cuadradito.snake.get(i)){
				numeroAleatorio = generadorAleatorios.nextInt(Const.COLUMNAS*Const.COLUMNAS);
			}			
		}
		cuadrados[numeroAleatorio].isCosito = true;
		cuadrados[numeroAleatorio].setIcon(verde);
	}
	
}
