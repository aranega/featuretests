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
import co.edu.uniandes.csw.model.entities.SquareEntity;
import co.edu.uniandes.csw.model.persistence.SquarePersistence;
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
public class SquarePersistenceTest {

    /**
     * @generated
     */
    @Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class)
                .addPackage(SquareEntity.class.getPackage())
                .addPackage(SquarePersistence.class.getPackage())
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
    private SquarePersistence squarePersistence;

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
        em.createQuery("delete from SquareEntity").executeUpdate();
    }

    /**
     * @generated
     */
    private List<SquareEntity> data = new ArrayList<SquareEntity>();

    /**
     * Inserta los datos iniciales para el correcto funcionamiento de las pruebas.
     *
     * @generated
     */
    private void insertData() {
        PodamFactory factory = new PodamFactoryImpl();
        for (int i = 0; i < 3; i++) {
            SquareEntity entity = factory.manufacturePojo(SquareEntity.class);
            
            em.persist(entity);
            data.add(entity);
        }
    }
    /**
     * Prueba para crear un Square.
     *
     * @generated
     */
    @Test
    public void createSquareTest() {
        PodamFactory factory = new PodamFactoryImpl();
        SquareEntity newEntity = factory.manufacturePojo(SquareEntity.class);
        SquareEntity result = squarePersistence.create(newEntity);

        Assert.assertNotNull(result);

        SquareEntity entity = em.find(SquareEntity.class, result.getId());

        Assert.assertEquals(newEntity.getX(), entity.getX());
        Assert.assertEquals(newEntity.getY(), entity.getY());
    }

    /**
     * Prueba para consultar la lista de Squares.
     *
     * @generated
     */
    @Test
    public void getSquaresTest() {
        List<SquareEntity> list = squarePersistence.findAll();
        Assert.assertEquals(data.size(), list.size());
        for (SquareEntity ent : list) {
            boolean found = false;
            for (SquareEntity entity : data) {
                if (ent.getId().equals(entity.getId())) {
                    found = true;
                }
            }
            Assert.assertTrue(found);
        }
    }

    /**
     * Prueba para consultar un Square.
     *
     * @generated
     */
    @Test
    public void getSquareTest() {
        SquareEntity entity = data.get(0);
        SquareEntity newEntity = squarePersistence.find(entity.getId());
        Assert.assertNotNull(newEntity);
        Assert.assertEquals(entity.getX(), newEntity.getX());
        Assert.assertEquals(entity.getY(), newEntity.getY());
    }

    /**
     * Prueba para eliminar un Square.
     *
     * @generated
     */
    @Test
    public void deleteSquareTest() {
        SquareEntity entity = data.get(0);
        squarePersistence.delete(entity.getId());
        SquareEntity deleted = em.find(SquareEntity.class, entity.getId());
        Assert.assertNull(deleted);
    }

    /**
     * Prueba para actualizar un Square.
     *
     * @generated
     */
    @Test
    public void updateSquareTest() {
        SquareEntity entity = data.get(0);
        PodamFactory factory = new PodamFactoryImpl();
        SquareEntity newEntity = factory.manufacturePojo(SquareEntity.class);

        newEntity.setId(entity.getId());

        squarePersistence.update(newEntity);

        SquareEntity resp = em.find(SquareEntity.class, entity.getId());

        Assert.assertEquals(newEntity.getX(), resp.getX());
        Assert.assertEquals(newEntity.getY(), resp.getY());
    }
}
