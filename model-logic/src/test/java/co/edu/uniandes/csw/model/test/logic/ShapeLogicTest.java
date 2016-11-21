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

import co.edu.uniandes.csw.model.ejbs.ShapeLogic;
import co.edu.uniandes.csw.model.api.IShapeLogic;
import co.edu.uniandes.csw.model.entities.ShapeEntity;
import co.edu.uniandes.csw.model.persistence.ShapePersistence;
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
public class ShapeLogicTest {

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
    private IShapeLogic shapeLogic;

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
    private List<ShapeEntity> data = new ArrayList<ShapeEntity>();

    /**
     * @generated
     */
    @Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class)
                .addPackage(ShapeEntity.class.getPackage())
                .addPackage(ShapeLogic.class.getPackage())
                .addPackage(IShapeLogic.class.getPackage())
                .addPackage(ShapePersistence.class.getPackage())
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
        em.createQuery("delete from ShapeEntity").executeUpdate();
    }

    /**
     * Inserta los datos iniciales para el correcto funcionamiento de las pruebas.
     *
     * @generated
     */
    private void insertData() {
        for (int i = 0; i < 3; i++) {
            ShapeEntity entity = factory.manufacturePojo(ShapeEntity.class);

            em.persist(entity);
            data.add(entity);
        }
    }
    /**
     * Prueba para crear un Shape
     *
     * @generated
     */
    @Test
    public void createShapeTest() {
        ShapeEntity newEntity = factory.manufacturePojo(ShapeEntity.class);
        ShapeEntity result = shapeLogic.createShape(newEntity);
        Assert.assertNotNull(result);
        ShapeEntity entity = em.find(ShapeEntity.class, result.getId());
        Assert.assertEquals(newEntity.getX(), entity.getX());
        Assert.assertEquals(newEntity.getY(), entity.getY());
    }

    /**
     * Prueba para consultar la lista de Shapes
     *
     * @generated
     */
    @Test
    public void getShapesTest() {
        List<ShapeEntity> list = shapeLogic.getShapes();
        Assert.assertEquals(data.size(), list.size());
        for (ShapeEntity entity : list) {
            boolean found = false;
            for (ShapeEntity storedEntity : data) {
                if (entity.getId().equals(storedEntity.getId())) {
                    found = true;
                }
            }
            Assert.assertTrue(found);
        }
    }

    
    /**
     * Prueba para consultar un Shape
     *
     * @generated
     */
    @Test
    public void getShapeTest() {
        ShapeEntity entity = data.get(0);
        ShapeEntity resultEntity = shapeLogic.getShape(entity.getId());
        Assert.assertNotNull(resultEntity);
        Assert.assertEquals(entity.getX(), resultEntity.getX());
        Assert.assertEquals(entity.getY(), resultEntity.getY());
    }

    /**
     * Prueba para eliminar un Shape
     *
     * @generated
     */
    @Test
    public void deleteShapeTest() {
        ShapeEntity entity = data.get(0);
        shapeLogic.deleteShape(entity.getId());
        ShapeEntity deleted = em.find(ShapeEntity.class, entity.getId());
        Assert.assertNull(deleted);
    }

    /**
     * Prueba para actualizar un Shape
     *
     * @generated
     */
    @Test
    public void updateShapeTest() {
        ShapeEntity entity = data.get(0);
        ShapeEntity pojoEntity = factory.manufacturePojo(ShapeEntity.class);

        pojoEntity.setId(entity.getId());

        shapeLogic.updateShape(pojoEntity);

        ShapeEntity resp = em.find(ShapeEntity.class, entity.getId());

        Assert.assertEquals(pojoEntity.getX(), resp.getX());
        Assert.assertEquals(pojoEntity.getY(), resp.getY());
    }
}

