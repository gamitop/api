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
 * API tests for GetInfoFormASpecificLeaderboardFromASpecificEntityApi
 */
@Ignore
public class GetInfoFormASpecificLeaderboardFromASpecificEntityApiTest {

    private final GetInfoFormASpecificLeaderboardFromASpecificEntityApi api = new GetInfoFormASpecificLeaderboardFromASpecificEntityApi();

    
    /**
     * Get info form a specific leaderboard from a specific entity
     *
     * Get info form a specific leaderboard from a specific entity 
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void searchSpecificLeaderboardTest() throws ApiException {
        Integer idEntity = null;
        Integer idLeaderboard = null;
        List<Entity> response = api.searchSpecificLeaderboard(idEntity, idLeaderboard);

        // TODO: test validations
    }
    
}
