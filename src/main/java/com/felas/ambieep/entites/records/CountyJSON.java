package com.felas.ambieep.entites.records;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.felas.ambieep.entites.enums.State;

public record CountyJSON(
        @JsonProperty("id") long id,
        @JsonProperty("nome") String nome,
        @JsonProperty("microrregiao") MicrorregiaoDTO microrregiao,
        @JsonProperty("regiao-imediata") RegionImmediateJSON regiaoImediata
) {
    public record MicrorregiaoDTO(
            @JsonProperty("id") long id,
            @JsonProperty("nome") String nome,
            @JsonProperty("mesorregiao") MesorregiaoDTO mesorregiao
    ) {
        public record MesorregiaoDTO(
                @JsonProperty("id") long id,
                @JsonProperty("nome") String nome,
                @JsonProperty("UF") UFDTO UF
        ) {
            public record UFDTO(
                    @JsonProperty("id") long id,
                    @JsonProperty("sigla") String sigla,
                    @JsonProperty("nome") String nome,
                    @JsonProperty("regiao") RegiaoDTO regiao
            ) {
                public record RegiaoDTO(
                        @JsonProperty("id") long id,
                        @JsonProperty("sigla") String sigla,
                        @JsonProperty("nome") String nome
                ) {
                }
            }
        }
    }

    public record RegionImmediateJSON(
            @JsonProperty("id") long id,
            @JsonProperty("nome") String nome,
            @JsonProperty("regiao-intermediaria") intermediateRegionJSON regiaoIntermediaria
    ) {
        public record intermediateRegionJSON(
                @JsonProperty("id") long id,
                @JsonProperty("nome") String nome,
                @JsonProperty("UF") UFJSON UF
        ) {
            public record UFJSON(
                    @JsonProperty("id") long id,
                    @JsonProperty("sigla") String sigla,
                    @JsonProperty("nome") String nome,
                    @JsonProperty("regiao") RegionJSON regiao
            ) {

                public State siglaUF() {
                    for (State e : State.values()) {
                        if (e.getAcronym().equals(this.sigla.toUpperCase())) {
                            return e;
                        }
                    }
                    return null;
                }

                public record RegionJSON(
                        @JsonProperty("id") long id,
                        @JsonProperty("sigla") String sigla,
                        @JsonProperty("nome") String nome
                ) {
                }
            }
        }
    }
}
