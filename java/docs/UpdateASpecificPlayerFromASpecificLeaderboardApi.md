# UpdateASpecificPlayerFromASpecificLeaderboardApi

All URIs are relative to *https://virtserver.swaggerhub.com/gamitop/api/1.0.0*

Method | HTTP request | Description
------------- | ------------- | -------------
[**updatePayer**](UpdateASpecificPlayerFromASpecificLeaderboardApi.md#updatePayer) | **PUT** /entity/{id_entity}/leaderboards/{id_leaderboard}/players/{id_player} | update player


<a name="updatePayer"></a>
# **updatePayer**
> updatePayer(updatePlayer)

update player

Update info from a player

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.UpdateASpecificPlayerFromASpecificLeaderboardApi;


UpdateASpecificPlayerFromASpecificLeaderboardApi apiInstance = new UpdateASpecificPlayerFromASpecificLeaderboardApi();
Leaderboard updatePlayer = new Leaderboard(); // Leaderboard | Update Player
try {
    apiInstance.updatePayer(updatePlayer);
} catch (ApiException e) {
    System.err.println("Exception when calling UpdateASpecificPlayerFromASpecificLeaderboardApi#updatePayer");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **updatePlayer** | [**Leaderboard**](Leaderboard.md)| Update Player | [optional]

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json, text/xml
 - **Accept**: application/json, text/xml

