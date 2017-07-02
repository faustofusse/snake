package Snake;

public class Mover implements Runnable{

	public static boolean mover;
	public static  String dir;
	public static long velocidad = 100;

	@Override
	public void run() {
			while(mover){
				if(LayerPrincipal.cuadrados[Ventana.fijado].isCosito){
					LayerPrincipal.cuadrados[Ventana.fijado].isCosito = false;
					Cuadraditos.snake.add(Ventana.fijado);
					LayerPrincipal.ponerCosito();
					if(velocidad > 30){
						velocidad -= 1;
					}
				}
				
				try {
					Thread.sleep(velocidad);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				Cuadraditos.mover2(dir);
			}
			
		}

}
