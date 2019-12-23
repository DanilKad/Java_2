package java2.lesson1;

import java2.lesson1.maraphon.competitior.Cat;
import java2.lesson1.maraphon.competitior.Competitor;
import java2.lesson1.maraphon.competitior.Human;
import java2.lesson1.maraphon.competitior.Robot;
import java2.lesson1.obstacles.Cross;
import java2.lesson1.obstacles.Obstacle;
import java2.lesson1.obstacles.Wall;

public class Main {
    public static void main(String[] args) {

        Competitor[] competitors = {
                new Human("Иван"),
                new Cat("Барсик"),
                new Robot("Нео"),
                new Human("Дмитрий"),
                new Cat("Сеня"),
                new Robot("Эндрю")

            };
        Obstacle[] obstacles = {
                new Cross(1000),
                new Wall(1)
        };

        for (Competitor c:competitors) {
            for (Obstacle o: obstacles) {
                o.doIt(c);
                if(!c.isOnDistance()){
                    break;
                }

            }

        }
        for (Competitor c:competitors){
            c.info();
        }
    }
}
