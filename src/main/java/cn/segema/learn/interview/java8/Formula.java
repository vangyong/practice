package cn.segema.learn.interview.java8;


/**
 * @ClassName: Formula 
 * @description: 接口的默认方法
 * @author: wangyong
 * @date: 2016年12月14日 上午10:30:00
 */
public interface Formula {
	
	double calculate(int a);

    default double sqrt(int a) {
        return Math.sqrt(a);
    }

}
