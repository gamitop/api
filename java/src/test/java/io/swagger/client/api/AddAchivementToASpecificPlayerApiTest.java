package io.swagger.client.api;

import io.swagger.client.ApiException;
import io.swagger.client.model.Players;
import org.junit.Test;
import org.junit.Ignore;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * API tests for AddAchivementToASpecificPlayerApi
 */
@Ignore
public class AddAchivementToASpecificPlayerApiTest {

    private final AddAchivementToASpecificPlayerApi api = new AddAchivementToASpecificPlayerApi();

    
    /**
     * add achivemente to a specific player
     *
     * Add achivements to one player
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void addAchivementToPlayerTest() throws ApiException {
        Players newAchivementToPlayer = null;
        api.addAchivementToPlayer(newAchivementToPlayer);

        // TODO: test validations
    }
    
}
