package co.example.com.multithreading;



public class Main {

    public static void main(String[] args) {

        System.out.println("Going inside Main Method");
        MultiThreadLearning runnableObj = new MultiThreadLearning();
        Thread thread1 = new Thread(runnableObj, "Thread-1");
        thread1.start();




        MonitorLockExample monitorLockExample = new MonitorLockExample();
        Thread t1= new Thread(()->{ monitorLockExample.task1();});
        Thread t2= new Thread(()->{ monitorLockExample.task2();});
        Thread t3= new Thread(()->{ monitorLockExample.task3();});

        t1.start();
        t2.start();
        t3.start();

        System.out.println("Going out Main Method : "+Thread.currentThread().getName());

    }


}