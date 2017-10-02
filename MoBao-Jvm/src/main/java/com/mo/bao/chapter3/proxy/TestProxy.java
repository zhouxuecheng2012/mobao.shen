package com.mo.bao.chapter3.proxy;

/**
 * Created by hadoop on 2017/9/26.
 */
public class TestProxy {

    public static void main(String[] args) {
        BookFacadeProxy proxy = new BookFacadeProxy();
        BookFacade bookProxy = (BookFacade) proxy.bind(new BookFacadeImpl());
        bookProxy.addBook();
    }

}
