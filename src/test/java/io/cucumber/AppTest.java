package io.cucumber;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Test;

/**
 * Unit test for simple App.
 */

class IsItFriday {
    static String isItFriday(String today) {
        if ("Friday".equals(today)){
            return "yes";
        } else {
            return "No";
        }
    }
}
public class AppTest {
    private String today;
    private String actualAnswer;
    /**
     * Rigorous Test :-)
     */
//    @Test
//    public void shouldAnswerWithTrue() {
//        assertTrue(true);
//    }
    @Given("today is Sunday")
    public void today_is_sunday() {
        // Write code here that turns the phrase above into concrete actions
        today = "Sunday";
        System.out.println("Today" + today);
    }
    @When("I ask whether it's Friday yet")
    public void i_ask_whether_it_s_friday_yet() {
        // Write code here that turns the phrase above into concrete actions
        actualAnswer = IsItFriday.isItFriday(today);
        System.out.println("22 "+ today + "  " + actualAnswer);
    }
    @Then("I should be told {string}")
    public void i_should_be_told(String exceptedAnswer) {
        // Write code here that turns the phrase above into concrete actions
        System.out.println("-->" + today + "  " + actualAnswer);
        assertEquals(exceptedAnswer,actualAnswer);
    }
}
