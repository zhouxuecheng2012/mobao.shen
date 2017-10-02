package com.mo.bao.chapter3.proxy;

/**
 * Created by hadoop on 2017/9/26.
 */
public class BookFacadeImpl implements BookFacade  {

    @Override
    public void addBook() {
        System.out.println("增加图书方法。。。");
    }

}
