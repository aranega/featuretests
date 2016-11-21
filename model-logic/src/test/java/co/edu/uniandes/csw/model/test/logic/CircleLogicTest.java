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
package co.edu.uniandes.csw.model.test.logic;

import co.edu.uniandes.csw.model.ejbs.CircleLogic;
import co.edu.uniandes.csw.model.api.ICircleLogic;
import co.edu.uniandes.csw.model.entities.CircleEntity;
import co.edu.uniandes.csw.model.persistence.CirclePersistence;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.UserTransaction;
import org.junit.Assert;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import uk.co.jemos.podam.api.PodamFactory;
import uk.co.jemos.podam.api.PodamFactoryImpl;

/**
 * @generated
 */
@RunWith(Arquillian.class)
public class CircleLogicTest {

    /**
     * @generated
     */

    /**
     * @generated
     */
    private PodamFactory factory = new PodamFactoryImpl();

    /**
     * @generated
     */
    @Inject
    private ICircleLogic circleLogic;

    /**
     * @generated
     */
    @PersistenceContext
    private EntityManager em;

    /**
     * @generated
     */
    @Inject
    private UserTransaction utx;

    /**
     * @generated
     */
    private List<CircleEntity> data = new ArrayList<CircleEntity>();

    /**
     * @generated
     */
    @Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class)
                .addPackage(CircleEntity.class.getPackage())
                .addPackage(CircleLogic.class.getPackage())
                .addPackage(ICircleLogic.class.getPackage())
                .addPackage(CirclePersistence.class.getPackage())
                .addAsManifestResource("META-INF/persistence.xml", "persistence.xml")
                .addAsManifestResource("META-INF/beans.xml", "beans.xml");
    }

    /**
     * Configuración inicial de la prueba.
     *
     * @generated
     */
    @Before
    public void configTest() {
        try {
            utx.begin();
            clearData();
            insertData();
            utx.commit();
        } catch (Exception e) {
            e.printStackTrace();
            try {
                utx.rollback();
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        }
    }

    /**
     * Limpia las tablas que están implicadas en la prueba.
     *
     * @generated
     */
    private void clearData() {
        em.createQuery("delete from CircleEntity").executeUpdate();
    }

    /**
     * Inserta los datos iniciales para el correcto funcionamiento de las pruebas.
     *
     * @generated
     */
    private void insertData() {
        for (int i = 0; i < 3; i++) {
            CircleEntity entity = factory.manufacturePojo(CircleEntity.class);

            em.persist(entity);
            data.add(entity);
        }
    }
    /**
     * Prueba para crear un Circle
     *
     * @generated
     */
    @Test
    public void createCircleTest() {
        CircleEntity newEntity = factory.manufacturePojo(CircleEntity.class);
        CircleEntity result = circleLogic.createCircle(newEntity);
        Assert.assertNotNull(result);
        CircleEntity entity = em.find(CircleEntity.class, result.getId());
    }

    /**
     * Prueba para consultar la lista de Circles
     *
     * @generated
     */
    @Test
    public void getCirclesTest() {
        List<CircleEntity> list = circleLogic.getCircles();
        Assert.assertEquals(data.size(), list.size());
        for (CircleEntity entity : list) {
            boolean found = false;
            for (CircleEntity storedEntity : data) {
                if (entity.getId().equals(storedEntity.getId())) {
                    found = true;
                }
            }
            Assert.assertTrue(found);
        }
    }

    
    /**
     * Prueba para consultar un Circle
     *
     * @generated
     */
    @Test
    public void getCircleTest() {
        CircleEntity entity = data.get(0);
        CircleEntity resultEntity = circleLogic.getCircle(entity.getId());
        Assert.assertNotNull(resultEntity);
    }

    /**
     * Prueba para eliminar un Circle
     *
     * @generated
     */
    @Test
    public void deleteCircleTest() {
        CircleEntity entity = data.get(0);
        circleLogic.deleteCircle(entity.getId());
        CircleEntity deleted = em.find(CircleEntity.class, entity.getId());
        Assert.assertNull(deleted);
    }

    /**
     * Prueba para actualizar un Circle
     *
     * @generated
     */
    @Test
    public void updateCircleTest() {
        CircleEntity entity = data.get(0);
        CircleEntity pojoEntity = factory.manufacturePojo(CircleEntity.class);

        pojoEntity.setId(entity.getId());

        circleLogic.updateCircle(pojoEntity);

        CircleEntity resp = em.find(CircleEntity.class, entity.getId());

    }
}

