package com.ashoporders.messaging.producer;

public interface MessageProducer<T> {
    void sendMessage(T message);
}
