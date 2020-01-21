package com.example.classemetodosnapratica;

public class Obama extends Cidadao implements Presidente {

    @Override
    public void ganharEleicao() {
        System.out.println("Ganhar uma eleição nos EUA");
    }
}
