package com.biapay.core.helper;

public class ServiceIdContainer {
    private static final ThreadLocal<String> serviceIdContainer = new ThreadLocal<>();

    public static String getServiceId() {
        return serviceIdContainer.get();
    }

    public static void setServiceId(String trackingNumber) {
        serviceIdContainer.set(trackingNumber);
    }

    public static void clearServiceId() {
        serviceIdContainer.remove();
    }
}
