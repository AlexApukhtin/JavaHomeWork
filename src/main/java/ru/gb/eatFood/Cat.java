package ru.gb.eatFood;

import java.util.Random;

public class Cat {
    private String name;
    private int appetite;
    private boolean satiety;
    private static int countEat;

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
        this.appetite = rnd.nextInt(5) + 6;
        return this.appetite;
    }

    public int eat(Plate plate, Cat cat) {
        if (plate.getFood() >= this.appetite) {
            plate.decreaseFood(this.appetite);
            this.satiety = true;
            countEat++;
            System.out.print(cat);
            //System.out.printf("Ест кот: %s, аппетит: %d, сытость: %b\n",name ,appetite, satiety);
            System.out.print(plate);
        }
        return plate.getFood();
    }

    public int notEat(Plate plate){
        int food;
        this.satiety = false;
        System.out.println("Кот " + getName()+" остался голодным. Сытость: " + this.isSatiety());
        System.out.print("Добавить еды: ");
        food = plate.addFood(plate.getFood());
        plate.setFood(food);
        return food;
    }

    public String toString() {
        return "Cat{name='" + this.name + '\'' + ", appetite=" + this.appetite + ", satiety=" + this.satiety + '}'+"\n";
    }
}

