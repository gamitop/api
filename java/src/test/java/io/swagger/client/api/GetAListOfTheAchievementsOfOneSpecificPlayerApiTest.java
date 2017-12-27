package io.swagger.client.api;

import io.swagger.client.ApiException;
import io.swagger.client.model.Players;
import org.junit.Test;
import org.junit.Ignore;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * API tests for GetAListOfTheAchievementsOfOneSpecificPlayerApi
 */
@Ignore
public class GetAListOfTheAchievementsOfOneSpecificPlayerApiTest {

    private final GetAListOfTheAchievementsOfOneSpecificPlayerApi api = new GetAListOfTheAchievementsOfOneSpecificPlayerApi();

    
    /**
     * Get a list of the achievements of one specific player
     *
     * Get a list of the achievements of one specific player 
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void seeAchivementsFromSpecificPlayerTest() throws ApiException {
        Integer idEntity = null;
        Integer idPlayer = null;
        List<Players> response = api.seeAchivementsFromSpecificPlayer(idEntity, idPlayer);

        // TODO: test validations
    }
    
}
