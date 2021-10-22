package com.nj;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Java集合中常见的一种错误机制：fail-fast机制
 * 含义：检测错误
 * 出现这个问题的本质：单线程与多线程的不同
 * 即当多个线程针对于同一个集合中的数据进行操作时，就可能产生fail-fast事件
 *
 */
public class FailFastTest {
    private static List<String> list = new ArrayList<>();
//    private static List<String> list = new CopyOnWriteArrayList<>();
    private static void printAll(){
        Iterator it = list.iterator();
        String value = null;
        while (it.hasNext()){
            value = (String)it.next();
            System.out.println(value);
        }
    }
    private static class ThreadOne extends Thread{
        @Override
        public void run() {
            for(int i =0; i<6;i++){
                list.add("线程1：javahah呵呵"+i);
                printAll();
            }
        }
    }
    private static class ThreadSecond extends Thread{
        @Override
        public void run() {
            for(int i =0; i<2;i++){
                list.add("线程2：一点都不好"+i);
                printAll();
            }
        }
    }

    /**
     * 两个线程对同一个ArrayList操作，均为先加后读取
     * 出现异常，依旧可输出，输出内容均是错的
     * 出现的异常为ConcurrentModificationException，通过异常信息，发现在迭代的时候产生了fail-fast机制
     * 产生的原因：查看源码：发现 modCount != expectedModCount，而expectedModCount=modCount,即expectedModCount是不会修改的，
     * 所以会变的modCount,查看源码，发现在ArrayList的add会先进行检查，修改了modCount。
     * 初步判断：由于expectedModCount 与modCount的改变不同步，导致两者之间不等，从而产生fail-fast机制。
     *
     * 解决方法：
     * 一：在遍历过程中所有涉及到改变modCount值得地方全部加上synchronized或者直接使用Collections.synchronizedList(不推荐)
     * 二：采用CopyOnWriteArrayList来替换ArrayList（CopyOnWriteArrayList是线程安全的）
     * 原因：CopyOnWriteArrayList是一个写时复制的容器。也就是说当我们往容器里添加元素的时候，不直接往当前容器中添加，而是
     * 先将当前容器进行复制，复制出一个新的容器，然后往新容器中添加元素，添加完之后，再将原容器的引用指向新的容器。
     * CopyOnWriteArrayList中add/remove等写方法是需要加锁的，目的是为了避免Copy出N个副本出来，导致并发写。
     * 但是。CopyOnWriteArrayList中的读方法是没有加锁的。
     * @param args
     */
    public static void main(String[] args){
        //两个线程对同一个ArrayList进行操作
        new ThreadOne().start();
        new ThreadSecond().start();

    }
}
