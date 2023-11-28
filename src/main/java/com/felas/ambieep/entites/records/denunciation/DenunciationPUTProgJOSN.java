package com.felas.ambieep.entites.records.denunciation;

import com.felas.ambieep.entites.User;
import com.felas.ambieep.entites.enums.Situation;

public record DenunciationPUTProgJOSN(String nProtocol,
                                      Situation situation,
                                      String analystCPF) {
}
