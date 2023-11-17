package com.felas.ambieep.entites.records;

import com.felas.ambieep.enumeration.Permission;

public record NewUserRecordJSON(String cpf,
                                String password,
                                String name,
                                String phone,
                                Permission permission) {
}
