package com.biapay.core.helper;

import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;

@Component
public class ServiceIdGenerator {
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmssSSS");

//    public String generateTrackingNumber() {
//        String dateTimePart = dateFormat.format(new Date());
//        String uniqueIdPart = generateUniqueId(); // You need to implement this method.
//
//        return dateTimePart + uniqueIdPart;
//    }

    public String generateUniqueId() {
        // Implement a logic to generate a unique identifier (e.g., using AtomicLong, random number, etc.).
        // For simplicity, let's use millisecond timestamp as a unique identifier.
        return String.valueOf(System.currentTimeMillis());
    }
}
