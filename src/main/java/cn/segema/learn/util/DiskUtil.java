package cn.segema.learn.util;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;

import org.apache.commons.io.IOUtils;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import cn.segema.learn.elasticsearch.BulkProcessDemo;

/**
 * @description 磁盘大小检查
 * 运行查看 java cn.segema.learn.util.DiskUtil
 * @author wangyong
 * @createDate 2020/09/12
 */
public class DiskUtil {

    private static final Logger logger = LogManager.getLogger(DiskUtil.class);

    public static void main(String[] args) {
        // windows查看
        BigDecimal maxDiskUsed = getWindowsMaxDiskUsed();
        System.out.println(maxDiskUsed);
    }

    /**
     * @description 获取windows占用比例最大的值
     * @return 0-1的小数
     */
    public static BigDecimal getWindowsMaxDiskUsed() {
        BigDecimal maxDiskPercent = BigDecimal.ZERO;
        File[] files = File.listRoots();
        for (File file : files) {
            BigDecimal total = BigDecimal.valueOf(file.getTotalSpace());
            BigDecimal used = BigDecimal.valueOf(file.getUsableSpace());
            BigDecimal percent =(total.subtract(used)).divide(total,2, BigDecimal.ROUND_HALF_UP);
            if (maxDiskPercent.compareTo(percent)<0) {
                maxDiskPercent = percent;
            }
        }
        return maxDiskPercent;
    }

    /**
     * @description 获取linux最大使用百分比
     * @return 0-100的百分比值
     */
    public static int getLinuxMaxDiskUsed() {
        int maxDiskUsed = 0;
        Runtime rt = Runtime.getRuntime();
        Process p;
        try {
            p = rt.exec("df -hl");
            List<String> result = IOUtils.readLines(p.getInputStream(), "GBK");
            for (int i = 1; i < result.size(); i++) {
                try {
                    String[] items = result.get(i).split("%")[0].split(" ");
                    int lastIndex = items.length - 1;
                    int diskUsed = Integer.valueOf(items[lastIndex].trim()).intValue();
                    if (diskUsed >= maxDiskUsed) {
                        maxDiskUsed = diskUsed;
                    }
                } catch (Exception e) {
                    continue;
                }
            }
        } catch (IOException e) {
            logger.error(e.toString());
            e.printStackTrace();
        }
        return maxDiskUsed;
    }

}
