package com.felas.ambieep.entites.records.denunciation;

import com.felas.ambieep.entites.*;
import com.felas.ambieep.entites.enums.Situation;

import java.util.Date;
import java.util.List;

public record DenunciationPOSTJSON(
        String nProtocol,
        User user,
        List<String> photos,
        Category category,
        String description,
        String dateFact,
        String author,
        Situation situation,
        Address address) {


}