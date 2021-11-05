package ru.gb.animal;

public class Other extends Animal {

    private static int otherScore;//

    public Other(String name, int run, int swim, String view) {
        super(name, run, swim);
        setView(view);
        otherScore++;
    }

    public static int getOtherScore() {
        return otherScore;
    }

    public void setView(String view) {
        if (view.length() != 0) this.view = view;
    }

    @Override
    public void setRun(int run) {
        this.run = run;
    }

    @Override
    public void setSwim(int swim) {
        this.swim = swim;
    }

    @Override
    public void print(int score, int length) {
        System.out.printf("Это %s. %s пробежал %dм. и проплыл %dм.\n", getView(), getName(), getRun(), getSwim());
    }
}

