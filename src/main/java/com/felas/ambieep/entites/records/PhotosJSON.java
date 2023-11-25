package com.felas.ambieep.entites.records;

import java.util.List;

public record PhotosJSON(List<String> imgBase64,
                         String nProtocol) {
}
