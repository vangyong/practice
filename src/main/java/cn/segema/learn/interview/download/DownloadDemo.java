package cn.segema.learn.interview.download;

/**
* @description 异步下载数据
* @author wangyong
* @createDate 2020/08/31
*/
public class DownloadDemo {

    public static void main(String[] args) {

    }

    public void createThreadExcel(final ValueDomain valueDomain, final Long exportExcelId, final String fileName,
        final UserDomain userDomain) {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                // 具体的业务（用分页查询出数据，先生成EXCEL文件，再保存到文件服务端且生成一个文件路径，前端直接下载）
                ExportExcelDomain exportExcelDomain = createExcel(valueDomain, fileName, userDomain);
                System.out.println(exportExcelDomain);
            }
        };
        // 注意：使用单例模式
        ExportQueuePoolService.getInstance().put(runnable);
    }

    private ExportExcelDomain createExcel(ValueDomain valueDomain, String fileName, UserDomain userDomain) {
        return null;
    }
}
