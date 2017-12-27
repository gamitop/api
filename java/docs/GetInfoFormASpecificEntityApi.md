# GetInfoFormASpecificEntityApi

All URIs are relative to *https://virtserver.swaggerhub.com/gamitop/api/1.0.0*

Method | HTTP request | Description
------------- | ------------- | -------------
[**searchSpecificEntitie**](GetInfoFormASpecificEntityApi.md#searchSpecificEntitie) | **GET** /entity/{id_entity} | Get a info of one entity


<a name="searchSpecificEntitie"></a>
# **searchSpecificEntitie**
> List&lt;Entity&gt; searchSpecificEntitie(idEntity)

Get a info of one entity

Get info of one entity 

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.GetInfoFormASpecificEntityApi;


GetInfoFormASpecificEntityApi apiInstance = new GetInfoFormASpecificEntityApi();
Integer idEntity = 56; // Integer | Id of entity
try {
    List<Entity> result = apiInstance.searchSpecificEntitie(idEntity);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling GetInfoFormASpecificEntityApi#searchSpecificEntitie");
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

