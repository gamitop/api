

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


import io.swagger.client.model.Entity;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AdminsApi {
    private ApiClient apiClient;

    public AdminsApi() {
        this(Configuration.getDefaultApiClient());
    }

    public AdminsApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    /**
     * Build call for addInventory
     * @param newEntity Add new Entity (optional)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call addInventoryCall(Entity newEntity, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = newEntity;

        // create path and map variables
        String localVarPath = "/entity";

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
        return apiClient.buildCall(localVarPath, "POST", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }

    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call addInventoryValidateBeforeCall(Entity newEntity, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        

        com.squareup.okhttp.Call call = addInventoryCall(newEntity, progressListener, progressRequestListener);
        return call;

    }

    /**
     * add an inventory item
     * Adds an item to the system
     * @param newEntity Add new Entity (optional)
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public void addInventory(Entity newEntity) throws ApiException {
        addInventoryWithHttpInfo(newEntity);
    }

    /**
     * add an inventory item
     * Adds an item to the system
     * @param newEntity Add new Entity (optional)
     * @return ApiResponse&lt;Void&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<Void> addInventoryWithHttpInfo(Entity newEntity) throws ApiException {
        com.squareup.okhttp.Call call = addInventoryValidateBeforeCall(newEntity, null, null);
        return apiClient.execute(call);
    }

    /**
     * add an inventory item (asynchronously)
     * Adds an item to the system
     * @param newEntity Add new Entity (optional)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call addInventoryAsync(Entity newEntity, final ApiCallback<Void> callback) throws ApiException {

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

        com.squareup.okhttp.Call call = addInventoryValidateBeforeCall(newEntity, progressListener, progressRequestListener);
        apiClient.executeAsync(call, callback);
        return call;
    }
}