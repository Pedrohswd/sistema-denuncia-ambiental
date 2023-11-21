package com.felas.ambieep.entites.enums;

public enum State {
    AC("Acre", 12),
    AL("Alagoas", 27),
    AP("Amapá", 16),
    AM("Amazonas", 13),
    BA("Bahia", 29),
    CE("Ceará", 23),
    DF("Distrito Federal", 53),
    ES("Espírito Santo", 32),
    GO("Goiás", 52),
    MA("Maranhão", 21),
    MT("Mato Grosso", 51),
    MS("Mato Grosso do Sul", 50),
    MG("Minas Gerais", 31),
    PA("Pará", 15),
    PB("Paraíba", 25),
    PR("Paraná", 41),
    PE("Pernambuco", 26),
    PI("Piauí", 22),
    RJ("Rio de Janeiro", 33),
    RN("Rio Grande do Norte", 24),
    RS("Rio Grande do Sul", 43),
    RO("Rondônia", 11),
    RR("Roraima", 14),
    SC("Santa Catarina", 42),
    SP("São Paulo", 35),
    SE("Sergipe", 28),
    TO("Tocantins", 17);

    private final String name;

    private final int id;


    State(String nomeCompleto, int id) {
        this.name = nomeCompleto;
        this.id = id;
    }

    public String getNome() {
        return name;
    }

    public String getAcronym(){
        return this.toString();
    }

    public int getId(){
        return id;
    }

    public State getById(int id){
        for (State e : this.values()){
            if (e.getId() == id){
                return e;
            }
        }
        return null;
    }
}
