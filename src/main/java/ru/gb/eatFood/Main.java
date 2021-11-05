package ru.gb.eatFood;

public class Main {
    private static int catEat;

    public static void main(String[] args) {
        final int numberOfMeals = 5;
        Cat[] cat = new Cat[]{
                new Cat(NameCats.BASYA.name(), 0, false),
                new Cat(NameCats.MURZIK.name(), 0, false),
                new Cat(NameCats.VASYA.name(), 0, false),
                new Cat(NameCats.MAYKA.name(), 0, false),
                new Cat(NameCats.TIMOFHEY.name(), 0, false)
        };
        Plate plate = new Plate(50);

        for(int j = 0; j < numberOfMeals; ++j) {
            for(int i = 0; i < cat.length; ++i) {
                catEat++;
                cat[i].getAppetite();
                if(plate.getFood()>= cat[i].getAppetite()){
                    System.out.println(cat[i].eat(plate, cat[i]));
                }else if(plate.getBagEat() >=0 &&plate.getFood()<cat[i].getAppetite()){
                    System.out.println(cat[i].notEat(plate));
                }
                plate.getBagEat();
                if(plate.getBagEat() == 0 && plate.getFood()< cat[i].getAppetite()){
                    j = numberOfMeals;
                    break;
                }
            }
        }
        System.out.print("Котов поело: "+ Cat.getCountEat());
        System.out.println(". Подходило к миске: "+ catEat);
        if(Cat.getCountEat() != cat.length * numberOfMeals) System.out.println("Еда кончилась, коты не наелись!");
    }
}

