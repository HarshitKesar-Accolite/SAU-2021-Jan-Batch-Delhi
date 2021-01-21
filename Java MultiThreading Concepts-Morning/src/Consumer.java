
public class Consumer implements Runnable{

	Queue q;
	
	public Consumer(Queue q) {
		this.q = q;
		Thread t = new Thread(this, "Consumer");
		t.start();
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true) {
			q.get();
			try {
				Thread.sleep(5000);
			}
			catch(Exception e){
				e.printStackTrace();
			}
		}
	}
}
