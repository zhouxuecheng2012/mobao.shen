package com.mo.bao.wechat;

import com.mo.bao.wechat.request.RequestText;
import com.mo.bao.wechat.request.event.RequestEventClick;
import com.mo.bao.wechat.request.event.RequestEventSubscribe;
import com.mo.bao.wechat.request.event.RequestEventUnsubscribe;
import com.mo.bao.wechat.request.event.RequestEventView;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.springframework.stereotype.Component;

import java.io.ByteArrayInputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by hadoop on 2016/10/22.
 */
@Component
public class RequestCodec {

    @SuppressWarnings("unchecked")
    private Map<String, String> decodeToMap(String requestStr) {
        // 解析结果到HashMap中
        Map<String, String> requestMap = new HashMap<String, String>();

        try {
            // 读取输入流
            ByteArrayInputStream bain = new ByteArrayInputStream(requestStr.getBytes());
            SAXReader reader = new SAXReader();
            Document document = reader.read(bain);

            // 得到xml根元素
            Element root = document.getRootElement();

            // 得到根元素的所有子节点
            List<Element> elementList = root.elements();

            // 遍历所有子节点
            for (Element e : elementList) {
                requestMap.put(e.getName(), e.getText());
            }

            return requestMap;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    /**
     * 解码到消息bean
     *
     * @return 消息bean
     */
    public RequestBase decode(String requestStr) {
        Map<String, String> requestMap = decodeToMap(requestStr);

        if (!requestMap.containsKey("MsgType")) {
            return null;
        }

        String msgType = requestMap.get("MsgType");

        switch (msgType) {
            case "text":
                return RequestText.valueOf(requestMap);
            case "event":
                if (!requestMap.containsKey("Event")) {
                    return null;
                }

                String event = requestMap.get("Event").toLowerCase();

                switch (event) {
                    case "click":
                        return RequestEventClick.valueOf(requestMap);
                    case "view":
                        return RequestEventView.valueOf(requestMap);
                    case "subscribe":
                        return RequestEventSubscribe.valueOf(requestMap);
                    case "unsubscribe":
                        return RequestEventUnsubscribe.valueOf(requestMap);
                }

                break;
        }

        return null;
    }

}
