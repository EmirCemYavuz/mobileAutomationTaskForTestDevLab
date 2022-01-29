package com.TestDevLab.step_definitions;

import com.TestDevLab.pages.TestDevLabAppPage;
import com.TestDevLab.steps.TestDevLabSteps;
import com.TestDevLab.utils.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

import java.util.List;

public class TestDevLabStepDef extends TestDevLabSteps {

    @Given("The user clicks Part {int}")
    public void theUserClicksPart(int arg0) {
        waitUntilElementClickable(TestDevLabAppPage.part4Button);
        click(TestDevLabAppPage.part4Button);
    }

    @And("The user selects all checkboxes in first section")
    public void theUserSelectsAllCheckboxesInFirstSection() {
        waitUntilElementClickable(TestDevLabAppPage.allCheckBoxes1);
        click(TestDevLabAppPage.allCheckBoxes1);
        waitUntilElementClickable(TestDevLabAppPage.allCheckBoxes2);
        click(TestDevLabAppPage.allCheckBoxes2);
        waitUntilElementClickable(TestDevLabAppPage.allCheckBoxes3);
        click(TestDevLabAppPage.allCheckBoxes3);
        waitUntilElementClickable(TestDevLabAppPage.allCheckBoxes4);
        click(TestDevLabAppPage.allCheckBoxes4);
        waitUntilElementClickable(TestDevLabAppPage.allCheckBoxes5);
        click(TestDevLabAppPage.allCheckBoxes5);
    }


    @And("The user selects correct checkboxes in second section")
    public void theUserSelectsCorrectCheckboxesInSecondSection() {
        String header = Driver.getDriver().findElement(TestDevLabAppPage.headerForSection2).getText();
        char itemNumber = header.charAt(header.length() - 1);
        if (Driver.getDriver().findElement(TestDevLabAppPage.headerForSection2).getText().contains("preceeding siblings")) {
            if (itemNumber == '2') {
                waitUntilElementClickable(TestDevLabAppPage.section2CheckBox1);
                click(TestDevLabAppPage.section2CheckBox1);
            } else if (itemNumber == '3') {
                waitUntilElementClickable(TestDevLabAppPage.section2CheckBox1);
                click(TestDevLabAppPage.section2CheckBox1);
                waitUntilElementClickable(TestDevLabAppPage.section2CheckBox2);
                click(TestDevLabAppPage.section2CheckBox2);
            } else if (itemNumber == '4') {
                waitUntilElementClickable(TestDevLabAppPage.section2CheckBox1);
                click(TestDevLabAppPage.section2CheckBox1);
                waitUntilElementClickable(TestDevLabAppPage.section2CheckBox2);
                click(TestDevLabAppPage.section2CheckBox2);
                waitUntilElementClickable(TestDevLabAppPage.section2CheckBox3);
                click(TestDevLabAppPage.section2CheckBox3);
            } else if (itemNumber == '5') {
                waitUntilElementClickable(TestDevLabAppPage.section2CheckBox1);
                click(TestDevLabAppPage.section2CheckBox1);
                waitUntilElementClickable(TestDevLabAppPage.section2CheckBox2);
                click(TestDevLabAppPage.section2CheckBox2);
                waitUntilElementClickable(TestDevLabAppPage.section2CheckBox3);
                click(TestDevLabAppPage.section2CheckBox3);
                waitUntilElementClickable(TestDevLabAppPage.section2CheckBox4);
                click(TestDevLabAppPage.section2CheckBox4);
            }

        } else {
            if (itemNumber == '1') {
                waitUntilElementClickable(TestDevLabAppPage.section2CheckBox2);
                click(TestDevLabAppPage.section2CheckBox2);
                waitUntilElementClickable(TestDevLabAppPage.section2CheckBox3);
                click(TestDevLabAppPage.section2CheckBox3);
                waitUntilElementClickable(TestDevLabAppPage.section2CheckBox4);
                click(TestDevLabAppPage.section2CheckBox4);
                waitUntilElementClickable(TestDevLabAppPage.section2CheckBox5);
                click(TestDevLabAppPage.section2CheckBox5);
            } else if (itemNumber == '2') {
                waitUntilElementClickable(TestDevLabAppPage.section2CheckBox3);
                click(TestDevLabAppPage.section2CheckBox3);
                waitUntilElementClickable(TestDevLabAppPage.section2CheckBox4);
                click(TestDevLabAppPage.section2CheckBox4);
                waitUntilElementClickable(TestDevLabAppPage.section2CheckBox5);
                click(TestDevLabAppPage.section2CheckBox5);
            } else if (itemNumber == '3') {
                waitUntilElementClickable(TestDevLabAppPage.section2CheckBox4);
                click(TestDevLabAppPage.section2CheckBox4);
                waitUntilElementClickable(TestDevLabAppPage.section2CheckBox5);
                click(TestDevLabAppPage.section2CheckBox5);
            } else if (itemNumber == '4') {
                waitUntilElementClickable(TestDevLabAppPage.section2CheckBox5);
                click(TestDevLabAppPage.section2CheckBox5);
            }
        }
    }

    @And("The user slides down to get in third section")
    public void theUserSlidesDownToGetInThirdSection() {
        slide("up");
    }

    @And("The user selects correct checkboxes in third section")
    public void theUserSelectsCorrectCheckboxesInThirdSection() {
        String text1=Driver.getDriver().findElement(TestDevLabAppPage.textUnderBox1).getText();
        String text2=Driver.getDriver().findElement(TestDevLabAppPage.textUnderBox2).getText();
        String text3=Driver.getDriver().findElement(TestDevLabAppPage.textUnderBox3).getText();
        if (text1.equals("yes")){
            waitUntilElementClickable(TestDevLabAppPage.section3CheckBox1);
            click(TestDevLabAppPage.section3CheckBox1);
        }
        if (text2.equals("yes")){
            waitUntilElementClickable(TestDevLabAppPage.section3CheckBox2);
            click(TestDevLabAppPage.section3CheckBox2);
        }
        if (text3.equals("yes")){
            waitUntilElementClickable(TestDevLabAppPage.section3CheckBox3);
            click(TestDevLabAppPage.section3CheckBox3);
        }
    }

    @And("The user clicks Submit button")
    public void theUserClicksSubmitButton() {
        waitUntilElementClickable(TestDevLabAppPage.submitButton);
        click(TestDevLabAppPage.submitButton);
    }

    @Then("The user should see Success messages for all sections")
    public void theUserShouldSeeSuccessMessagesForAllSections() {
        List<WebElement>resultMessages= Driver.getDriver().findElements(TestDevLabAppPage.successMessages);
        for (int i = 0; i < resultMessages.size(); i++) {
            if (resultMessages.get(i).getText().contains("Success")){
                assert true;
            }
        }
    }
}
