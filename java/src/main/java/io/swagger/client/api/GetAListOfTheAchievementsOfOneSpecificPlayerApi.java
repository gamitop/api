

package io.swagger.client.api;

import io.swagger.client.ApiCallback;
import io.swagger.client.ApiClient;
import io.swagger.client.ApiException;
import io.swagger.client.ApiResponse;
import io.swagger.client.Configuration;
import io.swagger.client.Pair;
import io.swagger.client.ProgressRequestBody;
import io.swagger.client.ProgressResponseBody;

import com.google.gson.reflect.TypeToken;

import java.io.IOException;


import io.swagger.client.model.Players;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GetAListOfTheAchievementsOfOneSpecificPlayerApi {
    private ApiClient apiClient;

    public GetAListOfTheAchievementsOfOneSpecificPlayerApi() {
        this(Configuration.getDefaultApiClient());
    }

    public GetAListOfTheAchievementsOfOneSpecificPlayerApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    /**
     * Build call for seeAchivementsFromSpecificPlayer
     * @param idEntity Id of entity (required)
     * @param idPlayer Id of leaderboard (required)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call seeAchivementsFromSpecificPlayerCall(Integer idEntity, Integer idPlayer, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/entity/{id_entity}/achievements/players/{id_player}"
            .replaceAll("\\{" + "id_entity" + "\\}", apiClient.escapeString(idEntity.toString()))
            .replaceAll("\\{" + "id_player" + "\\}", apiClient.escapeString(idPlayer.toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();

        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        final String[] localVarAccepts = {
            "application/json", "text/xml"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            "application/json", "text/xml"
        };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        if(progressListener != null) {
            apiClient.getHttpClient().networkInterceptors().add(new com.squareup.okhttp.Interceptor() {
                @Override
                public com.squareup.okhttp.Response intercept(com.squareup.okhttp.Interceptor.Chain chain) throws IOException {
                    com.squareup.okhttp.Response originalResponse = chain.proceed(chain.request());
                    return originalResponse.newBuilder()
                    .body(new ProgressResponseBody(originalResponse.body(), progressListener))
                    .build();
                }
            });
        }

        String[] localVarAuthNames = new String[] {  };
        return apiClient.buildCall(localVarPath, "GET", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }

    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call seeAchivementsFromSpecificPlayerValidateBeforeCall(Integer idEntity, Integer idPlayer, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        // verify the required parameter 'idEntity' is set
        if (idEntity == null) {
            throw new ApiException("Missing the required parameter 'idEntity' when calling seeAchivementsFromSpecificPlayer(Async)");
        }
        
        // verify the required parameter 'idPlayer' is set
        if (idPlayer == null) {
            throw new ApiException("Missing the required parameter 'idPlayer' when calling seeAchivementsFromSpecificPlayer(Async)");
        }
        

        com.squareup.okhttp.Call call = seeAchivementsFromSpecificPlayerCall(idEntity, idPlayer, progressListener, progressRequestListener);
        return call;

    }

    /**
     * Get a list of the achievements of one specific player
     * Get a list of the achievements of one specific player 
     * @param idEntity Id of entity (required)
     * @param idPlayer Id of leaderboard (required)
     * @return List&lt;Players&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public List<Players> seeAchivementsFromSpecificPlayer(Integer idEntity, Integer idPlayer) throws ApiException {
        ApiResponse<List<Players>> resp = seeAchivementsFromSpecificPlayerWithHttpInfo(idEntity, idPlayer);
        return resp.getData();
    }

    /**
     * Get a list of the achievements of one specific player
     * Get a list of the achievements of one specific player 
     * @param idEntity Id of entity (required)
     * @param idPlayer Id of leaderboard (required)
     * @return ApiResponse&lt;List&lt;Players&gt;&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<List<Players>> seeAchivementsFromSpecificPlayerWithHttpInfo(Integer idEntity, Integer idPlayer) throws ApiException {
        com.squareup.okhttp.Call call = seeAchivementsFromSpecificPlayerValidateBeforeCall(idEntity, idPlayer, null, null);
        Type localVarReturnType = new TypeToken<List<Players>>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Get a list of the achievements of one specific player (asynchronously)
     * Get a list of the achievements of one specific player 
     * @param idEntity Id of entity (required)
     * @param idPlayer Id of leaderboard (required)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call seeAchivementsFromSpecificPlayerAsync(Integer idEntity, Integer idPlayer, final ApiCallback<List<Players>> callback) throws ApiException {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };

            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }

        com.squareup.okhttp.Call call = seeAchivementsFromSpecificPlayerValidateBeforeCall(idEntity, idPlayer, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<List<Players>>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
}
