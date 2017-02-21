package com.mo.bao.akka.study;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by hadoop on 2017/2/22.
 */
public final class ImmutableMessage {

    private final int sequenceNumber;

    private final List<String> values;

    public ImmutableMessage(int sequenceNumber, List<String> values) {
        this.sequenceNumber = sequenceNumber;
        this.values = Collections.unmodifiableList(new ArrayList<String>());
    }

    public int getSequenceNumber() {
        return sequenceNumber;
    }

    public List<String> getValues() {
        return values;
    }

}
