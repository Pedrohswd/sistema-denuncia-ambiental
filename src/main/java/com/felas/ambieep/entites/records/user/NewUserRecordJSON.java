package com.felas.ambieep.entites.records.user;

import com.felas.ambieep.entites.enums.Permission;

public record NewUserRecordJSON(String cpf,
                                String password,
                                String name,
                                String phone,
                                Permission permission) {
}
