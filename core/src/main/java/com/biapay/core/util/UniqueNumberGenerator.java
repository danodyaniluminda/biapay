package com.biapay.core.util;

import java.time.Instant;

/**
 * @author : A.M
 * @mailto : ahmedmohsenm95@gmail.com
 * @since : 1/26/2024 - 6:37 PM
 **/
public class UniqueNumberGenerator {
    private static long lastTimestamp = -1L;
    private static int counter = 0;

    public synchronized static String generateUniqueNumber() {
        long timestamp = Instant.now().toEpochMilli();

        if (timestamp == lastTimestamp) {
            counter++;
        } else {
            counter = 0;
            lastTimestamp = timestamp;
        }

        // This is to ensure that the counter is always within the range of 0 to 999
        int uniqueCounter = counter % 1000;

        // Reduce the timestamp to a 6-digit number by taking the last 6 digits
        long reducedTimestamp = timestamp % 1_000_000L;

        // Combine the reduced timestamp with the counter to get a 9-digit number
        int generated = (int) (reducedTimestamp * 1_000 + uniqueCounter);
        return String.valueOf(generated);
    }

}
