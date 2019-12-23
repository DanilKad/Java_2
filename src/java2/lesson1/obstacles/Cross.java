package java2.lesson1.obstacles;

import java2.lesson1.maraphon.competitior.Competitor;

public class Cross extends  Obstacle {

    int length;

    public Cross(int length) {
        this.length = length;
    }

    @Override
    public void doIt(Competitor competitor) {
        competitor.run(length);

    }
}
