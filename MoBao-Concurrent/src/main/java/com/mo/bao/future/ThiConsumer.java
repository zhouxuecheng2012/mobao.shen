package com.mo.bao.future;

/**
 * Created by hadoop on 2017/12/26.
 */
public interface ThiConsumer<T, U, W> {

    void accept(T t, U u, W w);

    default ThiConsumer<T, U, W> andThen(ThiConsumer<? super T, ? super U, ? super W> consumer) {
        return (t, u, w) -> {
            accept(t, u, w);
            consumer.accept(t, u, w);
        };
    }



}
