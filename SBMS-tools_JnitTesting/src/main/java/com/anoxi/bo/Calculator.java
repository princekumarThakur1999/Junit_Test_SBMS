package com.anoxi.bo;

import org.springframework.stereotype.Component;

@Component
public class Calculator {

    public Integer add(Integer dig1, Integer dig2){

        return dig1 + dig2;
    }

    public Integer div(Integer dig1, Integer div2){
        try {
            Thread.sleep(1005);
            return dig1/div2;
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
