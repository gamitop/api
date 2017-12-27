

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


import io.swagger.client.model.Leaderboard;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GetPlayersFromASpecificLeaderboardApi {
    private ApiClient apiClient;

    public GetPlayersFromASpecificLeaderboardApi() {
        this(Configuration.getDefaultApiClient());
    }

    public GetPlayersFromASpecificLeaderboardApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    /**
     * Build call for seePlayersFromSpecificLeaderboard
     * @param idEntity Id of entity (required)
     * @param idLeaderboard Id of leaderboard (required)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call seePlayersFromSpecificLeaderboardCall(Integer idEntity, Integer idLeaderboard, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/entity/{id_entity}/leaderboards/{id_leaderboard}/players"
            .replaceAll("\\{" + "id_entity" + "\\}", apiClient.escapeString(idEntity.toString()))
            .replaceAll("\\{" + "id_leaderboard" + "\\}", apiClient.escapeString(idLeaderboard.toString()));

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
    private com.squareup.okhttp.Call seePlayersFromSpecificLeaderboardValidateBeforeCall(Integer idEntity, Integer idLeaderboard, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        // verify the required parameter 'idEntity' is set
        if (idEntity == null) {
            throw new ApiException("Missing the required parameter 'idEntity' when calling seePlayersFromSpecificLeaderboard(Async)");
        }
        
        // verify the required parameter 'idLeaderboard' is set
        if (idLeaderboard == null) {
            throw new ApiException("Missing the required parameter 'idLeaderboard' when calling seePlayersFromSpecificLeaderboard(Async)");
        }
        

        com.squareup.okhttp.Call call = seePlayersFromSpecificLeaderboardCall(idEntity, idLeaderboard, progressListener, progressRequestListener);
        return call;

    }

    /**
     * Get players from a specific leaderboard
     * Get players from a specific leaderboard 
     * @param idEntity Id of entity (required)
     * @param idLeaderboard Id of leaderboard (required)
     * @return List&lt;Leaderboard&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public List<Leaderboard> seePlayersFromSpecificLeaderboard(Integer idEntity, Integer idLeaderboard) throws ApiException {
        ApiResponse<List<Leaderboard>> resp = seePlayersFromSpecificLeaderboardWithHttpInfo(idEntity, idLeaderboard);
        return resp.getData();
    }

    /**
     * Get players from a specific leaderboard
     * Get players from a specific leaderboard 
     * @param idEntity Id of entity (required)
     * @param idLeaderboard Id of leaderboard (required)
     * @return ApiResponse&lt;List&lt;Leaderboard&gt;&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<List<Leaderboard>> seePlayersFromSpecificLeaderboardWithHttpInfo(Integer idEntity, Integer idLeaderboard) throws ApiException {
        com.squareup.okhttp.Call call = seePlayersFromSpecificLeaderboardValidateBeforeCall(idEntity, idLeaderboard, null, null);
        Type localVarReturnType = new TypeToken<List<Leaderboard>>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Get players from a specific leaderboard (asynchronously)
     * Get players from a specific leaderboard 
     * @param idEntity Id of entity (required)
     * @param idLeaderboard Id of leaderboard (required)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call seePlayersFromSpecificLeaderboardAsync(Integer idEntity, Integer idLeaderboard, final ApiCallback<List<Leaderboard>> callback) throws ApiException {

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

        com.squareup.okhttp.Call call = seePlayersFromSpecificLeaderboardValidateBeforeCall(idEntity, idLeaderboard, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<List<Leaderboard>>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
}
