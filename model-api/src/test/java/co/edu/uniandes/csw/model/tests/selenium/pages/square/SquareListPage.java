/*
The MIT License (MIT)

Copyright (c) 2015 Los Andes University

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
*/
package co.edu.uniandes.csw.model.tests.selenium.pages.square;

import static org.jboss.arquillian.graphene.Graphene.waitGui;
import org.jboss.arquillian.drone.api.annotation.Drone;
import static org.jboss.arquillian.graphene.Graphene.guardAjax;
import org.jboss.arquillian.graphene.page.Location;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Location("#/squares/list")
public class SquareListPage {

    @Drone
    private WebDriver browser;

    @FindBy(id = "create-square")
    private WebElement createBtn;

    @FindBy(id = "refresh-square")
    private WebElement refreshBtn;

    private String findNameByIndex(Integer index) {
        return browser.findElement(By.id(index + "-name")).getText();
    }

    private WebElement findDetailsBtnByIndex(Integer index) {
        By selector = By.id(index + "-detail-btn");
        waitGui().until().element(selector).is().visible();
        return browser.findElement(selector);
    }

    private WebElement findEditBtnByIndex(Integer index) {
        By selector = By.id(index + "-edit-btn");
        waitGui().until().element(selector).is().visible();
        return browser.findElement(selector);
    }

    private WebElement findDeleteBtnByIndex(Integer index) {
        By selector = By.id(index + "-delete-btn");
        waitGui().until().element(selector).is().visible();
        return browser.findElement(selector);
    }

    public void editSquare(Integer index) {
        WebElement editButton = findEditBtnByIndex(index);
        editButton.click();
    }

    public void deleteSquare(Integer index) {
        WebElement deleteButton = findDeleteBtnByIndex(index);
        deleteButton.click();
    }

    public void viewSquareDetails(Integer index) {
        WebElement detailsButton = findDetailsBtnByIndex(index);
        detailsButton.click();
    }

    public void refresh() {
        waitGui().until().element(createBtn).is().visible();
        guardAjax(refreshBtn).click();
    }

    public void create() {
        waitGui().until().element(createBtn).is().visible();
        createBtn.click();
    }

    public Integer countSquares() {
        return browser.findElements(By.cssSelector("tbody > tr")).size();
    }
}
