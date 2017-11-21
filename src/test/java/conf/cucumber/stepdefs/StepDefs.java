package conf.cucumber.stepdefs;

import conf.ConfApp;

import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.ResultActions;

import org.springframework.boot.test.context.SpringBootTest;

@WebAppConfiguration
@SpringBootTest
@ContextConfiguration(classes = ConfApp.class)
public abstract class StepDefs {

    protected ResultActions actions;

}
