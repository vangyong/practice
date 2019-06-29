package cn.segema.learn.interview.idgenerate;

public class SnowFlakeDemo {
	public static void main(String[] args) {
        SnowFlake snowFlake = new SnowFlake(2, 3);
        for (int i = 0; i < (1 << 2); i++) {
            System.out.println(snowFlake.nextId());
        }
  
    }

}
