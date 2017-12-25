package com.mo.bao.future;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hadoop on 2017/12/24.
 */
public class ConstrMethodRef {

    @FunctionalInterface
    interface UserFactory<U extends User> {
        U create(int id, String name);
    }

    static UserFactory<User> uf = User::new;

    public static void main(String[] args) {
        List<User> users = new ArrayList<User>();
        for (int i = 0; i < 10; i++) {
            users.add(uf.create(i, "billy" + Integer.toString(i)));
        }
        users.stream().map(User::getName).forEach(System.out::println);
    }

}
