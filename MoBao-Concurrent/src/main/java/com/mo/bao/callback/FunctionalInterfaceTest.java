package com.mo.bao.callback;

/**
 * Created by hadoop on 2017/12/31.
 */
public class FunctionalInterfaceTest {

    public static int execute(TestInterface<String, Integer> testInterface,String request) {
        int result = testInterface.execute(request);
        return result;
    }

    public static void main(String[] args) {
       int result = execute((t) -> {
            Integer i = Integer.parseInt(t);
            return i / 5;
        },"10");
        System.out.println(result);

        result = execute(new TestInterfaceImpl(),"200");
        System.out.println(result);
    }

}
