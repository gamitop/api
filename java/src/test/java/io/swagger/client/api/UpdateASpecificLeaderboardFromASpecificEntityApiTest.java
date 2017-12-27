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
 * API tests for UpdateASpecificLeaderboardFromASpecificEntityApi
 */
@Ignore
public class UpdateASpecificLeaderboardFromASpecificEntityApiTest {

    private final UpdateASpecificLeaderboardFromASpecificEntityApi api = new UpdateASpecificLeaderboardFromASpecificEntityApi();

    
    /**
     * update leaderboard
     *
     * Update info from a leaderboard
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void updateLeaderboardTest() throws ApiException {
        Entity updateLeaderboard = null;
        api.updateLeaderboard(updateLeaderboard);

        // TODO: test validations
    }
    
}
