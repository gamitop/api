# GetAListOfAchievementsOfOneEntityApi

All URIs are relative to *https://virtserver.swaggerhub.com/gamitop/api/1.0.0*

Method | HTTP request | Description
------------- | ------------- | -------------
[**seeAchivementsFromSpecificEntity**](GetAListOfAchievementsOfOneEntityApi.md#seeAchivementsFromSpecificEntity) | **GET** /entity/{id_entity}/achievements | Get a list of achievements of one entity


<a name="seeAchivementsFromSpecificEntity"></a>
# **seeAchivementsFromSpecificEntity**
> List&lt;Entity&gt; seeAchivementsFromSpecificEntity(idEntity)

Get a list of achievements of one entity

Get a list of achievements of one entity 

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.GetAListOfAchievementsOfOneEntityApi;


GetAListOfAchievementsOfOneEntityApi apiInstance = new GetAListOfAchievementsOfOneEntityApi();
Integer idEntity = 56; // Integer | Id of entity
try {
    List<Entity> result = apiInstance.seeAchivementsFromSpecificEntity(idEntity);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling GetAListOfAchievementsOfOneEntityApi#seeAchivementsFromSpecificEntity");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **idEntity** | **Integer**| Id of entity |

### Return type

[**List&lt;Entity&gt;**](Entity.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json, text/xml
 - **Accept**: application/json, text/xml

