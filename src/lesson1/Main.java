package lesson1;

import lesson1.maraphon.competitior.Cat;
import lesson1.maraphon.competitior.Competitor;
import lesson1.maraphon.competitior.Human;
import lesson1.maraphon.competitior.Robot;
import lesson1.obstacles.Cross;
import lesson1.obstacles.Obstacle;
import lesson1.obstacles.Wall;

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
                new Wall(3)
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
