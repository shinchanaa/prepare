package co.example.com.multithreading;


public class MultiThreadLearning implements Runnable{


	@Override
	public void run() {
		System.out.println("Thread is running: " + Thread.currentThread().getName());
		System.out.println("Thread ID: " + Thread.currentThread().getId());
		System.out.println("Thread Priority: " + Thread.currentThread().getPriority());
		System.out.println("Thread State: " + Thread.currentThread().getState());
		System.out.println("Thread is alive: " + Thread.currentThread().isAlive());
		System.out.println("Thread is daemon: " + Thread.currentThread().isDaemon());
		System.out.println("Thread is interrupted: " + Thread.currentThread().isInterrupted());
		System.out.println("Thread is a user thread: " + !Thread.currentThread().isDaemon());
		System.out.println("Thread name: " + Thread.currentThread().getName());
		System.out.println("Thread group: " + Thread.currentThread().getThreadGroup());
		System.out.println("Thread context class loader: " + Thread.currentThread().getContextClassLoader());
		System.out.println("Thread uncaught exception handler: " + Thread.currentThread().getUncaughtExceptionHandler());
		System.out.println("Thread stack trace: ");


	}
}