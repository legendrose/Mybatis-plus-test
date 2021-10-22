package com.nj.morethread;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;

/**
 * vector是线程安全的，也不意味着调用它的时候永远都不需要同步手段了
 * 如下例子,get(),remove()d都是安全的，即使它所有的方法都是同步的，也不意味着调用它的时候永远都不需要同步手段了。
 * 以下例子很明显，在多线程环境下，如果不在方法调用的时候做额外的同步措施的话，这段代码依旧不安全。
 * 因为如果另一个线程恰好在错误的时间里删除一个元素，导致序号i不可用，再用i访问数组就会抛出一个ArrayIndexOutOfBoundsexception.
 * 如果保证这段代码能够正确执行下去，我们必须增加同步措施，如添加对象锁（static修饰的对象为类锁）
 *
 *
 */
public class VectorTest {
    private static Vector<Integer> vector = new Vector<>();
//    private static ConcurrentHashMap<String,Integer> vector = new ConcurrentHashMap<>();
    public static void vectorThread(){
        while(true){
            for(int i = 0;i<10;i++){
                vector.add(i);
//                vector.put("a"+i,i);
            }
            Thread removeThread =  new Thread(new Runnable() {
                @Override
                public void run() {
//                    synchronized (vector){
                        for(int i =0;i<vector.size();i++){
                            vector.remove(i);
//                            vector.remove("a"+i);
                        }
//                    }
                }
            });

            Thread printThread = new Thread(new Runnable() {
                @Override
                public void run() {
//                    synchronized (vector){
                        for(int i =0;i<vector.size();i++){
                            System.out.println(vector.get(i));
//                            System.out.println(vector.get("a"+i));
                        }
//                    }

                }
            });
            removeThread.start();
            printThread.start();
            //不要同时产生过多的线程，否则会导致操作系统假死
            while (Thread.activeCount() > 2) {
                Thread.currentThread().getThreadGroup().list();
                Thread.yield();

            }
        }
    }
}
