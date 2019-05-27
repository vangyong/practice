package cn.segema.learn.interview.jdk8;

import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.util.Optional;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class FluxDemo {
public static void main(String[] args) {
//	Flux.just("Hello", "World").subscribe(System.out::println);
//	Flux.fromArray(new Integer[] {1, 2, 3}).subscribe(System.out::println);
//	Flux.empty().subscribe(System.out::println);
//	Flux.range(1, 10).subscribe(System.out::println);
//	Flux.interval(Duration.of(10, ChronoUnit.SECONDS)).subscribe(System.out::println);
////	Flux.intervalMillis(1000).subscribe(System.out::println);
	
	
	Mono.fromSupplier(() -> "Hello").subscribe(System.out::println);
	Mono.justOrEmpty(Optional.of("Hello")).subscribe(System.out::println);
	Mono.create(sink -> sink.success("Hello")).subscribe(System.out::println);

}

}
