package com.xavier.center.service;

import com.xavier.center.CenterApplicationTests;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;

public class SequenceServiceTest extends CenterApplicationTests {

    @Autowired
    private SequenceService sequenceService;


    @Test
    public void generate() {
        Runnable r = () -> {
            for (int i = 0; i < 10; i++) {
                System.out.println(sequenceService.generate("test", 1));
            }
        };
        new Thread(r).start();
        new Thread(r).start();
        new Thread(r).start();
        new Thread(r).start();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}