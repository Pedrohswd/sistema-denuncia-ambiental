package com.felas.ambieep.entites.records.denunciation;

import com.felas.ambieep.entites.enums.Situation;

public record DenunciationPUTConcludeJSON(String nProtocol,
                                          Situation situation,
                                          String analystCPF,
                                          String technicalReport) {
}
