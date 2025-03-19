package com.app.service;

import java.util.Date;

public class GreetMsgServiceImpl implements GreetMsgService{
    @Override
    public String generateGreetMsg() {

        Date date = new Date();
        date.setDate(7);

        if(date.getDate()==7){
            return "HAPPY CHHAT PUJA";
        }
        else if(date.getDate()==1){
            return "HAPPY DIWALI";
        }
        else {
            return "KAAM V KARLO!!";
        }
    }
}
