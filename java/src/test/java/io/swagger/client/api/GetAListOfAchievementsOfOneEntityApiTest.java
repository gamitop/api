package io.swagger.client.api;

import io.swagger.client.ApiException;
import io.swagger.client.model.Entity;
import org.junit.Test;
import org.junit.Ignore;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * API tests for GetAListOfAchievementsOfOneEntityApi
 */
@Ignore
public class GetAListOfAchievementsOfOneEntityApiTest {

    private final GetAListOfAchievementsOfOneEntityApi api = new GetAListOfAchievementsOfOneEntityApi();

    
    /**
     * Get a list of achievements of one entity
     *
     * Get a list of achievements of one entity 
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void seeAchivementsFromSpecificEntityTest() throws ApiException {
        Integer idEntity = null;
        List<Entity> response = api.seeAchivementsFromSpecificEntity(idEntity);

        // TODO: test validations
    }
    
}
