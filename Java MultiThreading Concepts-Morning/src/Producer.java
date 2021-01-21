
public class Producer implements Runnable{

	Queue q;
	
	public Producer(Queue q) {
		this.q = q;
		Thread t = new Thread(this, "Producer");
		t.start();
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		int i = 0;
		while(true) {
			q.put(i++); 
			try {
				Thread.sleep(500);
			}
			catch(Exception e){
				e.printStackTrace();
			}
		}
	}

}
