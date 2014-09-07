import java.util.Random; 
class Philosopher extends Thread { 
	private Chopstick left, right; 
	private Random random; 

	public Philosopher(Chopstick left, Chopstick right) {
		this.left = left; 
		this.right = right; 
		random = new Random(); 
	}

	public void run() {
		try{
			while(true){
				Thread.sleep(random.nextInt(10));
				synchronized(left) {
					synchronized(right){
						Thread.sleep(random.nextInt(10));
						System.out.println(left.getId() + " " + right.getId()); 
					}
				}
			}
		}catch(InterruptedException e){}
	}

}

class Chopstick{
	private int id; 
	public Chopstick(int id){
		this.id = id; 
	}

	public int getId() {
		return this.id; 
	}
}

public class PhilosopherExample {
	public static void main(String[] args){
		Philosopher t1, t2; 

		t1 = new Philosopher(new Chopstick(12), new Chopstick(15)); 
		t2 = new Philosopher(new Chopstick(15), new Chopstick(12)); 
		t1.start(); 
		t2.start(); 
		t1.join(); t2.join(); 
	}

} 