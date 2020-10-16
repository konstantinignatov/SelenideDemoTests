package org.selenide.tests;

import com.codeborne.selenide.Configuration;
import org.junit.Test;

import static com.codeborne.selenide.Condition.name;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class OpenEpamPage {

    private String jobTitle;

    @Test
    public void simpleTest() {
        Configuration.startMaximized = true;
        open("https://www.google.com/");
        $$("input").findBy(name("q")).val("EPAM global");
        $(byName("btnK")).click();
        sleep(5000);
        $(byPartialLinkText("Enterprise Software Development")).click();
        sleep(3000);
        $(byClassName("location-selector__button")).click();
        sleep(1000);
        $(byPartialLinkText("Ukraine")).click();
        sleep(3000);
        $(byId("new_form_job_search-keyword")).sendKeys("A","u","t","o","m","a","t","i","o","n");
        sleep(1000);
        $(byClassName("autocomplete-suggestions")).click();
        sleep(1000);
        $(byAttribute("type","Submit")).click();
        sleep(3000);
        $(byClassName("search-result__item-apply")).click();
        jobTitle = $(byClassName("recruiting-page__header")).getText();
        System.out.println("Job title is " + jobTitle);
    }
}
