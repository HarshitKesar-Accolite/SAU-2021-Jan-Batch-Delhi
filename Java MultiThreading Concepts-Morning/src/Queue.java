
public class Queue {
	int num;
	boolean isValueSet = false;
	public synchronized void put(int num) {
		while(isValueSet) {
			try {
				wait();
			} 
			catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		this.num = num;
		System.out.println("Put : " + num);
		isValueSet = true;
		notify();
	}
	public synchronized void get() {
		while(!isValueSet) {
			try {
				wait();
			} 
			catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("Get : " + num);
		isValueSet = false;
		notify();
	}
}
