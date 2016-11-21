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
package co.edu.uniandes.csw.model.test.persistence;
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
public class ShapePersistenceTest {

    /**
     * @generated
     */
    @Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class)
                .addPackage(ShapeEntity.class.getPackage())
                .addPackage(ShapePersistence.class.getPackage())
                .addAsManifestResource("META-INF/persistence.xml", "persistence.xml")
                .addAsManifestResource("META-INF/beans.xml", "beans.xml");
    }

    /**
     * @generated
     */

    /**
     * @generated
     */
    @Inject
    private ShapePersistence shapePersistence;

    /**
     * @generated
     */
    @PersistenceContext
    private EntityManager em;

    /**
     * @generated
     */
    @Inject
    UserTransaction utx;

    /**
     * Configuración inicial de la prueba.
     *
     * @generated
     */
    @Before
    public void configTest() {
        try {
            utx.begin();
            em.joinTransaction();
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
     * @generated
     */
    private List<ShapeEntity> data = new ArrayList<ShapeEntity>();

    /**
     * Inserta los datos iniciales para el correcto funcionamiento de las pruebas.
     *
     * @generated
     */
    private void insertData() {
        PodamFactory factory = new PodamFactoryImpl();
        for (int i = 0; i < 3; i++) {
            ShapeEntity entity = factory.manufacturePojo(ShapeEntity.class);
            
            em.persist(entity);
            data.add(entity);
        }
    }
    /**
     * Prueba para crear un Shape.
     *
     * @generated
     */
    @Test
    public void createShapeTest() {
        PodamFactory factory = new PodamFactoryImpl();
        ShapeEntity newEntity = factory.manufacturePojo(ShapeEntity.class);
        ShapeEntity result = shapePersistence.create(newEntity);

        Assert.assertNotNull(result);

        ShapeEntity entity = em.find(ShapeEntity.class, result.getId());

        Assert.assertEquals(newEntity.getX(), entity.getX());
        Assert.assertEquals(newEntity.getY(), entity.getY());
    }

    /**
     * Prueba para consultar la lista de Shapes.
     *
     * @generated
     */
    @Test
    public void getShapesTest() {
        List<ShapeEntity> list = shapePersistence.findAll();
        Assert.assertEquals(data.size(), list.size());
        for (ShapeEntity ent : list) {
            boolean found = false;
            for (ShapeEntity entity : data) {
                if (ent.getId().equals(entity.getId())) {
                    found = true;
                }
            }
            Assert.assertTrue(found);
        }
    }

    /**
     * Prueba para consultar un Shape.
     *
     * @generated
     */
    @Test
    public void getShapeTest() {
        ShapeEntity entity = data.get(0);
        ShapeEntity newEntity = shapePersistence.find(entity.getId());
        Assert.assertNotNull(newEntity);
        Assert.assertEquals(entity.getX(), newEntity.getX());
        Assert.assertEquals(entity.getY(), newEntity.getY());
    }

    /**
     * Prueba para eliminar un Shape.
     *
     * @generated
     */
    @Test
    public void deleteShapeTest() {
        ShapeEntity entity = data.get(0);
        shapePersistence.delete(entity.getId());
        ShapeEntity deleted = em.find(ShapeEntity.class, entity.getId());
        Assert.assertNull(deleted);
    }

    /**
     * Prueba para actualizar un Shape.
     *
     * @generated
     */
    @Test
    public void updateShapeTest() {
        ShapeEntity entity = data.get(0);
        PodamFactory factory = new PodamFactoryImpl();
        ShapeEntity newEntity = factory.manufacturePojo(ShapeEntity.class);

        newEntity.setId(entity.getId());

        shapePersistence.update(newEntity);

        ShapeEntity resp = em.find(ShapeEntity.class, entity.getId());

        Assert.assertEquals(newEntity.getX(), resp.getX());
        Assert.assertEquals(newEntity.getY(), resp.getY());
    }
}
