package Snake;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Timer;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class Cuadraditos extends JButton implements ActionListener{
	
	public boolean isCosito = false;
	public int numero;
	public int[] vecinos = obtenerVecinos(this.numero);
	public int vecinoArriba;
	public int vecinoDerecha;
	public int vecinoIzquierda;
	public int vecinoAbajo;
	public static String direccion = "derecha";
	private static Timer timer = new Timer();
	private static boolean mover = false;
	
	public static ArrayList<Integer> snake = new ArrayList<Integer>();
	
	private static ImageIcon negro = new ImageIcon("src/Snake/img/negro.png");
	private static ImageIcon azul = new ImageIcon("src/Snake/img/azul.png");
	private ImageIcon verde = new ImageIcon("src/Snake/img/verde.png");

	
	public Cuadraditos(){
		setIcon(negro);
		addActionListener(this);
	} 
	
	
	public static void mover(String dir){
			
			if (dir == "left"){
				Mover.dir = "left";
			}else if (dir == "up"){
				Mover.dir = "up";
			}else if (dir == "right"){
				Mover.mover = true;
				Mover.dir = "right";
			}else if (dir == "down"){
				Mover.dir = "down";
			}
			
	}
			
	public static void mover2(String dir){
		
			if (dir == "left"){
				//System.out.println("Left");			
				if(LayerPrincipal.cuadrados[Ventana.fijado].getIzquierda() != -1){	
					LayerPrincipal.cuadrados[snake.get(0)].setIcon(negro);
					snake.remove(0);
					snake.add(LayerPrincipal.cuadrados[Ventana.fijado].getIzquierda());
					colorearSnake();
					LayerPrincipal.cuadrados[LayerPrincipal.cuadrados[Ventana.fijado].getIzquierda()].setIcon(azul);
					Ventana.setFijado(LayerPrincipal.cuadrados[Ventana.fijado].getIzquierda());
				}else if (LayerPrincipal.cuadrados[Ventana.fijado].getIzquierda() == -1){
					//System.out.println("PERDISTE!");
				}else if (LayerPrincipal.cuadrados[  LayerPrincipal.cuadrados[Ventana.fijado].getIzquierda()  ].isCosito){
					System.out.println("COSITO!");
					LayerPrincipal.ponerCosito();
					//snake.add(0, );
				}
			}else if (dir == "up"){
				//System.out.println("Up");
				if(LayerPrincipal.cuadrados[Ventana.fijado].getArriba() != -1){	
					LayerPrincipal.cuadrados[snake.get(0)].setIcon(negro);
					snake.remove(0);
					snake.add(LayerPrincipal.cuadrados[Ventana.fijado].getArriba());
					colorearSnake();
					LayerPrincipal.cuadrados[LayerPrincipal.cuadrados[Ventana.fijado].getArriba()].setIcon(azul);
					Ventana.setFijado(LayerPrincipal.cuadrados[Ventana.fijado].getArriba());
				}else if (LayerPrincipal.cuadrados[Ventana.fijado].getArriba() == -1){
					//System.out.println("PERDISTE!");
				}else if (LayerPrincipal.cuadrados[LayerPrincipal.cuadrados[Ventana.fijado].getArriba()].isCosito){
					System.out.println("COSITO!");
					LayerPrincipal.ponerCosito();
					//snake.add(0, );
				}
			}else if (dir == Constantes2.RIGHT){
				//System.out.println("Right");
				if(LayerPrincipal.cuadrados[Ventana.fijado].getDerecha() != -1){
				
					LayerPrincipal.cuadrados[snake.get(0)].setIcon(negro);
					snake.remove(0);
					snake.add(LayerPrincipal.cuadrados[Ventana.fijado].getDerecha());
					colorearSnake();
					LayerPrincipal.cuadrados[LayerPrincipal.cuadrados[Ventana.fijado].getDerecha()].setIcon(azul);
					Ventana.setFijado(LayerPrincipal.cuadrados[Ventana.fijado].getDerecha());
					
				}else if (LayerPrincipal.cuadrados[Ventana.fijado].getDerecha() == -1){
					//System.out.println("PERDISTE!");
				}else if (LayerPrincipal.cuadrados[LayerPrincipal.cuadrados[Ventana.fijado].getDerecha()].isCosito){
					System.out.println("COSITO!");
					LayerPrincipal.ponerCosito();
					//snake.add(0, );
				}
			}else if (dir == "down"){
				//System.out.println("Down");
				if(LayerPrincipal.cuadrados[Ventana.fijado].getAbajo() != -1){	
					LayerPrincipal.cuadrados[snake.get(0)].setIcon(negro);
					snake.remove(0);
					snake.add(LayerPrincipal.cuadrados[Ventana.fijado].getAbajo());
					colorearSnake();
					LayerPrincipal.cuadrados[LayerPrincipal.cuadrados[Ventana.fijado].getAbajo()].setIcon(azul);
					Ventana.setFijado(LayerPrincipal.cuadrados[Ventana.fijado].getAbajo());
				}else if (LayerPrincipal.cuadrados[Ventana.fijado].getAbajo() == -1){
					//System.out.println("PERDISTE!");
				}else if (LayerPrincipal.cuadrados[LayerPrincipal.cuadrados[Ventana.fijado].getAbajo()].isCosito){
					System.out.println("COSITO!");
					LayerPrincipal.ponerCosito();
				}
			}
	}
	
	public static void colorearSnake(){
		for (int i =0;i<Cuadraditos.snake.size(); i++){
			LayerPrincipal.cuadrados[Cuadraditos.snake.get(i)].setIcon(azul);
		}
	}
	
	
	public static int[] obtenerVecinos(int origen){
		int[] vecinos = new int[8];

		if (origen == 0){
			//ESQ IZQ SUP
			vecinos = llenarArray(-1,-1,-1,-1,1,-1,Constantes2.FILAS,Constantes2.FILAS+1);			
		} else if (origen == Constantes2.FILAS -1){
			//ESQ DER SUP
			vecinos = llenarArray(-1,-1,-1, Constantes2.FILAS -2, -1 , Constantes2.FILAS * 2 - 2, Constantes2.FILAS * 2 - 1 , -1);			
		} else if (origen == Constantes2.FILAS * Constantes2.COLUMNAS - Constantes2.FILAS){
			//ESQ IZQ INF
			vecinos = llenarArray(-1,Constantes2.FILAS * Constantes2.COLUMNAS - (2 * Constantes2.FILAS) , Constantes2.FILAS * Constantes2.COLUMNAS - 2 * Constantes2.FILAS + 1,-1, Constantes2.FILAS * Constantes2.COLUMNAS - Constantes2.FILAS+1, -1,-1,-1);
		} else if (origen == Constantes2.FILAS * Constantes2.COLUMNAS-1){
			//ESQ DER INF
			vecinos = llenarArray(Constantes2.FILAS * (Constantes2.COLUMNAS -1)-2, Constantes2.FILAS * (Constantes2.COLUMNAS -1)-1, -1, Constantes2.FILAS * Constantes2.COLUMNAS -2, -1, -1, -1, -1);
		}else if (origen % Constantes2.FILAS == 0){
			//Borde Izq
			vecinos = llenarArray(-1, origen - Constantes2.FILAS,origen - Constantes2.FILAS + 1 , -1, origen + 1, -1, origen + Constantes2.FILAS, origen + Constantes2.FILAS + 1);
		}else if ((origen + 1) % Constantes2.FILAS == 0){
			//Borde der
			vecinos = llenarArray(origen - Constantes2.FILAS -1, origen - Constantes2.FILAS, -1, origen -1, -1, origen + Constantes2.FILAS -1, origen + Constantes2.FILAS, -1);
		}else if (origen < Constantes2.FILAS ){
			//Arriba
			vecinos = llenarArray(-1, -1, -1, origen -1, origen + 1, origen + Constantes2.FILAS -1, origen + Constantes2.FILAS , origen + Constantes2.FILAS + 1);
		}else if (origen > Constantes2.FILAS * Constantes2.COLUMNAS - Constantes2.FILAS){
			//Abajo
			vecinos = llenarArray(origen - Constantes2.FILAS -1, origen - Constantes2.FILAS , origen - Constantes2.FILAS +1, origen -1, origen +1, -1, -1, -1);
		}else{
			vecinos = llenarArray(origen - Constantes2.FILAS -1, origen - Constantes2.FILAS, origen - Constantes2.FILAS +1, origen -1, origen + 1, origen + Constantes2.FILAS -1, origen + Constantes2.FILAS, origen + Constantes2.FILAS + 1);
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
	
	public int getNumero(){
		return this.numero;
	}
	
	public int getArriba(){
		return this.vecinoArriba;
	}
	public int getAbajo(){
		return this.vecinoAbajo;
	}
	public int getDerecha(){
		return this.vecinoDerecha;
	}
	public int getIzquierda(){
		return this.vecinoIzquierda;
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


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		
	}
}
