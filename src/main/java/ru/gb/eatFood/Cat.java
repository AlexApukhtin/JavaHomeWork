package ru.gb.eatFood;

import java.util.Random;
import java.util.Scanner;

public class Cat {

    private String name;
    private int appetite;
    private boolean satiety;

    public Cat(String name, int appetite, boolean satiety) {
        this.name= name;
        this.appetite = appetite;
        this.satiety =satiety;
    }

    public boolean isSatiety() {
        return satiety;
    }

    public String getName() {
        return name;
    }

    public int getAppetite() {
        Random rnd = new Random();
        appetite = rnd.nextInt(5)+ 5;
        return appetite ;
    }

    public int eat(Plate plate){
        int food;
        if (plate.getFood()>= appetite) {
            plate.decreaseFood(appetite);
            satiety = true;
            System.out.println("Коту "+ getName()+" хватило еды? Сытость: "+ isSatiety());
            food = plate.getFood();
            System.out.print(plate);
        }else{
            satiety = false;
            System.out.println("Кот остался голодным. Сытость: " + isSatiety());
            System.out.print("Добавить еды: ");
            food = plate.addFood(plate.getFood());
            plate.setFood(food);
        }
       return food;
    }

    @Override
    public String toString() {
        return "Cat{" +
                "name='" + name + '\'' +
                ", appetite=" + appetite +
                ", satiety=" + satiety +
                '}';
    }
}
