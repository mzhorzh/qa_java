package com.example;

import java.util.List;

public class Lion {

    //Объявляем переменные
    boolean hasMane;
    private Feline feline;

    //Делаем инъекцию зависимости с помощью конструктора Lion
    public Lion(String sex, Feline feline) throws Exception {
        this.feline = feline;

        if ("Самец".equals(sex)) {
            hasMane = true;
        } else if ("Самка".equals(sex)) {
            hasMane = false;
        } else {
            throw new Exception("Используйте допустимые значения пола животного - самей или самка");
        }
    }

    //Описание метода getKittens для семейства кошачьих
    public int getKittens() {
        return feline.getKittens();
    }

    //Описание метода doesHaveMane
    public boolean doesHaveMane() {
        return hasMane;
    }

    //Описание метода getFood
    public List<String> getFood() throws Exception {
        return feline.getFood("Хищник");
    }
}
