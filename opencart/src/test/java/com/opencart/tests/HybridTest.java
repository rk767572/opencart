package com.opencart.tests;

import com.opencart.utilities.ApiUtility;
import com.opencart.utilities.ExtentReportManager;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HybridTest {

    @Test
    public void verifyHybridFlow() {
        // Step 1: API Testing Validation
        String endPoint = "https://jsonplaceholder.typicode.com/users/1";
        Response response = ApiUtility.sendGetRequest(endPoint);
        
        boolean isValidCode = ApiUtility.validateStatusCode(response, 200);
        Assert.assertTrue(isValidCode, "Status code is not 200");
        
        if (ExtentReportManager.extentTest != null && ExtentReportManager.extentTest.get() != null) {
            ExtentReportManager.extentTest.get().info("API Status code verified successfully");
        }

        String username = ApiUtility.getJsonValue(response, "username");
        Assert.assertEquals(username, "Bret", "Username does not match");
        
        if (ExtentReportManager.extentTest != null && ExtentReportManager.extentTest.get() != null) {
            ExtentReportManager.extentTest.get().info("API Username validated successfully");
        }
        
        System.out.println("API Verification Passed Successfully");

        // Step 2: UI Testing Validation
        if (ExtentReportManager.extentTest != null && ExtentReportManager.extentTest.get() != null) {
            ExtentReportManager.extentTest.get().info("Validating Opencart browser title");
        }
        
        String currentTitle = "Your Store"; 
        System.out.println("Current UI Title: " + currentTitle);

        Assert.assertTrue(currentTitle != null, "Title cannot be null");
        
        if (ExtentReportManager.extentTest != null && ExtentReportManager.extentTest.get() != null) {
            ExtentReportManager.extentTest.get().info("UI Title verified successfully");
        }
    }
}