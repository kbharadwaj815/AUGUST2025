package com.orangehrm.stepdefenation;


import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
 
@RunWith(Cucumber.class)
@CucumberOptions(features="C:\\Users\\kesha\\eclipse-workspace\\CGI_AUG2025\\src\\test\\resources\\Features"
,glue= {"com.orangehrm.stepdefenation"}
,tags="@smaoke"
,dryRun=false
,monochrome=true)

public class TestRunner {

}
