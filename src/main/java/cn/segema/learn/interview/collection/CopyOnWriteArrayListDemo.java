package cn.segema.learn.interview.collection;

import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @description 是对原有数据进行一次拷贝，将修改的内容写入副本中,
 * 写完之后，再将原来指向的内存指针指到新的内存，原来的内存就可以被回收
 * @author wangyong
 * @createDate 2020/08/30
 */
public class CopyOnWriteArrayListDemo {
	
	CopyOnWriteArrayList<Object> copyOnWriteArrayList = new CopyOnWriteArrayList<Object>();
	

}
