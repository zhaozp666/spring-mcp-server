package com.example.demo.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@RestController
public class SseController {
    private final ExecutorService executorService = Executors.newFixedThreadPool(10);

    @GetMapping(value = "/sseChat", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public SseEmitter streamChat() {
        SseEmitter sseEmitter = new SseEmitter(100_000L);//100s
        executorService.execute(() -> {
            try {
                for (int i = 0; i < 100; i++) {
                    Thread.sleep(1000);
                    sseEmitter.send(SseEmitter.event()
                            .id(String.valueOf(i))
                            .name("sseChat")
                            .data("Event " + i));
                }
            } catch (Exception e) {
                sseEmitter.completeWithError(e);
            }
        });
        sseEmitter.onCompletion(() -> System.out.println("sseEmitter completed"));
        sseEmitter.onTimeout(() -> System.out.println("sseEmitter timeout"));
        sseEmitter.onError(e -> System.out.println("sseEmitter error"));
        return sseEmitter;
    }
}
