package controller;

import java.util.Map;

import entity.Thuoc;

public class MyEntry<K, V> implements Map.Entry<Thuoc, Integer> {
    private final Thuoc key;
    private Integer value;

    public MyEntry(Thuoc key, Integer value) {
        this.key = key;
        this.value = value;
    }

    @Override
    public Thuoc getKey() {
        return key;
    }

    @Override
    public Integer getValue() {
        return value;
    }

    @Override
    public Integer setValue(Integer value) {
    	Integer old = this.value;
        this.value = value;
        return old;
    }
}