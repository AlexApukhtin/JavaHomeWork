package ru.gb.eatFood;

import java.util.Random;

public class Cat {
    private String name;
    private int appetite;
    private boolean satiety;
    private static int countEat;
    private static int catEat;

    public Cat(String name, int appetite, boolean satiety) {
        this.name = name;
        this.appetite = appetite;
        this.satiety = satiety;
    }

    public static int getCountEat() {return countEat;}

    public boolean isSatiety() {
        return this.satiety;
    }

    public String getName() {
        return this.name;
    }

    public int getAppetite() {
        Random rnd = new Random();
        this.appetite = rnd.nextInt(5) + 5;
        return this.appetite;
    }

    public int eat(Plate plate) {
       // int food;
        if (plate.getFood() >= this.appetite) {
            plate.decreaseFood(this.appetite);
            this.satiety = true;
            countEat++;
            //System.out.println("Коту " + this.getName() + " хватило еды? Сытость: " + this.isSatiety());
            System.out.printf("Ест кот: %s, аппетит: %d, сытость: %b\n",name ,appetite, satiety);
            //food = plate.getFood();
            System.out.print(plate);
            //return food;
//        } else {
//            this.satiety = false;
//            System.out.println("Кот остался голодным. Сытость: " + this.isSatiety());
//            System.out.print("Добавить еды: ");
//            food = plate.addFood(plate.getFood());
//            plate.setFood(food);
        }
        return plate.getFood();
    }

    public int notEat(Plate plate){
        int food;
        this.satiety = false;
        System.out.println("Кот остался голодным. Сытость: " + this.isSatiety());
        System.out.print("Добавить еды: ");
        food = plate.addFood(plate.getFood());
        plate.setFood(food);
        return food;//plate.addFood(plate.getFood());
    }

    public String toString() {
        return "Cat{name='" + this.name + '\'' + ", appetite=" + this.appetite + ", satiety=" + this.satiety + '}';
    }
}

