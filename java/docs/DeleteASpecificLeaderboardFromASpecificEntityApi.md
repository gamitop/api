# DeleteASpecificLeaderboardFromASpecificEntityApi

All URIs are relative to *https://virtserver.swaggerhub.com/gamitop/api/1.0.0*

Method | HTTP request | Description
------------- | ------------- | -------------
[**deleteLeaderboard**](DeleteASpecificLeaderboardFromASpecificEntityApi.md#deleteLeaderboard) | **DELETE** /entity/{id_entity}/leaderboards/{id_leaderboard} | delete leaderboard


<a name="deleteLeaderboard"></a>
# **deleteLeaderboard**
> deleteLeaderboard(deleteLeaderboard)

delete leaderboard

Delete a leaderboard

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.DeleteASpecificLeaderboardFromASpecificEntityApi;


DeleteASpecificLeaderboardFromASpecificEntityApi apiInstance = new DeleteASpecificLeaderboardFromASpecificEntityApi();
Entity deleteLeaderboard = new Entity(); // Entity | Delete Leaderboard
try {
    apiInstance.deleteLeaderboard(deleteLeaderboard);
} catch (ApiException e) {
    System.err.println("Exception when calling DeleteASpecificLeaderboardFromASpecificEntityApi#deleteLeaderboard");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **deleteLeaderboard** | [**Entity**](Entity.md)| Delete Leaderboard | [optional]

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json, text/xml
 - **Accept**: application/json, text/xml

