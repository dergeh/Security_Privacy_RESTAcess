package privacy_rest_springboot.deployment;

import java.util.List;

public class BlueprintRanking  {
    private Property blueprint;
    private float score;

    public Property getBlueprint() {
        return blueprint;
    }

    public void setBlueprint(Property blueprint) {
        this.blueprint = blueprint;
    }



    public float getScore() {
        return score;
    }

    public void setScore(float score) {
        this.score = score;
    }
}
