package cn.segema.learn.interview.download;

/**
* @description 一句话描述该类的功能
* @author wangyong
* @createDate 2020/08/31
*/
public class ExportQueuePoolService {

    BlockThreadPool pool = null;

    private ExportQueuePoolService() {
        pool = new BlockThreadPool(3);
    }

    public static ExportQueuePoolService instance = null;

    public static ExportQueuePoolService getInstance() {
        if (instance == null) {
            synchronized (ExportQueuePoolService.class) {
                if (instance == null) {
                    instance = new ExportQueuePoolService();
                }
            }
        }
        return instance;
    }

    public void put(Runnable service) {
        pool.execute(service);
    }

}
