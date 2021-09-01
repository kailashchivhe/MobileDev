package com.company;

public class State {
    String name;
    int count;

    public State(String name, int count) {
        this.name = name;
        this.count = count;
    }

    @Override
    public String toString() {
        return "State{" +
                "name='" + name + '\'' +
                ", count=" + count +
                '}';
    }
}
