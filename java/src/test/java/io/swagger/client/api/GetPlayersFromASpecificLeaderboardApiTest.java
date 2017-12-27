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
 * API tests for GetPlayersFromASpecificLeaderboardApi
 */
@Ignore
public class GetPlayersFromASpecificLeaderboardApiTest {

    private final GetPlayersFromASpecificLeaderboardApi api = new GetPlayersFromASpecificLeaderboardApi();

    
    /**
     * Get players from a specific leaderboard
     *
     * Get players from a specific leaderboard 
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void seePlayersFromSpecificLeaderboardTest() throws ApiException {
        Integer idEntity = null;
        Integer idLeaderboard = null;
        List<Leaderboard> response = api.seePlayersFromSpecificLeaderboard(idEntity, idLeaderboard);

        // TODO: test validations
    }
    
}
