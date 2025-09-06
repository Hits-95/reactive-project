package com.reactive.reactive_project;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import reactor.core.publisher.Mono;
import reactor.util.function.Tuple2;

@SpringBootTest
class ReactiveProjectApplicationTests {

    @Test
    void contextLoads() {
    }

    @Test
    void workingWithMono() {
        System.out.println("working with mono method.");
//        Mono<String> monoObj = Mono
//                .just("Single variable or data testing")
//                .log();
//
//        //there is multipe method to implement but now i use only one as labda extracting data only
//        monoObj.subscribe(data -> {
//            System.out.println("Data of mono obj: " + data);
//        });


        // combine multiple monos
        Mono<String> m1 = Mono.just("data string 1");
        Mono<String> m2 = Mono.just("data string 2");
        Mono<Integer> m3 = Mono.just(1234);

        //combine or make a zip of multiple mono
        Mono<Tuple2<String, String>> tuple2Mono = m1.zipWith(m2);
        tuple2Mono.subscribe(data ->{
            System.out.println(data.getT1());
            System.out.println(data.getT2());
        });

    }


}
