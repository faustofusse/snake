package Snake;

public class Mover implements Runnable{

	public static boolean mover;
	public static  int direccion;
	public static long velocidad = Const.VELOCIDAD;

	@Override
	public void run() {
		while(mover){
			if(!Main.pausa){
				if(LayerPrincipal.cuadrados[Cuadradito.posicion].isCosito){
					LayerPrincipal.cuadrados[Cuadradito.posicion].isCosito = false;
					Cuadradito.snake.add(Cuadradito.posicion);
					LayerPrincipal.ponerCosito();
					Main.score++;
					if(velocidad > 30){
						velocidad -= 1;
					}
				}

				try {
					Thread.sleep(velocidad);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
				Cuadradito.movimiento(direccion);
				
				
			}else{
				try {
					Thread.sleep(10);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}

	}



}
