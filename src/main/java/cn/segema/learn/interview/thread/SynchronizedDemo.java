package cn.segema.learn.interview.thread;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.PropertyConfigurator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @description synzhronized关键字
 * @author wangyong
 * @createDate 2020/05/11
 */
public class SynchronizedDemo {

    private static Logger logger = LoggerFactory.getLogger(SynchronizedDemo.class);
    
    public static void initLog() {
        FileInputStream fileInputStream = null;
        try {
            Properties properties = new Properties();
            fileInputStream = new FileInputStream("src/main/resources/log4j.properties");
            properties.load(fileInputStream);
            PropertyConfigurator.configure(properties);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    
    public Integer lockObject;
    
    public SynchronizedDemo(Integer lockObject) {
        this.lockObject = lockObject;
    }
    
    public SynchronizedDemo() {
    }

    
    // 修饰普通方法,锁住了本类的实例对象
    // 同一个实例调用会阻塞,不同实例调用不会阻塞
    public synchronized void test1() {
        try {
            logger.info(Thread.currentThread().getName() + " test1 进入了同步方法");
            Thread.sleep(5000);
            logger.info(Thread.currentThread().getName() + " test1 休眠结束");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    
    // 同步代码块传参this,锁住了本类的实例对象
    // 同一个实例调用会阻塞,不同实例调用不会阻塞
    public void test2() {
        synchronized (this) {
            try {
                logger.info(Thread.currentThread().getName() + " test2 进入了同步块");
                Thread.sleep(5000);
                logger.info(Thread.currentThread().getName() + " test2 休眠结束");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    
    // 同步代码块传参变量对象,锁住了实例中的成员变量
    // 同一个属性对象才会实现同步
    public void test3() {
        synchronized (lockObject) {
            try {
                logger.info(Thread.currentThread().getName() + " test3 进入了同步块");
                Thread.sleep(5000);
                logger.info(Thread.currentThread().getName() + " test3 休眠结束");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    
    //全局锁，类是全局唯一的
    public void test4() {
        synchronized (SynchronizedDemo.class) {
            try {
                logger.info(Thread.currentThread().getName() + " test4 进入了同步块");
                Thread.sleep(5000);
                logger.info(Thread.currentThread().getName() + " test4 休眠结束");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


    // 修饰静态方法,全局锁
    // 所有调用该方法的线程都会实现同步
     public synchronized static void test5() {
         try {
             logger.info(Thread.currentThread().getName() + " test5 进入同步方法");
             Thread.sleep(5000);
             logger.info(Thread.currentThread().getName() + " test5 休眠结束");
         } catch (InterruptedException e) {
             e.printStackTrace();
         }
     }


    public static void main(String[] args) {
        initLog();
        
//        SynchronizedDemo st1 = new SynchronizedDemo();
//        SynchronizedDemo st2 = new SynchronizedDemo();
//        new Thread(() -> {
//            logger.info(Thread.currentThread().getName() + " test 准备进入");
//            st1.test1();
//        }).start();
//        new Thread(() -> {
//            logger.info(Thread.currentThread().getName() + " test 准备进入");
//            st2.test1();
//        }).start();

        
//        SynchronizedDemo st1 = new SynchronizedDemo();
//        SynchronizedDemo st2 = new SynchronizedDemo();
//        new Thread(() -> {
//            logger.info(Thread.currentThread().getName() + " test 准备进入");
//            st1.test2();
//        }).start();
//        new Thread(() -> {
//            logger.info(Thread.currentThread().getName() + " test 准备进入");
//            st2.test2();
//        }).start();
        
        
        SynchronizedDemo st1 = new SynchronizedDemo(127);
        SynchronizedDemo st2 = new SynchronizedDemo(127);
        new Thread(() -> {
            logger.info(Thread.currentThread().getName() + " test 准备进入");
            st1.test3();
        }).start();
        new Thread(() -> {
            logger.info(Thread.currentThread().getName() + " test 准备进入");
            st2.test3();
        }).start();
        
        
//        SynchronizedDemo st = new SynchronizedDemo();
//        SynchronizedDemo st2 = new SynchronizedDemo();
//        new Thread(() -> {
//            logger.info(Thread.currentThread().getName() + " test 准备进入");
//            st.test4();
//        }).start();
//        new Thread(() -> {
//            logger.info(Thread.currentThread().getName() + " test 准备进入");
//            st2.test4();
//        }).start();

        
//        SynchronizedDemo st = new SynchronizedDemo();
//        SynchronizedDemo st2 = new SynchronizedDemo();
//        new Thread(() -> {
//            logger.info(Thread.currentThread().getName() + " test 准备进入");
//            st.test5();
//        }).start();
//        new Thread(() -> {
//            logger.info(Thread.currentThread().getName() + " test 准备进入");
//            st2.test5();
//        }).start();
//        new Thread(() -> {
//            logger.info(Thread.currentThread().getName() + " test 准备进入");
//            SynchronizedDemo.test5();
//        }).start();

    }

}
