package cn.segema.learn.interview.producerconsumer;

public interface Storage {
	// 仓库最大存储量
	int MAX_SIZE = 100;

	// 生产num个产品
	void produce(int num);

	// 消费num个产品
	void consume(int num);
}
