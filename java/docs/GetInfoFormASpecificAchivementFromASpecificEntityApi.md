# GetInfoFormASpecificAchivementFromASpecificEntityApi

All URIs are relative to *https://virtserver.swaggerhub.com/gamitop/api/1.0.0*

Method | HTTP request | Description
------------- | ------------- | -------------
[**searchSpecificAchivement**](GetInfoFormASpecificAchivementFromASpecificEntityApi.md#searchSpecificAchivement) | **GET** /entity/{id_entity}/achievements/{name} | 
[**searchSpecificAchivement22**](GetInfoFormASpecificAchivementFromASpecificEntityApi.md#searchSpecificAchivement22) | **GET** /entity/{id_entity}/achievements/{achievements}/players/{id_player} | 


<a name="searchSpecificAchivement"></a>
# **searchSpecificAchivement**
> List&lt;Entity&gt; searchSpecificAchivement(idEntity, name)



Get info form a specific achivement from a specific entity 

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.GetInfoFormASpecificAchivementFromASpecificEntityApi;


GetInfoFormASpecificAchivementFromASpecificEntityApi apiInstance = new GetInfoFormASpecificAchivementFromASpecificEntityApi();
Integer idEntity = 56; // Integer | Id of entity
Integer name = 56; // Integer | Id of leaderboard
try {
    List<Entity> result = apiInstance.searchSpecificAchivement(idEntity, name);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling GetInfoFormASpecificAchivementFromASpecificEntityApi#searchSpecificAchivement");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **idEntity** | **Integer**| Id of entity |
 **name** | **Integer**| Id of leaderboard |

### Return type

[**List&lt;Entity&gt;**](Entity.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json, text/xml
 - **Accept**: application/json, text/xml

<a name="searchSpecificAchivement22"></a>
# **searchSpecificAchivement22**
> List&lt;Entity&gt; searchSpecificAchivement22(idEntity, idPlayer, achievements)



Get info form a specific achivement from a specific entity 

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.GetInfoFormASpecificAchivementFromASpecificEntityApi;


GetInfoFormASpecificAchivementFromASpecificEntityApi apiInstance = new GetInfoFormASpecificAchivementFromASpecificEntityApi();
Integer idEntity = 56; // Integer | Id of entity
Integer idPlayer = 56; // Integer | Id of leaderboard
Integer achievements = 56; // Integer | Id of leaderboard
try {
    List<Entity> result = apiInstance.searchSpecificAchivement22(idEntity, idPlayer, achievements);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling GetInfoFormASpecificAchivementFromASpecificEntityApi#searchSpecificAchivement22");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **idEntity** | **Integer**| Id of entity |
 **idPlayer** | **Integer**| Id of leaderboard |
 **achievements** | **Integer**| Id of leaderboard |

### Return type

[**List&lt;Entity&gt;**](Entity.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json, text/xml
 - **Accept**: application/json, text/xml

