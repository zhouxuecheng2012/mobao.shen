package com.mo.bao.wechat.impl;

import com.mo.bao.wechat.RequestBase;
import com.mo.bao.wechat.RequestCodec;
import com.mo.bao.wechat.RequestProcessorFactory;
import com.mo.bao.wechat.WeChatMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by hadoop on 2016/10/22.
 */
@Service
public class WeChatMessageServiceImpl implements WeChatMessageService {

    @Autowired
    private RequestProcessorFactory factory;

    @Autowired
    private RequestCodec codec;

    @Override
    public String processRequest(String requestStr, boolean sync) {
        if (sync) {
            RequestBase requestBase = codec.decode(requestStr);

            return factory.doProcess(requestBase);
        } else {
            return "";
        }
    }
}
