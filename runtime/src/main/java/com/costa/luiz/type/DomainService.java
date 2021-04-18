package com.costa.luiz.type;

import com.costa.luiz.annotation.type.CustomType;

import static java.util.Objects.isNull;

public class DomainService {

    public void delete(String id) throws @CustomType IllegalArgumentException {
        if (isNull(id)) {
            throw new IllegalArgumentException("id cannot be null");
        }
    }
}
