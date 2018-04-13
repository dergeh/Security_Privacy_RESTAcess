package de.tub.privacySecurityEvaluator;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import de.tub.privacySecurityEvaluator.api.RestService;
import de.tub.privacySecurityEvaluator.model.BlueprintRanking;
import de.tub.privacySecurityEvaluator.service.EvaluatorService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTests {
    private RestService restService;
    private String body = "{\"requirement\":{\"id\":\"1\",\"name\":\"Encryption AES 128\",\"type\":\"Encryption\",\"properties\":[{\"name\":\"Algorithm\",\"unit\":\"enum\",\"value\":\"AES\"},{\"name\":\"Keylength\",\"unit\":\"number\",\"minimum\":128}]},\"blueprintMetrics\":[{\"type\":\"object\",\"description\":\"Encryption\",\"properties\":{\"id\":\"1\",\"name\":\"Encryption AES 128\",\"type\":\"Encryption\",\"properties\":[{\"name\":\"Algorithm\",\"unit\":\"enum\",\"value\":\"AES\"},{\"name\":\"Keylength\",\"unit\":\"number\",\"value\":128}]}},{\"type\":\"object\",\"description\":\"Encryption\",\"properties\":{\"id\":\"1\",\"name\":\"Encryption AES 128\",\"type\":\"Encryption\",\"properties\":[{\"name\":\"Algorithm\",\"unit\":\"enum\",\"value\":\"AES\"},{\"name\":\"Keylength\",\"unit\":\"number\",\"value\":256}]}}]}";
    private String output1 = "{\"blueprint\":{\"id\":\"1\",\"name\":\"Encryption AES 128\",\"type\":\"Encryption\",\"properties\":[{\"name\":\"Algorithm\",\"unit\":\"enum\",\"value\":\"AES\"},{\"name\":\"Keylength\",\"unit\":\"number\",\"minimum\":128}]},\"score\":0.9}";
    private String output2 = "{\"blueprint\":{\"id\":\"2\",\"name\":\"Encryption AES 256\",\"type\":\"Encryption\",\"properties\":[{\"name\":\"Algorithm\",\"unit\":\"enum\",\"value\":\"AES\"},{\"name\":\"Keylength\",\"unit\":\"number\",\"minimum\":256}]},\"score\":0.7}";


    @Autowired
    public void setRestService(RestService restService) {
        this.restService = restService;
    }

    /**
     * @Test public void contextLoads() {
     * String out = body;
     * out = out.replace("\n", "");
     * out = out.replaceAll("\\s+","");
     * System.out.println(out);
     * <p>
     * }
     */
    @Test
    public void inputOutputFilterTest() {
        ObjectMapper mapper = new ObjectMapper();
        List<BlueprintRanking> blueprintRanking = restService.filterPolicies(body);
        try {
            String testOutput1 = mapper.writeValueAsString(blueprintRanking.get(0));
            String testOutput2 = mapper.writeValueAsString(blueprintRanking.get(1));
            assertEquals(testOutput1, output1);
            assertEquals(testOutput2, output2);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }


}
