package co.example.com.multithreading;



public class MultiThreadingExtendExample extends Thread{

    MultiThreadingExtendExample(){
        this.setName("Super Man Thread-" + this.getId());
        System.out.println("Creating a new thread: " + this.getName());
    }



    @Override
    public void run() {
        System.out.println("Thread is running: " + Thread.currentThread().getName());
        System.out.println("Thread ID: " + Thread.currentThread().getId());
        System.out.println("Thread Priority: " + Thread.currentThread().getPriority());
        System.out.println("Thread State: " + Thread.currentThread().getState());
        System.out.println("Thread is alive: " + Thread.currentThread().isAlive());
        System.out.println("Thread is daemon: " + Thread.currentThread().isDaemon());
        System.out.println("Thread: "+ Thread.currentThread().getName() +" Thread State: " + Thread.currentThread().getState());
        try {
            Thread.currentThread().wait();
        } catch (InterruptedException e) {
            System.out.println("Thread was interrupted: " + e.getMessage());
        }
        System.out.println("Thread is interrupted: " + Thread.currentThread().isInterrupted());
        System.out.println("Thread is a user thread: " + !Thread.currentThread().isDaemon());
        System.out.println("Thread name: " + Thread.currentThread().getName());
        System.out.println("Thread group: " + Thread.currentThread().getThreadGroup());
        System.out.println("Thread: "+ Thread.currentThread().getName() +" Thread State: " + Thread.currentThread().getState());

        System.out.println("Thread context class loader: " + Thread.currentThread().getContextClassLoader());
        System.out.println("Thread uncaught exception handler: " + Thread.currentThread().getUncaughtExceptionHandler());
        System.out.println("Thread: "+ Thread.currentThread().getName() +" Thread State: " + Thread.currentThread().getState());

        System.out.println("Thread stack trace: ");
    }

    public static void main(String[] args) {
        System.out.println("Main thread is running: " + Thread.currentThread().getName());
        MultiThreadingExtendExample thread1 = new MultiThreadingExtendExample();
        MultiThreadingExtendExample thread2 = new MultiThreadingExtendExample();

        thread1.start();
        thread2.start();
        System.out.println("Main thread is finished: " + Thread.currentThread().getName());
    }


}