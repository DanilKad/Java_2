package lesson1.maraphon.competitior;

public class Cat implements Competitor {
    String name;

    int maxRunDist;
    int maxJumpHeig;

    boolean onDistance;

    public Cat(String name, int maxRunDist, int maxJumpHeig) {
        this.name = name;
        this.maxRunDist = maxRunDist;
        this.maxJumpHeig = maxJumpHeig;
        this.onDistance = true;
    }

    public Cat(String name) {
        this(name, 200, 3);
    }

    @Override
    public void run(int dist) {
        if(dist <= maxRunDist){
            System.out.println(name + " " + " успешно преодолел кросс");
        }else {
            System.out.println(name + " " + "не справился с кроссом");
            onDistance = false;
        }

    }

    @Override
    public void jump(int height) {
        if(height <= maxJumpHeig){
            System.out.println(name + " " + " успешно преодолел прыжки");
        }else {
            System.out.println(name + " " + "не справился с прыжками");
            onDistance = false;
        }

    }

    @Override
    public boolean isOnDistance() {
        return onDistance;
    }

    @Override
    public void info() {
        System.out.println(name + " " + (onDistance ? " на дистанции": " выбыл"));

    }
}
