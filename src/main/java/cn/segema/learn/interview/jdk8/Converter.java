package cn.segema.learn.interview.jdk8;

@FunctionalInterface
public interface Converter<F, T> {
	T convert(F from);
}


