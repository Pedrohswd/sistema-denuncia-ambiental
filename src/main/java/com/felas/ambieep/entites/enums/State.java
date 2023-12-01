package com.felas.ambieep.entites.enums;

public enum State {
    AC(0),
    AL(1),
    AP(2),
    AM(3),
    BA(4),
    CE(5),
    DF(6),
    ES(7),
    GO(8),
    MA(9),
    MT(10),
    MS(11),
    MG(12),
    PA(13),
    PB(14),
    PR(15),
    PE(16),
    PI(17),
    RJ(18),
    RN(19),
    RS(20),
    RO(21),
    RR(22),
    SC(23),
    SP(24),
    SE(25),
    TO(26);

    private final int id;

    State(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    // Função para obter o ID a partir de uma instância da enumeração
    public static int getIdFromState(State state) {
        return state.getId();
    }

}
