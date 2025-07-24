package com.anoxi.service;

import org.springframework.stereotype.Service;

@Service
public class MessageService {

    public String welcomeMsg(){
        String msg = "Welcome to Anoxi appilcation...!!!";
        return msg;
    }

    public String greetMsg(){           //text block Java 17+ Feature
        String msg =  """
                        Good Morning,
                        Have a Nice Day....!!!!
                        With Lovely Good Friday.
                      """;

        return msg;
    }

    public String wish(String name){
        if (name.equalsIgnoreCase("Raju")){
            return "Hey Raju, How are you ?";
        } else if (name.equalsIgnoreCase("Hira")) {
            return "Hey Hira, How are you ?";
        }
        else {
            return null;
        }
    }
}
