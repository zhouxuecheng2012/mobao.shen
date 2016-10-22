package com.mo.bao.wechat;

import com.mo.bao.wechat.processor.Processor;
import com.mo.bao.wechat.processor.impl.ClickProcessor;
import com.mo.bao.wechat.processor.impl.SubScribeProcessor;
import com.mo.bao.wechat.processor.impl.TextProcessor;
import com.mo.bao.wechat.processor.impl.ViewProcessor;
import com.mo.bao.wechat.request.RequestText;
import com.mo.bao.wechat.request.event.RequestEventClick;
import com.mo.bao.wechat.request.event.RequestEventSubscribe;
import com.mo.bao.wechat.request.event.RequestEventView;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by hadoop on 2016/10/22.
 */
@Component
public class RequestProcessorFactory implements InitializingBean {

    @SuppressWarnings("rawtypes")
    private Map<String, Processor> processors = new HashMap<String, Processor>();

    @Autowired
    private ClickProcessor clickProcessor;

    @Autowired
    private TextProcessor textProcessor;

    @Autowired
    private SubScribeProcessor subScribeProcessor;

    @Autowired
    private ViewProcessor viewProcessor;


    @SuppressWarnings("rawtypes")
    public void setProcessors(Map<String, Processor> processors) {
        this.processors = processors;
    }

    public String doProcess(RequestBase requestBase) {
        if (requestBase instanceof RequestEventClick) {
            if (processors.containsKey("click")) {
                ClickProcessor processor = (ClickProcessor) processors.get("click");

                return processor.doProcess((RequestEventClick) requestBase);
            }
        }

        if (requestBase instanceof RequestEventView) {
            if (processors.containsKey("view")) {
                ViewProcessor processor = (ViewProcessor) processors.get("view");

                return processor.doProcess((RequestEventView) requestBase);
            }
        }

        if (requestBase instanceof RequestEventSubscribe) {
            if (processors.containsKey("subscribe")) {
                SubScribeProcessor processor = (SubScribeProcessor) processors.get("subscribe");

                return processor.doProcess((RequestEventSubscribe) requestBase);
            }
        }

        if (requestBase instanceof RequestText) {
            if (processors.containsKey("text")) {
                TextProcessor processor = (TextProcessor) processors.get("text");

                return processor.doProcess((RequestText) requestBase);
            }
        }

        return "";
    }

    @Override
    public void afterPropertiesSet() throws Exception {

        processors.put("click", clickProcessor);

        processors.put("view", viewProcessor);

        processors.put("subscribe", subScribeProcessor);

        processors.put("text", textProcessor);
    }


}
