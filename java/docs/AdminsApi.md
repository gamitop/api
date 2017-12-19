# AdminsApi

All URIs are relative to *https://virtserver.swaggerhub.com/gamitop/api/1.0.0*

Method | HTTP request | Description
------------- | ------------- | -------------
[**addInventory**](AdminsApi.md#addInventory) | **POST** /entity | add an inventory item


<a name="addInventory"></a>
# **addInventory**
> addInventory(newEntity)

add an inventory item

Adds an item to the system

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.AdminsApi;


AdminsApi apiInstance = new AdminsApi();
Entity newEntity = new Entity(); // Entity | Add new Entity
try {
    apiInstance.addInventory(newEntity);
} catch (ApiException e) {
    System.err.println("Exception when calling AdminsApi#addInventory");
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

