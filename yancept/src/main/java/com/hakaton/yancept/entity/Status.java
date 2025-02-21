package com.hakaton.yancept.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Status {
    ACCEPTED((short) 1), REJECT((short) -1), IN_PROCESS((short) 0);

    private final short code;
}
