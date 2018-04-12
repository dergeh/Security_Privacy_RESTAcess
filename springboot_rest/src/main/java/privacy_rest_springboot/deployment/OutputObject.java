package privacy_rest_springboot.deployment;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class OutputObject {
    @JsonProperty("blueprints")
    private List<BlueprintRanking> blueprints;

    public List<BlueprintRanking> getBlueprints() {
        return blueprints;
    }

    public void setBlueprints(List<BlueprintRanking> blueprints) {
        this.blueprints = blueprints;
    }
}
