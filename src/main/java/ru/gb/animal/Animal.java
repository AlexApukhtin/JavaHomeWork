package ru.gb.animal;

public abstract class Animal {

    private String name;
    protected int run;
    protected int swim;
    protected String view;
    private static int count;

    public Animal(String name,int run, int swim){
        count++;
        setName(name);
        setRun(run);
        setSwim(swim);
    }

    public abstract void print(int score, int length);

    public String getView() {return view;}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if(name.length() != 0) this.name = name;
    }

    protected int getRun() {
        return run;
    }

    public abstract void setRun(int run);

    public int getSwim() {
        return this.swim;
    }

    public abstract void setSwim(int swim);

    public static int getCount() {return count;}
}

