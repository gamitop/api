# AddAchivementToASpecificEntityApi

All URIs are relative to *https://virtserver.swaggerhub.com/gamitop/api/1.0.0*

Method | HTTP request | Description
------------- | ------------- | -------------
[**addAchivement**](AddAchivementToASpecificEntityApi.md#addAchivement) | **POST** /entity/{id_entity}/achievements | add achivement to a specific entity


<a name="addAchivement"></a>
# **addAchivement**
> addAchivement(newAchivement)

add achivement to a specific entity

Add achivements to one entity

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.AddAchivementToASpecificEntityApi;


AddAchivementToASpecificEntityApi apiInstance = new AddAchivementToASpecificEntityApi();
Entity newAchivement = new Entity(); // Entity | Add new Achivement
try {
    apiInstance.addAchivement(newAchivement);
} catch (ApiException e) {
    System.err.println("Exception when calling AddAchivementToASpecificEntityApi#addAchivement");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **newAchivement** | [**Entity**](Entity.md)| Add new Achivement | [optional]

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json, application/xml
 - **Accept**: application/json, text/xml

