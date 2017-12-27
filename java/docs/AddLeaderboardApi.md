# AddLeaderboardApi

All URIs are relative to *https://virtserver.swaggerhub.com/gamitop/api/1.0.0*

Method | HTTP request | Description
------------- | ------------- | -------------
[**addLeaderboard**](AddLeaderboardApi.md#addLeaderboard) | **POST** /entity/{id_entity}/leaderboards | add leaderboard


<a name="addLeaderboard"></a>
# **addLeaderboard**
> addLeaderboard(newLeaderboard)

add leaderboard

Add leaderboards to entities

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.AddLeaderboardApi;


AddLeaderboardApi apiInstance = new AddLeaderboardApi();
Entity newLeaderboard = new Entity(); // Entity | Add new Leaderboard
try {
    apiInstance.addLeaderboard(newLeaderboard);
} catch (ApiException e) {
    System.err.println("Exception when calling AddLeaderboardApi#addLeaderboard");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **newLeaderboard** | [**Entity**](Entity.md)| Add new Leaderboard | [optional]

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json, application/xml
 - **Accept**: application/json, text/xml

