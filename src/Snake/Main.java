package Snake;

public class Main{

	public static Mover mov;
	public static boolean pausa = true;
	public static boolean iniciado = false;
	public static int score = 0;
	public static boolean perdio = false;
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Ventana ventana1 = new Ventana();
		ventana1.setVisible(true);

		System.out.println("Press enter to start");
		
		mov = new Mover();
		mov.mover = true;
		mov.direccion = Const.RIGHT;
		mov.run();
	}
}
