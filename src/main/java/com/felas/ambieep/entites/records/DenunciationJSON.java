package com.felas.ambieep.entites.records;

import com.felas.ambieep.entites.*;
import com.felas.ambieep.entites.enums.CategoryType;
import com.felas.ambieep.entites.enums.Situation;
import com.felas.ambieep.entites.enums.State;

import java.util.Date;
import java.util.List;

public record DenunciationJSON(
        String nProtocol,
        User user,
        List<Photos> photos,
        Category category,
        String description,
        Date dateFact,
        String author,
        Situation situation,
        Address address) {


}