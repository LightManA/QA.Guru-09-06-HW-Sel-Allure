package com.github.LightManA;

import com.github.LightManA.Steps.WebSteps;
import org.junit.jupiter.api.Test;

public class L06Sel_Allure_StepAnnotatedExample {

    private static final String REPOSITORY = "LightManA/QAGuru-09-GitTrain";
    private static final Integer ISSUE_NUMBER = 2;

    private WebSteps steps = new WebSteps();

    @Test
    public void testingGithub() {
        steps.openMainPage();
        steps.searchForRepository(REPOSITORY);
        steps.goToRepository(REPOSITORY);
        steps.openIssueTab();
        steps.shouldSeeIssueWithNumber(ISSUE_NUMBER);

    }

}
