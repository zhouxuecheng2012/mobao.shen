package com.mo.bao;

import org.springframework.mail.MailParseException;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by hadoop on 2016/11/5.
 */
public class OtherTest {

    public static void main(String args[]){

        Map<String,String> map = new HashMap<String,String>(){{
            put("/apply/serviceContent","00001");
            put("/apply/statusRefresh","00002");
        }};


        String req="/apply/serviceContent";

        System.out.println(map.get(req));


    }

}
