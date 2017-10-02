package com.mo.bao.chapter3.weak;

import java.lang.ref.WeakReference;

/**
 * Created by hadoop on 2017/9/24.
 * 一般用weak reference引用的对象是有价值被cache, 而且很容易被重新被构建, 且很消耗内存的对象.
 *
 */
public class TestWeakReference {

    public static void main(String[] args) {

        Car car = new Car(22000, "silver");
        WeakReference<Car> weakCar = new WeakReference<Car>(car);

        int i = 0;

        while (true) {
            if (weakCar.get() != null) {
                i++;
                System.out.println("Object is alive for " + i + " loops - " + weakCar);
            } else {
                System.out.println("Object has been collected.");
                break;
            }
        }
    }

}
