package com.TestDevLab.step_definitions;

import com.TestDevLab.utils.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Before;

import java.util.concurrent.TimeUnit;

public class Hook {
    @Before
    public void setup() {
        Driver.setUpDriver();
        Driver.getDriver().manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }

    @After
    public void teardown() {
        Driver.closeDriver();
    }
}
