package com.mo.bao.future;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

/**
 * Created by hadoop on 2017/12/24.
 */
public class LambdaTest {

    static class TestConsumer implements Consumer<List<Integer>> {

        @Override
        public void accept(List<Integer> integers) {
            integers.forEach(x -> System.out.println(x));
        }
    }


    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        TestConsumer testConsumer = new TestConsumer();
        testConsumer.accept(numbers);


        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        Arrays.stream(arr).map(x->x=x+1).forEach(System.out::println);
        Arrays.stream(arr).forEach(System.out::println);
    }

}
