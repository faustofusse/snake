package Snake;

import java.awt.GridLayout;
import java.util.Random;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class LayerPrincipal extends JPanel{
	public static Cuadraditos[] cuadrados = new Cuadraditos[Constantes2.COLUMNAS * Constantes2.FILAS];
	private static ImageIcon negro = new ImageIcon("src/Snake/img/negro.png");
	private static ImageIcon azul = new ImageIcon("src/Snake/img/azul.png");
	private static ImageIcon verde = new ImageIcon("src/Snake/img/verde.png");
	
	public LayerPrincipal(){
		setLayout(new GridLayout(Constantes2.COLUMNAS, Constantes2.FILAS));
		for(int i = 0 ; i< Constantes2.COLUMNAS * Constantes2.FILAS; i++){
			cuadrados[i] = new Cuadraditos();
			cuadrados[i].setNumero(i);
			cuadrados[i].setArriba(Cuadraditos.obtenerVecinos(i)[1]);
			cuadrados[i].setAbajo(Cuadraditos.obtenerVecinos(i)[6]);
			cuadrados[i].setDerecha(Cuadraditos.obtenerVecinos(i)[4]);
			cuadrados[i].setIzquierda(Cuadraditos.obtenerVecinos(i)[3]);
			add(cuadrados[i]);
		}
		
		ponerCosito();
		
	}
	
	public static void ponerCosito(){
		
		Random generadorAleatorios = new Random();
			
		int numeroAleatorio = generadorAleatorios.nextInt(Constantes2.COLUMNAS*Constantes2.COLUMNAS);
		for (int i = 0; i< Cuadraditos.snake.size(); i++){
			if (numeroAleatorio == Cuadraditos.snake.get(i)){
				numeroAleatorio = generadorAleatorios.nextInt(Constantes2.COLUMNAS*Constantes2.COLUMNAS);
			}			
		}
		cuadrados[numeroAleatorio].isCosito = true;
		cuadrados[numeroAleatorio].setIcon(verde);
	}
	
}
