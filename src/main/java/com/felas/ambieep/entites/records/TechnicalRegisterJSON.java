package com.felas.ambieep.entites.records;

import com.felas.ambieep.entites.User;

import java.util.Date;

public record TechnicalRegisterJSON(User analystUser,
                                    String technicalReport) {
}
