package com.example.websocket.Service;


import com.example.websocket.handler.MyWebSockerHandler;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class ChangeStatusService {

    public void updateStatus(String statusValue) throws IOException {
        //Mimicking the DB updation
        System.out.println("The status is updated in the DB");

        //Notifying all the websocket connections
        MyWebSockerHandler.broadcast(
            "The status is updated to "+ statusValue
        );
    }
}
