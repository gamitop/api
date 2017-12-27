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
 * API tests for AddPlayerApi
 */
@Ignore
public class AddPlayerApiTest {

    private final AddPlayerApi api = new AddPlayerApi();

    
    /**
     * add player
     *
     * Add players to leaderboards
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void addPlayerTest() throws ApiException {
        Leaderboard newPlayer = null;
        api.addPlayer(newPlayer);

        // TODO: test validations
    }
    
}
