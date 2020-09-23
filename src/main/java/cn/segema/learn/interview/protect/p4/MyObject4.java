package cn.segema.learn.interview.protect.p4;

import cn.segema.learn.interview.protect.p44.Test4;
import net.bytebuddy.implementation.bind.annotation.Super;

public class MyObject4 extends Test4 {

	protected Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
}
