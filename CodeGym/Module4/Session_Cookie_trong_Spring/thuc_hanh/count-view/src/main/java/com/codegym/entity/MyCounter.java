package com.codegym.entity;

import javax.persistence.*;

@Entity
@Table(name = "my_count")
public class MyCounter {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int count;

    public MyCounter() {
    }

    public MyCounter(int count) {
        this.count = count;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int increment() {
        return count++;
    }
}
