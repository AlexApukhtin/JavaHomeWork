package ru.gb.eatFood;

import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Cat[] cat = {
                new Cat(NameCats.BASYA.name(), 0,false),
                new Cat(NameCats.MURZIK.name(), 0,false),
                new Cat(NameCats.VASYA.name(), 0,false),
                new Cat(NameCats.MAYKA.name(), 0,false),
                new Cat(NameCats.TIMOFHEY.name(), 0,false)
        };
        final Plate plate = new Plate(40);
        for (int j = 0; j < 5; j++) {
            for (int i = 0; i < cat.length; i++) {
                cat[i].getAppetite();
                System.out.print("Кушает кот " + cat[i].getName() +". ");
                System.out.println(cat[i].eat(plate));
//                if(plate.getBagEat() != plate.getRemainsBagEat()){
//                    System.out.println(cat[i].eat(plate));
//                }else {
//                    System.out.println("Еда кончилась, коты не наелись!");
//                    break;
//                }
            }
        }
    }
}
