package ru.gb.animal;

public class Dog extends Animal{

    private static int trueDog;
    private static int dogScore;
    private static int DOG_RUN_LIMIT = 500;
    private static int DOG_SWIM_LIMIT = 10;
    public Dog(String name, int run, int swim) {
        super(name, run, swim);
        dogScore++;
    }

    public static int getDogScore() {
        return dogScore;
    }

    @Override
    public void setRun(int run) {
        if(run>=0){
            this.run = run;
        }else{
            System.out.println("run = " +run + " должно быть положительным!");
        }
    }

    public static int getTrueDog() {
        return trueDog;
    }

    @Override
    public void setSwim(int swim) {
        if( swim>= 0){
            this.swim = swim;
        }else{
            System.out.println("swim = " +swim + " должно быть положительным!");
        }
    }

    @Override
    public void print(int score, int length) {
        //score++;
        if (run > 0 && run <= DOG_RUN_LIMIT && swim > 0 && swim <= DOG_SWIM_LIMIT) {
            trueDog++;
            System.out.printf("%s пробежала %d м., проплыла %dм.\n", getName(), getRun(), getSwim());
        }
        if(run>DOG_RUN_LIMIT){
            System.out.println("Собаки("+score+") столько не бегают.run = "+ run + " присвоилось значение 500м");
            this.run = DOG_RUN_LIMIT;
        }
        if(swim>DOG_SWIM_LIMIT){
            System.out.println("Собаки("+score+") столько не плавают. swim = " + swim + " присвоилось значение 10м");
            this.swim = DOG_SWIM_LIMIT;
        }//
    }
}

