import java.awt.EventQueue;

public class marketPlaceMain {

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				new marketPlaceGui().start();
			}
		});
	}

}
