package com.mycompany.bookduck.exceptions;

public class AvaliacaoOO2022NaoInformadaException extends RuntimeException{

    public AvaliacaoOO2022NaoInformadaException() {
        super("Os dados da avaliação precisam ser inseridos");
    }
}
