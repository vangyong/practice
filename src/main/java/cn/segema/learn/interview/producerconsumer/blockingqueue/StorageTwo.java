package cn.segema.learn.interview.producerconsumer.blockingqueue;

import java.util.concurrent.LinkedBlockingQueue;

import cn.segema.learn.interview.producerconsumer.Storage;

public class StorageTwo implements Storage{
	
    //仓库存储的载体
    private LinkedBlockingQueue<Object> list = new LinkedBlockingQueue<>(MAX_SIZE);

    /**
     * 生产num个产品
      * @param num
     */
    @Override
    public void produce(int num) {
        // 如果仓库剩余容量为0
        if (list.size() == MAX_SIZE) {
            System.out.println("【库存量】:" + MAX_SIZE + "/t暂时不能执行生产任务!");
        }
        // 生产条件满足情况下，生产num个产品
        for (int i = 1; i <= num; ++i) {
            try {
                // 放入产品，自动阻塞
                list.put(new Object());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("【现仓储量为】:" + list.size());
        }
    }

    /**
     * 消费num个产品
      * @param num
     */
    @Override
    public void consume(int num) {
        // 如果仓库存储量不足
        if (list.size() == 0) {
            System.out.println("【库存量】:0/t暂时不能执行生产任务!");
        }
        // 消费条件满足情况下，消费num个产品
        for (int i = 1; i <= num; ++i) {
            try {
                // 消费产品，自动阻塞
                list.take();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("【现仓储量为】:" + list.size());
    }

    public LinkedBlockingQueue<Object> getList() {
        return list;
    }

    public void setList(LinkedBlockingQueue<Object> list) {
        this.list = list;
    }
}
