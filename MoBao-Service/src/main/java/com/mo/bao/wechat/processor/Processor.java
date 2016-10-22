package com.mo.bao.wechat.processor;

public interface Processor<T> {
	public String doProcess(T request);
}
