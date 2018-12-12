package com.vanillastorm.util.custom;

public interface Config {
    <T> Class<T> getImpl(String name);
}
