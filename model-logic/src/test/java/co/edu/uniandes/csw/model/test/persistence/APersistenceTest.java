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
import co.edu.uniandes.csw.model.entities.AEntity;
import co.edu.uniandes.csw.model.persistence.APersistence;
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
public class APersistenceTest {

    /**
     * @generated
     */
    @Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class)
                .addPackage(AEntity.class.getPackage())
                .addPackage(APersistence.class.getPackage())
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
    private APersistence aPersistence;

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
        em.createQuery("delete from AEntity").executeUpdate();
    }

    /**
     * @generated
     */
    private List<AEntity> data = new ArrayList<AEntity>();

    /**
     * Inserta los datos iniciales para el correcto funcionamiento de las pruebas.
     *
     * @generated
     */
    private void insertData() {
        PodamFactory factory = new PodamFactoryImpl();
        for (int i = 0; i < 3; i++) {
            AEntity entity = factory.manufacturePojo(AEntity.class);
            
            em.persist(entity);
            data.add(entity);
        }
    }
    /**
     * Prueba para crear un A.
     *
     * @generated
     */
    @Test
    public void createATest() {
        PodamFactory factory = new PodamFactoryImpl();
        AEntity newEntity = factory.manufacturePojo(AEntity.class);
        AEntity result = aPersistence.create(newEntity);

        Assert.assertNotNull(result);

        AEntity entity = em.find(AEntity.class, result.getId());

    }

    /**
     * Prueba para consultar la lista de As.
     *
     * @generated
     */
    @Test
    public void getAsTest() {
        List<AEntity> list = aPersistence.findAll();
        Assert.assertEquals(data.size(), list.size());
        for (AEntity ent : list) {
            boolean found = false;
            for (AEntity entity : data) {
                if (ent.getId().equals(entity.getId())) {
                    found = true;
                }
            }
            Assert.assertTrue(found);
        }
    }

    /**
     * Prueba para consultar un A.
     *
     * @generated
     */
    @Test
    public void getATest() {
        AEntity entity = data.get(0);
        AEntity newEntity = aPersistence.find(entity.getId());
        Assert.assertNotNull(newEntity);
    }

    /**
     * Prueba para eliminar un A.
     *
     * @generated
     */
    @Test
    public void deleteATest() {
        AEntity entity = data.get(0);
        aPersistence.delete(entity.getId());
        AEntity deleted = em.find(AEntity.class, entity.getId());
        Assert.assertNull(deleted);
    }

    /**
     * Prueba para actualizar un A.
     *
     * @generated
     */
    @Test
    public void updateATest() {
        AEntity entity = data.get(0);
        PodamFactory factory = new PodamFactoryImpl();
        AEntity newEntity = factory.manufacturePojo(AEntity.class);

        newEntity.setId(entity.getId());

        aPersistence.update(newEntity);

        AEntity resp = em.find(AEntity.class, entity.getId());

    }
}
