package com.costa.luiz.type;

import static java.util.Objects.isNull;

public class DomainService {

    public void delete(String id) throws @CustomType IllegalArgumentException {
        if (isNull(id)) {
            throw new IllegalArgumentException("id cannot be null");
        }
    }
}
