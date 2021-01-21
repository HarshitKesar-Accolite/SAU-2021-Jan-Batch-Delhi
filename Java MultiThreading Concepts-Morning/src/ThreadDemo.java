
public class ThreadDemo {
	public static void main(String args[]) {
		Queue q = new Queue();
		new Producer(q);
		new Consumer(q);
	}
}
