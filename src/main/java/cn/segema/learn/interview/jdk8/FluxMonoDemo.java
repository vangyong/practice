package cn.segema.learn.interview.jdk8;

import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.util.Optional;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * 
 * @description Flux相当于一个RxJava Observable，能够发出 0~N 个数据项 
 * 然后（可选地）completing 或 erroring 处理多个数据项作为stream.
 * Mono是指最多只能触发(emit) (事件)一次 相当于Optional.
 * @author wangyong
 * @createDate 2020/09/03
 */
public class FluxMonoDemo {
	public static void main(String[] args) {
//		Flux.just("Hello", "World").subscribe(System.out::println);
//		Flux.fromArray(new Integer[] { 1, 2, 3 }).subscribe(System.out::println);
//		Flux.empty().subscribe(System.out::println);
//		System.out.println("----");
//		Flux.range(1, 10).subscribe(System.out::println);
		Flux.interval(Duration.of(10, ChronoUnit.SECONDS)).subscribe(System.out::println);

//		Mono.fromSupplier(() -> "Hello").subscribe(System.out::println);
//		Mono.justOrEmpty(Optional.of("Hello")).subscribe(System.out::println);
//		Mono.create(sink -> sink.success("Hello")).subscribe(System.out::println);
	}
}
