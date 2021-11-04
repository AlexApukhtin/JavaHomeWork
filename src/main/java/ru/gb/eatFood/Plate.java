package ru.gb.eatFood;

import java.util.Scanner;

public class Plate {

    private int food;
    private int bagEat=100;
    private int remainsBagEat;

    public Plate(int food) {
        this.food = food;
    }

    public int getFood() {
        return food;
    }

    public void setFood(int food) {
        this.food = food;
    }

    public void decreaseFood(int food){
        this.food -= food;
    }

    public int getBagEat() {
        return addFood(food);
    }

    public void setBagEat(int bagEat) {
        this.bagEat = bagEat;
    }

    public int getRemainsBagEat() {
        return remainsBagEat;
    }

    public int addFood(int food){

        Scanner sc = new Scanner(System.in);
        int addFood;
        addFood = sc.nextInt();
        if(bagEat>addFood) {
            bagEat -= addFood;
            System.out.println("Еды в коробке осталось " + bagEat);
            food = addFood + food;
            remainsBagEat = bagEat - addFood;
            return food;
        }else if(bagEat == addFood){
            remainsBagEat = bagEat - addFood;
            bagEat -= addFood;
            System.out.println("Еды в коробке не осталось " + bagEat);
            food = addFood+ food;
            return food;
        }else {
            System.out.println("Высыпали остатки "+bagEat+". Больше нет!");
            food += bagEat;
            return food;
        }
    }

    @Override
    public String toString() {
        return "Plate" +
                " food= ";
    }


}
