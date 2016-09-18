package com.mo.bao.spi;

/**
 * Created by xuecheng.zhou on 2016/9/18.
 * mvn clean install -Dmaven.test.skip=true
 * mvn exec:java -Dexec.mainClass=com.unei.serviceloader.Main
 */
public interface Command {

    public void execute();

}