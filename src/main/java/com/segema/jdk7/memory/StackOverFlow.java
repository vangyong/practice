package com.segema.jdk7.memory;

/**
 * 栈层级不足探究
 * @author wangyong
 *
 */
public class StackOverFlow {
    private int i ;
    public void plus() {
       i++;
       plus();
    }
}
