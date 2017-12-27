# UpdateASpecificLeaderboardFromASpecificEntityApi

All URIs are relative to *https://virtserver.swaggerhub.com/gamitop/api/1.0.0*

Method | HTTP request | Description
------------- | ------------- | -------------
[**updateLeaderboard**](UpdateASpecificLeaderboardFromASpecificEntityApi.md#updateLeaderboard) | **PUT** /entity/{id_entity}/leaderboards/{id_leaderboard} | update leaderboard


<a name="updateLeaderboard"></a>
# **updateLeaderboard**
> updateLeaderboard(updateLeaderboard)

update leaderboard

Update info from a leaderboard

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.UpdateASpecificLeaderboardFromASpecificEntityApi;


UpdateASpecificLeaderboardFromASpecificEntityApi apiInstance = new UpdateASpecificLeaderboardFromASpecificEntityApi();
Entity updateLeaderboard = new Entity(); // Entity | Update Leaderboard
try {
    apiInstance.updateLeaderboard(updateLeaderboard);
} catch (ApiException e) {
    System.err.println("Exception when calling UpdateASpecificLeaderboardFromASpecificEntityApi#updateLeaderboard");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **updateLeaderboard** | [**Entity**](Entity.md)| Update Leaderboard | [optional]

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json, text/xml
 - **Accept**: application/json, text/xml

