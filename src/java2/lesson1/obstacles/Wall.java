package java2.lesson1.obstacles;

import java2.lesson1.maraphon.competitior.Competitor;

public class Wall extends Obstacle {
    int height;

    public Wall(int height) {
        this.height = height;
    }

    @Override
    public void doIt(Competitor competitor) {
        competitor.jump(height);

    }
}
