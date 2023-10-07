package com.reqxar.spring.listeners;

import java.util.EventObject;

public class EntityEvent extends EventObject {
    private final AccesType accesType;

    public EntityEvent(Object source, AccesType accesType) {
        super(source);
        this.accesType = accesType;
    }

    public AccesType getAccessType() {
        return accesType;
    }
}
