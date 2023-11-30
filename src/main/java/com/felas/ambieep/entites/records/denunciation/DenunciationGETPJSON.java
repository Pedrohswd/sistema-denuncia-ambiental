package com.felas.ambieep.entites.records.denunciation;

import com.felas.ambieep.entites.Category;
import com.felas.ambieep.entites.enums.CategoryType;
import com.felas.ambieep.entites.enums.Situation;
import com.felas.ambieep.entites.enums.State;

import java.util.Date;

public record DenunciationGETPJSON(String cpf,
                                   State state,
                                   String conty,
                                   CategoryType categoryType,
                                   Category category,
                                   Date dateReg,
                                   Date dateFact,
                                   Situation situation
                                   ) {
}
