package com.nj;

import javax.management.Notification;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.*;

/**
 * Java中实现线程有那几种方式？区别是什么？（三种或者四种，根据继承和接口特点区别）
 * 实现Runnable接口会更好一点，因为Java不支持多重继承，因此继承了thread类，就无法继承其他类了，但可以实现多个接口
 * 类可能只要求此执行就行，继承整个thread类开销过大
 */
public class ThreadMethod{
    private static Object lock = new Object();

    //实现Runnable接口
    private static class ThreadMethod2 implements Runnable{
        @Override
        public void run() {

        }
    }
    //继承thread
    private static class ThreadMethod1 extends Thread{
        @Override
        public void run() {
            super.run();
        }
    }
    //实现callable接口,可返回
    private static class ThreadMethod3 implements Callable<Integer> {

        @Override
        public Integer call() throws Exception {
            return 123;
        }
    }

    /**
     * 当调用start()启动一个线程时，虚拟机会将该线程放入就绪队列中等待被调度，当一个线程被调度时会执行该线程的run（）
     * @param args
     * @throws ExecutionException
     * @throws InterruptedException
     * 问题1 Thread类中的start和run方法的区别？（start方法内部含有native的start0，官方文档解释start0内部调用了run方法）
     * 区别：start()会启动一个新的线程，将线程放入线程组中，利用本地方法start0()启动run()（待其获得CPU资源时会执行run()方法，start()不能被重复调用。）
     * run()只是一个普通的方法，不会启动新线程。只有等到该方法执行完毕，其它线程才能获得CPU资源
     * 问题2 ：sleep和wait的区别
     * wait()属于object中的方法,可以释放锁，并且会加入到等待队列中。sleep属于thread中的方法,不释放锁
     * wait()会依赖同步器synchronized,sleep()不依赖它
     *wait()需要唤醒（不指定时间需要别人中断，中断方法为notifyAll(),notify()）.sleep不需要唤醒（休眠之后退出阻塞）
     *
     * //线程池
     * https://segmentfault.com/a/1190000022491488
     */
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ThreadMethod2 th2 = new ThreadMethod2();
        Thread t2 = new Thread(th2);
        t2.start();
        lock.notifyAll();
        new ThreadMethod1().start();
        ThreadMethod3 th3 = new ThreadMethod3();
        FutureTask<Integer> fc = new FutureTask<>(th3);
        Thread t3= new Thread(fc);
        t3.start();
        System.out.println(fc.get());
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(()->{

        });
        executorService.shutdown();
    }
}
