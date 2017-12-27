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
 * API tests for AddLeaderboardApi
 */
@Ignore
public class AddLeaderboardApiTest {

    private final AddLeaderboardApi api = new AddLeaderboardApi();

    
    /**
     * add leaderboard
     *
     * Add leaderboards to entities
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void addLeaderboardTest() throws ApiException {
        Entity newLeaderboard = null;
        api.addLeaderboard(newLeaderboard);

        // TODO: test validations
    }
    
}
