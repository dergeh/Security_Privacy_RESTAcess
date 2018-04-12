package de.tub.privacySecurityEvaluator.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import de.tub.privacySecurityEvaluator.model.BlueprintRanking;
import de.tub.privacySecurityEvaluator.model.Request;
import de.tub.privacySecurityEvaluator.service.EvaluatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping(value = "/")
public class RestService {

    private EvaluatorService evaluatorService;


    @Autowired
    public void setEvaluatorService(EvaluatorService evaluatorService) {
        this.evaluatorService = evaluatorService;
    }


    @RequestMapping(value = "/filter", method = RequestMethod.POST)
    public List<BlueprintRanking> filterPolicies(@RequestBody String body) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            Request input = mapper.readValue(body, Request.class);
            return evaluatorService.evaluateRequest(input);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;

    }
    //model


}
