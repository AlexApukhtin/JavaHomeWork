package ru.gb.animal;

public class Main {

    public static void main(String[] args) {

        Animal[] animals = {
                new Dog("Моника", 400,6),
                new Dog("Софа", 600, 5),
                new Dog("Криш", 500, 1),
                new Cat("Барсик", 250,0),
                new Cat("Мурзик", 100,2),
                new Cat("Муся", 140,0),
                new Other("Кеша",50,0,"Попугай"),
                new Other("Эдик",20,2,"Хорёк"),
        };
        int score = 0;

        for (int i = 0; i < animals.length; i++) {
            score++;
            animals[i].print(score, animals.length);
        }

        System.out.println("\nПравильных собак: "+ Dog.getTrueDog());
        System.out.println("Всего собак: "+ Dog.getDogScore());

        System.out.println("\nПравильных кошек: "+ Cat.getTrueCat());
        System.out.println("Всего кошек: " + Cat.getCatScore());

        System.out.println("\nОстальных животных: "+ Other.getOtherScore());
        System.out.println("Всего животных: " + Animal.getCount());
    }
}
