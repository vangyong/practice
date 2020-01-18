package cn.segema.learn.interview.thread;

public class ThreadWaitNotifyDemo {
	private int start = 1;

    private boolean flag = false;

    public static void main(String[] args) {
    	
        ThreadWaitNotifyDemo twoThread = new ThreadWaitNotifyDemo();

        Thread t1 = new Thread(new OuNum(twoThread));
        t1.setName("A");


        Thread t2 = new Thread(new JiNum(twoThread));
        t2.setName("B");

        t1.start();
        t2.start();
    }

    /**
     * 偶数线程
     */
    public static class OuNum implements Runnable {
    	
        private ThreadWaitNotifyDemo number;

        public OuNum(ThreadWaitNotifyDemo number) {
            this.number = number;
        }

        @Override
        public void run() {

            while (number.start <= 100) {
                synchronized (ThreadWaitNotifyDemo.class) {
                    System.out.println("偶数线程抢到锁了");
                    if (number.flag) {
                        System.out.println(Thread.currentThread().getName() + "+-+偶数" + number.start);
                        number.start++;

                        number.flag = false;
                        ThreadWaitNotifyDemo.class.notify();

                    }else {
                        try {
                            ThreadWaitNotifyDemo.class.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }

            }
        }
    }


    /**
     * 奇数线程
     */
    public static class JiNum implements Runnable {
    	
        private ThreadWaitNotifyDemo number;

        public JiNum(ThreadWaitNotifyDemo number) {
            this.number = number;
        }

        @Override
        public void run() {
            while (number.start <= 100) {
                synchronized (ThreadWaitNotifyDemo.class) {
                    System.out.println("奇数线程抢到锁了");
                    if (!number.flag) {
                        System.out.println(Thread.currentThread().getName() + "+-+奇数" + number.start);
                        number.start++;

                        number.flag = true;

                        ThreadWaitNotifyDemo.class.notify();
                    }else {
                        try {
                            ThreadWaitNotifyDemo.class.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
    }

}
