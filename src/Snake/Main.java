package Snake;

public class Main{

	public static Mover mov;
	public static boolean pausa = false;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Ventana ventana1 = new Ventana();
		ventana1.setVisible(true);
		
		mov = new Mover();
		mov.mover = true;
		mov.direccion = Const.RIGHT;
		mov.run();
	}

}
