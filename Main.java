package com.company;

public class Main {

    private static int TIME = 0;

    public static void main(String[] args) {

        Cat[] cat = new Cat[3];
        cat[0] = new Cat("Муся", 150, 3);
        cat[1] = new Cat("Вася", 100, 4);
        cat[2] = new Cat("Кися", 30, 1);
        Plate plate = new Plate(400);
        System.out.println("У тебя есть три котика: " + cat[0].getName() + ", " + cat[1].getName() + " и " + cat[2].getName() + ", которые хотят кушать каждые " + cat[0].getSatietyTime() + ", " + cat[1].getSatietyTime() + " и " + cat[2].getSatietyTime() + " час(а) соответственно.");
        System.out.println("Кто-то из них пухлый, кто-то не очень. Сейчас в миске " + plate.getFood() + " грамм кошачьего корма. Посмотрим насколько его хватит. На данный момент котики очень голодны и направляются кушонькать.\n");


            for (Cat i : cat) {

                if (i.getSatiety() == 0) { //если котик голоден

                    if (!plate.checkFood(i.getAppetite())) { //если в миске не хватает еды, чтобы накормить котика, она будет добавлена
                        plate.increaseFood();
                    }

                    i.eat(plate); //кот ест
                    System.out.println("Котик " + i.getName() + " съел " + i.getAppetite() + " граммов корма и проголодается через " + (i.getSatiety()) + " часа(ов)");
                }

                i.setSatiety(i.getSatiety() - 1); //декрементация сытости
            }
            System.out.println("\nС момента начала кормежки прошел(ло) " + TIME + " час(а). В миске осталось " + plate.getFood() + " граммов корма.\n");
            TIME++;

        }
    }


class Plate {

    private int food;

    int getFood() {
        return food;
    }

    Plate(int food) {
        this.food = food;
    }

    void decreaseFood(int n) {
        food -= n;
    }

    void increaseFood() {
        this.food += 400;
        System.out.println("В миску добавили 400 грамм корма");
    }

    boolean checkFood(int n) {
        return (food - n) >= 0;
    }

}

class Cat {

    private String name;
    private int appetite;
    private int satietyTime;
    private int satiety;

    String getName() {
        return name;
    }

    int getAppetite() {
        return appetite;
    }

    int getSatietyTime() {
        return satietyTime;
    }

    int getSatiety() {
        return satiety;
    }

    void setSatiety(int satiety) {
        this.satiety = satiety;
    }

    Cat(String name, int appetite, int satietyTime) {

        this.name = name;
        this.appetite = appetite;
        this.satietyTime = satietyTime;
        this.satiety = 0;
    }

    void eat(Plate p) {
        p.decreaseFood(appetite);
        satiety += satietyTime;
    }
}
