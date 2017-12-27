# AddAchivementToASpecificPlayerApi

All URIs are relative to *https://virtserver.swaggerhub.com/gamitop/api/1.0.0*

Method | HTTP request | Description
------------- | ------------- | -------------
[**addAchivementToPlayer**](AddAchivementToASpecificPlayerApi.md#addAchivementToPlayer) | **POST** /entity/{id_entity}/achievements/players/{id_player} | add achivemente to a specific player


<a name="addAchivementToPlayer"></a>
# **addAchivementToPlayer**
> addAchivementToPlayer(newAchivementToPlayer)

add achivemente to a specific player

Add achivements to one player

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.AddAchivementToASpecificPlayerApi;


AddAchivementToASpecificPlayerApi apiInstance = new AddAchivementToASpecificPlayerApi();
Players newAchivementToPlayer = new Players(); // Players | Add Achivement to Player
try {
    apiInstance.addAchivementToPlayer(newAchivementToPlayer);
} catch (ApiException e) {
    System.err.println("Exception when calling AddAchivementToASpecificPlayerApi#addAchivementToPlayer");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **newAchivementToPlayer** | [**Players**](Players.md)| Add Achivement to Player | [optional]

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json, application/xml
 - **Accept**: application/json, text/xml

