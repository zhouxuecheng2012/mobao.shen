package com.mo.bao.spi.impl;

import com.mo.bao.spi.Command;

/**
 * Created by xuecheng.zhou on 2016/9/18.
 */
public class ShutdownCommand implements Command {

    public void execute() {
        System.out.println("shutdown....");
    }

}
