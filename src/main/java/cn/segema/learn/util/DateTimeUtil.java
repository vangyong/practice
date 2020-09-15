package cn.segema.learn.util;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @description 时间工具
 * @author wangyong
 * @createDate 2020/09/14
 */
public class DateTimeUtil {

    /**
     * @description 每隔两小时一个时间段
     * @param startDate
     * @param endDate
     * @return
     */
    public static List<String> getIntervalHours(Date startDate, Date endDate) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:00:00");
        List<String> returnList = new ArrayList<String>();
        long startDateLong = startDate.getTime();
        long endDateLong = endDate.getTime();
        returnList.add(simpleDateFormat.format(startDateLong));
       
        while ((startDateLong + 3600 * 1000 * 2) <= endDateLong) {
            startDateLong = startDateLong + 3600 * 1000 * 2;
            String next2HourString = simpleDateFormat.format(startDateLong);
            returnList.add(next2HourString);
        }
        return returnList;
    }

}
