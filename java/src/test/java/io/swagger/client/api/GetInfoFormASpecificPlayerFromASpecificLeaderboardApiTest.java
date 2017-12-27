package io.swagger.client.api;

import io.swagger.client.ApiException;
import io.swagger.client.model.Leaderboard;
import org.junit.Test;
import org.junit.Ignore;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * API tests for GetInfoFormASpecificPlayerFromASpecificLeaderboardApi
 */
@Ignore
public class GetInfoFormASpecificPlayerFromASpecificLeaderboardApiTest {

    private final GetInfoFormASpecificPlayerFromASpecificLeaderboardApi api = new GetInfoFormASpecificPlayerFromASpecificLeaderboardApi();

    
    /**
     * 
     *
     * Get info form a specific player from a specific leaderboard 
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void searchSpecificPlayerTest() throws ApiException {
        Integer idEntity = null;
        Integer idLeaderboard = null;
        Integer idPlayer = null;
        List<Leaderboard> response = api.searchSpecificPlayer(idEntity, idLeaderboard, idPlayer);

        // TODO: test validations
    }
    
}
