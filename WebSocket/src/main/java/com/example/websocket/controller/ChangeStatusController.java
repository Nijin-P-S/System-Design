package com.example.websocket.controller;


import com.example.websocket.Service.ChangeStatusService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class ChangeStatusController {

    private ChangeStatusService changeStatusService;

    ChangeStatusController(ChangeStatusService changeStatusService) {
        this.changeStatusService = changeStatusService;
    }

    @PostMapping("/update-status")
    public ResponseEntity<String> updateStatus(@RequestParam("status") String status) throws IOException {
        System.out.println("The DB updation of status is being executed");

        changeStatusService.updateStatus(status);
        return new ResponseEntity<>(
                HttpStatus.ACCEPTED
        );
    }
}
