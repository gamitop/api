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
 * API tests for UpdateASpecificPlayerFromASpecificLeaderboardApi
 */
@Ignore
public class UpdateASpecificPlayerFromASpecificLeaderboardApiTest {

    private final UpdateASpecificPlayerFromASpecificLeaderboardApi api = new UpdateASpecificPlayerFromASpecificLeaderboardApi();

    
    /**
     * update player
     *
     * Update info from a player
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void updatePayerTest() throws ApiException {
        Leaderboard updatePlayer = null;
        api.updatePayer(updatePlayer);

        // TODO: test validations
    }
    
}
