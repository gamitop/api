# AddEntityApi

All URIs are relative to *https://virtserver.swaggerhub.com/gamitop/api/1.0.0*

Method | HTTP request | Description
------------- | ------------- | -------------
[**addEntity**](AddEntityApi.md#addEntity) | **POST** /entity | add entities


<a name="addEntity"></a>
# **addEntity**
> addEntity(newEntity)

add entities

Add entities(users) to the system

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.AddEntityApi;


AddEntityApi apiInstance = new AddEntityApi();
Entity newEntity = new Entity(); // Entity | Add new Entity
try {
    apiInstance.addEntity(newEntity);
} catch (ApiException e) {
    System.err.println("Exception when calling AddEntityApi#addEntity");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **newEntity** | [**Entity**](Entity.md)| Add new Entity | [optional]

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json, application/xml
 - **Accept**: application/json, text/xml

