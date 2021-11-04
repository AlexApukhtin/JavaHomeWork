package ru.gb.animal;

public class Cat extends Animal {

    private static int trueCat;
    private static int catScore;
    private static int CAT_RUN_LIMIT = 200;

    public Cat(String name, int run, int swim) {
        super(name, run, swim);
        catScore++;
    }

    public static int getTrueCat() {
        return trueCat;
    }

    public static int getCatScore() {
        return catScore;
    }

    @Override
    public void setRun(int run) {
        if(run >=0){
            this.run = run;
        }else if(run>CAT_RUN_LIMIT){
            this.run = CAT_RUN_LIMIT;
            System.out.println("Превышение норматива у кошки. run =  " + run + " присвоилось значение 200м\n");
        }else{
            System.out.println("run = " +run + " должно быть положительным!\n");
        }
    }

    @Override
    public void setSwim(int swim) {
        this.swim = swim;
    }

    @Override
    public void print ( int score, int length){
        if (run > 0 && run <= CAT_RUN_LIMIT && swim == 0) {
            trueCat++;
            System.out.printf("%s пробежала %d м.\n", getName(), getRun());
        }
        if(swim>0) System.out.println("Кошки(" +score+ ") не плавают!");
        if(run>CAT_RUN_LIMIT){
            System.out.println("Кошки("+score+") столько не бегают.run = "+ run + " присвоилось значение 200м");
            this.run = CAT_RUN_LIMIT;
        }
    }
}

