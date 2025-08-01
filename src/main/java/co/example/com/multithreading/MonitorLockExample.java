package co.example.com.multithreading;



public class MonitorLockExample {


	public synchronized void task1(){
		try
		{
			System.out.println("Task 1 started by " + Thread.currentThread().getName());
			Thread.sleep(10000); // Simulating work
			System.out.println("Task 1 completed by " + Thread.currentThread().getName());
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
			System.out.println("Task 1 interrupted");
		}
	}


	public void task2(){
		System.out.println("Task 2 started by " + Thread.currentThread().getName());
		synchronized (this){
			System.out.println("Task 2 is waiting for Task 1 to complete by " + Thread.currentThread().getName());
			System.out.println("Inside Synchronized block of Task 2 by " + Thread.currentThread().getName());
		}
	}

	public void task3(){
		System.out.println("Do Nothing Task 3 started by " + Thread.currentThread().getName());
	}

}