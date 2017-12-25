package com.mo.bao.future;

/**
 * Created by hadoop on 2017/12/24.
 */
public class User {

    private int id;

    private String name;

    public User(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

}
