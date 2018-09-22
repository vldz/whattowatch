package com.vanillastorm.util;

public interface Config {
    <T> Class<T> getImpl(String name);
}
