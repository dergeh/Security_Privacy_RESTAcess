package privacy_rest_springboot.deployment;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping(value="/test")
public class RestService {

    @RequestMapping(value = "/filter" , method = RequestMethod.POST)
    public List<BlueprintRanking> filterPolicies(@RequestBody String body){
        ObjectMapper mapper= new ObjectMapper();
        try {
            Request input= mapper.readValue(body, Request.class);

        } catch (IOException e) {
            e.printStackTrace();
        }

        return getObject();
    }

    public List<BlueprintRanking> getObject(){
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);
        try {OutputObject out=new OutputObject();
            ArrayList<BlueprintRanking> blueprintRankings= new ArrayList<>();
            blueprintRankings.add(mapper.readValue(
                    " {\n" +
                    "    \"blueprint\": {\n" +
                    "      \"id\": \"1\",\n" +
                    "      \"name\": \"Encryption AES 128\",\n" +
                    "      \"type\": \"Encryption\",\n" +
                    "      \"properties\": [\n" +
                    "        {\n" +
                    "          \"name\": \"Algorithm\",\n" +
                    "          \"unit\": \"enum\",\n" +
                    "          \"value\": \"AES\"\n" +
                    "        },\n" +
                    "        {\n" +
                    "          \"name\": \"Keylength\",\n" +
                    "          \"unit\": \"number\",\n" +
                    "          \"minimum\": 128\n" +
                    "        }\n" +
                    "      ]\n" +
                    "    },\n" +
                    "    \"score\": 0.9\n" +
                    "  }" ,  BlueprintRanking.class));
            blueprintRankings.add(mapper.readValue(" {\n" +
                    "        blueprint:\n" +
                            "        {\n" +
                            "               \"id\": \"2\",\n" +
                            "               \"name\": \"Encryption AES 256\",\n" +
                            "               \"type\": \"Encryption\",\n" +
                            "               \"properties\":[{\n" +
                            "                                            \"name\":\"Algorithm\",\n" +
                            "                                            \"unit\":\"enum\",\n" +
                            "                                            \"value\":\"AES\"\n" +
                            "                              },{\n" +
                            "                                            \"name\":\"Keylength\",\n" +
                            "                                            \"unit\":\"number\",\n" +
                            "                                            \"minimum\":256} \n" +
                            "               ]\n" +
                            "        },\n" +
                            "        score: 0.7\n" +
                            "    }\n" +
                            "\n", BlueprintRanking.class));
            out.setBlueprints(blueprintRankings);
            return out.getBlueprints();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}
