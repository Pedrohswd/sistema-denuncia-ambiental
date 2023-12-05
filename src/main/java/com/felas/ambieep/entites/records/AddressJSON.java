package com.felas.ambieep.entites.records;

import com.felas.ambieep.entites.Address;
import com.felas.ambieep.entites.County;
import com.felas.ambieep.entites.enums.State;

public record AddressJSON(
        String street,
        State state,
        String county,
        Double latitude,
        Double longitude
) {
}
