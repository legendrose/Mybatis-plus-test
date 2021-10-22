package com.nj.morethread;

import java.security.Key;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * ConcurrentHashMap 多线程下的并发读写
 */
public class ConcurrentHashMapExample1 {
    private static ExecutorService executor = Executors.newCachedThreadPool();
    private static ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap<String,Integer>();
    public static ConcurrentHashMap getMap(){
        return concurrentHashMap;
    }
    public static void useConcurrentHashMap() {
        System.out.println("===ConcurrentHashMap===");

        /**
         * putIfAbsent是原子操作
         * 如果key对应的值value不存在就put，且返回null；
         * 如果key对应的值value已存在，则返回已存在的值，且value不能为null，否则会报空指针异常。
         */
//        concurrentHashMap.putIfAbsent(UUID.randomUUID(),random.nextInt(50));
        // 模拟并发访问 - 插入不重复的键-值对
        int j =0;
            j++;
            for (int i =0;i<10;i++){
                //写操作
                int finalI = i;
                executor.execute(()->{
//                    UUID key = UUID.randomUUID();
                    Integer value = finalI;
                    String key ="a"+value.toString();
                    System.out.println("Write "+key+":"+value);
                    concurrentHashMap.put(key,value);
                });

            }
        System.out.println("wirte size:"+concurrentHashMap.size());
//        executor.shutdown();
    }
    public static void getConcurrentHashMap() {
        System.out.println("read size before:"+concurrentHashMap.size());
        //读操作
        executor.execute(()->{
            Iterator<Map.Entry<String, Integer>> it= concurrentHashMap.entrySet().iterator();
            while(it.hasNext()){
                Map.Entry<String,Integer> entry = it.next();
                System.out.println("Read"+entry.getValue());
                it.remove();
            }

        });
//        executor.shutdown();
        System.out.println("read size:"+concurrentHashMap.size());
    }
}
