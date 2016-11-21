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
package co.edu.uniandes.csw.model.tests.selenium;

import co.edu.uniandes.csw.model.dtos.minimum.ADTO;
import co.edu.uniandes.csw.model.resources.AResource;
import co.edu.uniandes.csw.model.tests.selenium.pages.a.ACreatePage;
import co.edu.uniandes.csw.model.tests.selenium.pages.a.AListPage;
import co.edu.uniandes.csw.model.tests.selenium.pages.LoginPage;
import co.edu.uniandes.csw.model.tests.selenium.pages.a.ADeletePage;
import co.edu.uniandes.csw.model.tests.selenium.pages.a.ADetailPage;
import co.edu.uniandes.csw.model.tests.selenium.pages.a.AEditPage;
import java.io.File;
import java.net.URL;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.drone.api.annotation.Drone;
import org.jboss.arquillian.graphene.page.InitialPage;
import org.jboss.arquillian.graphene.page.Page;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.arquillian.junit.InSequence;
import org.jboss.arquillian.test.api.ArquillianResource;
import org.jboss.shrinkwrap.api.GenericArchive;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.importer.ExplodedImporter;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.jboss.shrinkwrap.resolver.api.maven.Maven;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import uk.co.jemos.podam.api.PodamFactory;
import uk.co.jemos.podam.api.PodamFactoryImpl;

@RunWith(Arquillian.class)
public class AIT {

    private static PodamFactory factory = new PodamFactoryImpl();

    @ArquillianResource
    private URL deploymentURL;

    @Drone
    private WebDriver browser;

    @Page
    private ACreatePage createPage;

    @Page
    private ADetailPage detailPage;

    @Page
    private AEditPage editPage;

    @Page
    private ADeletePage deletePage;

    @Deployment(testable = false)
    public static WebArchive createDeployment() {
        return ShrinkWrap.create(WebArchive.class)
                // Se agrega las dependencias
                .addAsLibraries(Maven.resolver().loadPomFromFile("pom.xml")
                        .importRuntimeDependencies().resolve()
                        .withTransitivity().asFile())
                // Se agregan los compilados de los paquetes de servicios
                .addPackage(AResource.class.getPackage())
                // El archivo que contiene la configuracion a la base de datos.
                .addAsResource("META-INF/persistence.xml", "META-INF/persistence.xml")
                // El archivo beans.xml es necesario para injeccion de dependencias.
                .addAsWebInfResource(new File("src/main/webapp/WEB-INF/beans.xml"))
                // El archivo shiro.ini es necesario para injeccion de dependencias
                .addAsWebInfResource(new File("src/main/webapp/WEB-INF/shiro.ini"))
                // El archivo web.xml es necesario para el despliegue de los servlets
                .setWebXML(new File("src/main/webapp/WEB-INF/web.xml"))
                .merge(ShrinkWrap.create(GenericArchive.class).as(ExplodedImporter.class)
                        .importDirectory("src/main/webapp").as(GenericArchive.class), "/");
    }

    @Before
    public void setup() {
        browser.manage().window().maximize();
        browser.get(deploymentURL.toExternalForm());
    }

    @Test
    @InSequence(0)
    public void login(@InitialPage LoginPage loginPage) {
        browser.manage().deleteAllCookies();
        loginPage.login();
    }

    @Test
    @InSequence(1)
    public void createA(@InitialPage AListPage listPage) {
        Integer expected = 0;
        Assert.assertEquals(expected, listPage.countAs());

        listPage.create();

        ADTO expected_a = factory.manufacturePojo(ADTO.class);
        createPage.saveA(expected_a);

        ADTO actual_a = detailPage.getData();

        Assert.assertEquals(expected_a.getName(), actual_a.getName());
    }

    @Test
    @InSequence(2)
    public void editA(@InitialPage AListPage listPage) {
        ADTO expected_a = factory.manufacturePojo(ADTO.class);

        listPage.editA(0);

        editPage.saveA(expected_a);

        ADTO actual_a = detailPage.getData();

        Assert.assertEquals(expected_a.getName(), actual_a.getName());
    }

    @Test
    @InSequence(3)
    public void deleteA(@InitialPage AListPage listPage) {
        listPage.deleteA(0);
        deletePage.confirm();
        Integer expected = 0;
        Assert.assertEquals(expected, listPage.countAs());
    }

}
