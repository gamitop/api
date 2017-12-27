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
 * API tests for GetLeaderboardFromASpecificEntityApi
 */
@Ignore
public class GetLeaderboardFromASpecificEntityApiTest {

    private final GetLeaderboardFromASpecificEntityApi api = new GetLeaderboardFromASpecificEntityApi();

    
    /**
     * Get leaderboard from a specific entity
     *
     * Get leaderboard from a specific entity 
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void seeLeaderboardsFromSepcifficEntityTest() throws ApiException {
        Integer idEntity = null;
        List<Entity> response = api.seeLeaderboardsFromSepcifficEntity(idEntity);

        // TODO: test validations
    }
    
}
