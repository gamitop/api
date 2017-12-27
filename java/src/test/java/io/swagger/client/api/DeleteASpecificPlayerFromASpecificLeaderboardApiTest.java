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
 * API tests for DeleteASpecificPlayerFromASpecificLeaderboardApi
 */
@Ignore
public class DeleteASpecificPlayerFromASpecificLeaderboardApiTest {

    private final DeleteASpecificPlayerFromASpecificLeaderboardApi api = new DeleteASpecificPlayerFromASpecificLeaderboardApi();

    
    /**
     * delete player
     *
     * Delete a player
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void deletePlayerTest() throws ApiException {
        Leaderboard deletePlayer = null;
        api.deletePlayer(deletePlayer);

        // TODO: test validations
    }
    
}
