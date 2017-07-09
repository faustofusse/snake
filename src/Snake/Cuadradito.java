package Snake;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Timer;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Cuadradito extends JButton{
	
	public static int posicion = Const.COLUMNAS +1;
	
	public boolean isCosito = false;
	public int numero;
	public int[] vecinos = obtenerVecinos(this.numero);
	public int vecinoArriba;
	public int vecinoDerecha;
	public int vecinoIzquierda;
	public int vecinoAbajo;
	public static String direccion = "derecha";
	
	public static ArrayList<Integer> snake = new ArrayList<Integer>();
	
	private static ImageIcon negro = new ImageIcon("src/Snake/img/negro.png");
	private static ImageIcon azul = new ImageIcon("src/Snake/img/azul.png");
	private static ImageIcon verde = new ImageIcon("src/Snake/img/verde.png");

	private static ImageIcon[] imgGameover = {new ImageIcon("src/Snake/img/g#.png"),
			new ImageIcon("src/Snake/img/a#.png"),
			new ImageIcon("src/Snake/img/m#.png"),
			new ImageIcon("src/Snake/img/e#.png"),
			new ImageIcon("src/Snake/img/o#.png"),
			new ImageIcon("src/Snake/img/v#.png"),
			new ImageIcon("src/Snake/img/e#.png"),
			new ImageIcon("src/Snake/img/r#.png")};	
	
	private static ImageIcon[] imgScore = {new ImageIcon("src/Snake/img/s2.png"),
			new ImageIcon("src/Snake/img/c.png"),
			new ImageIcon("src/Snake/img/o.png"),
			new ImageIcon("src/Snake/img/r.png"),
			new ImageIcon("src/Snake/img/e.png"),
			new ImageIcon("src/Snake/img/dosp.png")};
	
	private static ImageIcon[] imgEnter = {new ImageIcon("src/Snake/img/p.png"),
			new ImageIcon("src/Snake/img/r.png"),
			new ImageIcon("src/Snake/img/e.png"),
			new ImageIcon("src/Snake/img/s.png"),
			new ImageIcon("src/Snake/img/s.png"),
			new ImageIcon("src/Snake/img/e.png"),
			new ImageIcon("src/Snake/img/n.png"),
			new ImageIcon("src/Snake/img/t.png"),
			new ImageIcon("src/Snake/img/e.png"),
			new ImageIcon("src/Snake/img/r.png")};
	
	public Cuadradito(){
		setIcon(negro);
		setBorderPainted(false);
	} 
	
		
	public static void colorearSnake(){
		for (int i =0;i<Cuadradito.snake.size(); i++){
			LayerPrincipal.cuadrados[Cuadradito.snake.get(i)].setIcon(azul);
		}
	}	
	
	public static int[] obtenerVecinos(int origen){
		int[] vecinos = new int[8];

		if (origen == 0){
			//ESQ IZQ SUP
			vecinos = llenarArray(-1,-1,-1,-1,1,-1,Const.FILAS,Const.FILAS+1);			
		} else if (origen == Const.FILAS -1){
			//ESQ DER SUP
			vecinos = llenarArray(-1,-1,-1, Const.FILAS -2, -1 , Const.FILAS * 2 - 2, Const.FILAS * 2 - 1 , -1);			
		} else if (origen == Const.FILAS * Const.COLUMNAS - Const.FILAS){
			//ESQ IZQ INF
			vecinos = llenarArray(-1,Const.FILAS * Const.COLUMNAS - (2 * Const.FILAS) , Const.FILAS * Const.COLUMNAS - 2 * Const.FILAS + 1,-1, Const.FILAS * Const.COLUMNAS - Const.FILAS+1, -1,-1,-1);
		} else if (origen == Const.FILAS * Const.COLUMNAS-1){
			//ESQ DER INF
			vecinos = llenarArray(Const.FILAS * (Const.COLUMNAS -1)-2, Const.FILAS * (Const.COLUMNAS -1)-1, -1, Const.FILAS * Const.COLUMNAS -2, -1, -1, -1, -1);
		}else if (origen % Const.FILAS == 0){
			//Borde Izq
			vecinos = llenarArray(-1, origen - Const.FILAS,origen - Const.FILAS + 1 , -1, origen + 1, -1, origen + Const.FILAS, origen + Const.FILAS + 1);
		}else if ((origen + 1) % Const.FILAS == 0){
			//Borde der
			vecinos = llenarArray(origen - Const.FILAS -1, origen - Const.FILAS, -1, origen -1, -1, origen + Const.FILAS -1, origen + Const.FILAS, -1);
		}else if (origen < Const.FILAS ){
			//Arriba
			vecinos = llenarArray(-1, -1, -1, origen -1, origen + 1, origen + Const.FILAS -1, origen + Const.FILAS , origen + Const.FILAS + 1);
		}else if (origen > Const.FILAS * Const.COLUMNAS - Const.FILAS){
			//Abajo
			vecinos = llenarArray(origen - Const.FILAS -1, origen - Const.FILAS , origen - Const.FILAS +1, origen -1, origen +1, -1, -1, -1);
		}else{
			vecinos = llenarArray(origen - Const.FILAS -1, origen - Const.FILAS, origen - Const.FILAS +1, origen -1, origen + 1, origen + Const.FILAS -1, origen + Const.FILAS, origen + Const.FILAS + 1);
		}
		
		return vecinos;
	}
	
	public static int[] llenarArray(int a, int b, int c, int d, int e, int f, int g, int h){
		int[] arreglo = new int[8];

		arreglo[0] = a;
		arreglo[1] = b;
		arreglo[2] = c;
		arreglo[3] = d;
		arreglo[4] = e;
		arreglo[5] = f;
		arreglo[6] = g;
		arreglo[7] = h;


		return arreglo;
	}
	
	public void setNumero(int n){
		this.numero = n;
	}
	
	public void setArriba(int num){
		this.vecinoArriba = num;
	}
	public void setAbajo(int num){
		this.vecinoAbajo = num;
	}
	public void setDerecha(int num){
		this.vecinoDerecha = num;
	}
	public void setIzquierda(int num){
		this.vecinoIzquierda = num;
	}

	public int getVecino(int vecino){
		int sale = 0;
		switch(vecino){
			case Const.RIGHT:  
				sale = this.vecinoDerecha;
				break;
			case Const.LEFT:  
				sale = this.vecinoIzquierda;
				break;
			case Const.UP:  
			sale = this.vecinoArriba;
			break;
			case Const.DOWN:  
				sale = this.vecinoAbajo;
				break;
		}
		return sale;
	}


	public static void movimiento(int vecino){
		if (formaParte(LayerPrincipal.cuadrados[posicion].getVecino(vecino))){
			
			if(!Main.perdio){
				gameover();
			}
			
		}else if(LayerPrincipal.cuadrados[posicion].getVecino(vecino) != -1){
			
			LayerPrincipal.cuadrados[snake.get(0)].setIcon(negro);
			if (snake.size() > Const.TAMANIO_INICIAL){
				snake.remove(0);
			}
			snake.add(LayerPrincipal.cuadrados[posicion].getVecino(vecino));
			colorearSnake();
			LayerPrincipal.cuadrados[LayerPrincipal.cuadrados[posicion].getVecino(vecino)].setIcon(azul);
			setPosicion(LayerPrincipal.cuadrados[posicion].getVecino(vecino));		
			
		}else if (LayerPrincipal.cuadrados[posicion].getVecino(vecino) == -1){
			
			if(!Main.perdio){
				gameover(); 
			}
			
		}else if (LayerPrincipal.cuadrados[LayerPrincipal.cuadrados[posicion].getVecino(vecino)].isCosito){
			System.out.println("COSITO!");
			LayerPrincipal.ponerCosito();
			//snake.add(0, );
		}
	}
	
	public static void gameover(){
		
		System.out.println("GAME OVER" + " - " + "Score: " + Main.score);
		System.out.println("Press enter to restart");
		Main.perdio = true;
		Main.pausa = true;
		//Agrego mensaje de perdio
		//Ventana.mensajePerdio();	
		paintGameover();
		
	}
	
	public static void paintGameover(){
		
		int pos;
		int b;
		Ventana.pintarTodos();
		snake.add(Cuadradito.posicion);
		Mover.direccion = Const.RIGHT;
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//GAME OVER
		pos =7*Const.FILAS+4;		
		for(int i = 0; i<4; i++){
			LayerPrincipal.cuadrados[pos].setIcon(imgGameover[i]);
			pos++;
		}
		pos++;
		for(int i = 4; i<8; i++){
			LayerPrincipal.cuadrados[pos].setIcon(imgGameover[i]);
			pos++;
		}
		
		//SCORE: 
		pos =9*Const.FILAS+4;
		for(int i = 0; i<6; i++){
			LayerPrincipal.cuadrados[pos].setIcon(imgScore[i]);
			pos++;
		}
		
		
		//PRESS ENTER
		pos =11*Const.FILAS+4;
		for(int i = 0; i<5; i++){
			LayerPrincipal.cuadrados[pos].setIcon(imgEnter[i]);
			pos++;
		}
		pos++;
		for(int i = 5; i<10; i++){
			LayerPrincipal.cuadrados[pos].setIcon(imgEnter[i]);
			pos++;
		}
		
		
	}
	
	public static boolean formaParte(int pos){
		for(int i =0; i<snake.size();i++){
			if (snake.get(i) == pos){
				return true;
			}
		}
		return false;
	}
	
	public static void setPosicion(int num){
		posicion = num;
	}
}
