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
 * API tests for DeleteASpecificLeaderboardFromASpecificEntityApi
 */
@Ignore
public class DeleteASpecificLeaderboardFromASpecificEntityApiTest {

    private final DeleteASpecificLeaderboardFromASpecificEntityApi api = new DeleteASpecificLeaderboardFromASpecificEntityApi();

    
    /**
     * delete leaderboard
     *
     * Delete a leaderboard
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void deleteLeaderboardTest() throws ApiException {
        Entity deleteLeaderboard = null;
        api.deleteLeaderboard(deleteLeaderboard);

        // TODO: test validations
    }
    
}
