package com.mo.bao;
/**
 * Created by hadoop on 2017/9/24.
 */
public class Test {

    //这里传递的并不是引用本身，而是一个引用的拷贝。
    //也就是说这时有两个引用（引用和引用的拷贝）同时指向堆中的对象
    public void set(User user) {
        user.setName("hello world");
        user = new User();
        user.setName("change");
    }

    public static void main(String[] args) {
        Test test = new Test();
        User user = new User();
        test.set(user);
        System.out.println(user.getName());
    }

}
