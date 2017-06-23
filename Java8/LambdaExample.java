package Java8;

/**
 * @author SSadasivan
 * @since 6/21/2017.
 */
public class LambdaExample {
	public static void main(String[] args) {
		/*Thread thread = new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println("Inside an other thread using runnable");
			}
		});*/
		
		Thread thread = new Thread(() -> System.out.println("Inside an other thread"));
		thread.start();
		System.out.println("Inside the main Thread");
	}
}
