package com.nj.designpatterntest;

import com.nj.copy.Car;
import com.nj.copy.Student;
import com.nj.copy.deepCloneObject;
import com.nj.designpatterntest.factory.ICommodityAdapter;
import com.nj.designpatterntest.factory.JDKProxy;
import com.nj.designpatterntest.store.CardCommodityService;
import com.nj.designpatterntest.store.ICommodity;
import com.nj.morethread.ConcurrentHashMapExample1;
import com.nj.morethread.VectorTest;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.LineIterator;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

@SpringBootTest
class DesignpatterntestApplicationTests {

    /**
     * 工厂方法模式测试
     * 总结：从上到下的优化来看，⼯工⼚厂⽅方法模式并不不复杂，甚⾄至这样的开发结构在你有所理理解后，会发现更加简单。
     * 那么这样的开发的好处知道后，也可以总结出来它的优缺点；
     * 优点：避免创建者与具体的产品逻辑耦合 、满足单一职责，每一个业务逻辑实现都在所属⾃自⼰己的类中完成 、
     *      满⾜足开闭原则，⽆无需更更改使⽤用调⽤用⽅方就可以在程序中引⼊入新的产品类型 。
     *
     * 缺点：但这样也会带来一些问题，比如有⾮非常多的奖品类型，那么实现的⼦
     *         类会极速扩张。因此也需要使⽤用其他的模式进⾏行行优化，这些在后续的设计模式中会逐步涉及到。
     * @throws Exception
     */
//    @Test
    void test_commodity() throws Exception {
        StoreFactory storeFactory = new StoreFactory();
        // 1. 优惠券
        ICommodity commodityService_1 = storeFactory.getICommodityService(1);
        commodityService_1.sendCommodity("10001", "EGM1023938910232121323432", "791098764902132", null);
        // 2. 实物商品
        ICommodity commodityService_2 = storeFactory.getICommodityService(2);
        Map<String,String> extMap = new HashMap<String,String>();
        extMap.put("consigneeUserName", "谢⻜飞机");
        extMap.put("consigneeUserPhone", "15200292123");
        extMap.put("consigneeUserAddress", "吉林林省.⻓长春市.双阳区.XX街道.檀溪苑⼩小 区.#18-2109");
        commodityService_2.sendCommodity("10001","9820198721311","102300002011222 1113", extMap);

        // 3. 第三⽅方兑换卡(爱奇艺)
        ICommodity commodityService_3 = storeFactory.getICommodityService(3);
        commodityService_3.sendCommodity("10001","AQY1xjkUodl8LO975GdfrYUio",null,null);
    }

    /**
     * 抽象方法
     * @throws Exception
     */
//    @Test
    void test_factory_proxy() throws Exception {
        JDKProxy.getProxy(Object.class, (ICommodityAdapter) new CardCommodityService());
    }

    /**
     * 模拟ConcurrentHashMap并发读取操作
     * @throws Exception
     */
    @Test
    void concurrentHashMap_morethread(){
        int j = 0;
        ConcurrentHashMapExample1.useConcurrentHashMap();
        System.out.println("map before:"+ConcurrentHashMapExample1.getMap().size());
        while(j < 2){
            ConcurrentHashMapExample1.useConcurrentHashMap();
            ConcurrentHashMapExample1.getConcurrentHashMap();
            j++;
        }
        System.out.println("map:"+ConcurrentHashMapExample1.getMap().size());

    }

    /**
     * 对于对象中存在引用类型对象的bean,进行copy
     * 针对于object的clone(),对于引用类型来说，只是浅拷贝，如果要想深拷贝
     * 方法之一：对象都要需要实现序列化，然后新增一个深拷贝的方法
     * 方法二：对象以及引用对象都要实现Cloneable,实现clone(),此方法有个问题，如果引用对象是嵌套，就比较麻烦
     * 因此最好采用方法1
     * @throws CloneNotSupportedException
     * stu===>Student(id=1234, name=student1, car=Car(xh=四圈, price=12w))
     * 原对象stu改变之后的stu===>Student(id=qwerr, name=student1, car=Car(xh=宝马, price=12w))
     * 原对象stu改变之后的stu2不变化===>Student(id=1234, name=student1, car=Car(xh=四圈, price=12w))
     */
    @Test
    void testCopy() throws CloneNotSupportedException {
        Student stu = new Student("1234","student1",new Car("四圈","12w"));
        System.out.println("stu===>"+stu.toString());
//        Student stu2 = (Student)stu.clone();
        Student stu2 = deepCloneObject.deepCloneObject(stu);
        stu.setId("qwerr");
        stu.getCar().setXh("宝马");
        System.out.println("原对象stu改变之后的stu===>"+stu.toString());
        System.out.println("原对象stu改变之后的stu2 copy===>"+stu2.toString());
    }

    @Test
    void testFAN() throws CloneNotSupportedException {
//        JDKProxy.method([1,2,3,5]);
        /**
         * 包装类的“==”运算在不遇到算术运算的前提下是不会自动拆箱，以及他们的equals()不处理数据转型的关系
         */
        Integer a = 1;
        Integer b = 2;
        Integer c = 3;
        Integer d = 3;
        Integer e = 321;
        Integer f = 321;
        Long g = 3L;
        System.out.println(c == d);//true
        System.out.println(e == f);//false
        System.out.println(c == (a+b));//true
        System.out.println(c.equals(a+b));//true
        System.out.println(g == (a+b));//true
        System.out.println(g.equals(a+b));//false

        if(1==1){
            System.out.println("11111");
        }else{
            System.out.println("safdasf");
        }
    }

    @Test
    void threadVector(){
        VectorTest.vectorThread();
        Thread.yield();//
        Thread.currentThread();//当前正在执行的线程的引用
        new java.lang.Thread(()->{
            System.out.println("线程匿名内部类");
        }).start();//start--开始执行线程方法，虚拟机调用线程内的run（）
    }

    /**
     * 方式3：文件流读取文件
     */
    @Test
    void testFileInputStream() throws IOException {

        FileInputStream inputStream = null;
        Scanner sc = null;
        try {
            String path = "C:\\Users\\Administrator\\Desktop\\study-pdf\\ELK.zip";
            inputStream = new FileInputStream(path);
            sc = new Scanner(inputStream, "UTF-8");
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
//                System.out.println(line);
            }
            if (sc.ioException() != null) {
                throw sc.ioException();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (inputStream != null) {
                inputStream.close();
            }
            if (sc != null) {
                sc.close();
            }
        }
    }

    /**
     * 方式4 Apache Commons IO流
     * 如果我们想要读取一个大文件，选择了错误的方式，就有可能极大地占用我的内存和CPU，当文件特别大时，会造成意向不到的问题。
     * 因此为了去解决这样的问题，有四种常见的读取大文件的方式。
     * 通过分析对比，发现，Apache Commons IO流是最高效的一种方式。
     * 方式1：Guava读取
     * 方式2：Apache Commons IO普通方式：FileUtils.readLines(new File(path), Charsets.UTF_8);
     * @throws IOException
     */
    @Test
    void commonsIO() throws IOException {
        String path = "C:\\Users\\Administrator\\Desktop\\study-pdf\\ELK.zip";
        LineIterator it = FileUtils.lineIterator(new File(path), "UTF-8");
        try {
            while (it.hasNext()) {
                String line = it.nextLine();
            }
        } finally {
            LineIterator.closeQuietly(it);
        }
    }

    @Test
    void tt() {
        //加载bean入口
        ApplicationContext ac = new ClassPathXmlApplicationContext("spring.xml");
//        ac.getBean(XXX.class);
//        ClassPathXmlApplicationContext;
    }

}
