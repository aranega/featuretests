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

import co.edu.uniandes.csw.model.ejbs.ALogic;
import co.edu.uniandes.csw.model.api.IALogic;
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
public class ALogicTest {

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
    private IALogic aLogic;

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
    private List<AEntity> data = new ArrayList<AEntity>();

    /**
     * @generated
     */
    @Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class)
                .addPackage(AEntity.class.getPackage())
                .addPackage(ALogic.class.getPackage())
                .addPackage(IALogic.class.getPackage())
                .addPackage(APersistence.class.getPackage())
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
        em.createQuery("delete from AEntity").executeUpdate();
    }

    /**
     * Inserta los datos iniciales para el correcto funcionamiento de las pruebas.
     *
     * @generated
     */
    private void insertData() {
        for (int i = 0; i < 3; i++) {
            AEntity entity = factory.manufacturePojo(AEntity.class);

            em.persist(entity);
            data.add(entity);
        }
    }
    /**
     * Prueba para crear un A
     *
     * @generated
     */
    @Test
    public void createATest() {
        AEntity newEntity = factory.manufacturePojo(AEntity.class);
        AEntity result = aLogic.createA(newEntity);
        Assert.assertNotNull(result);
        AEntity entity = em.find(AEntity.class, result.getId());
        Assert.assertEquals(newEntity.getId(), entity.getId());
    }

    /**
     * Prueba para consultar la lista de As
     *
     * @generated
     */
    @Test
    public void getAsTest() {
        List<AEntity> list = aLogic.getAs();
        Assert.assertEquals(data.size(), list.size());
        for (AEntity entity : list) {
            boolean found = false;
            for (AEntity storedEntity : data) {
                if (entity.getId().equals(storedEntity.getId())) {
                    found = true;
                }
            }
            Assert.assertTrue(found);
        }
    }

    
    /**
     * Prueba para consultar un A
     *
     * @generated
     */
    @Test
    public void getATest() {
        AEntity entity = data.get(0);
        AEntity resultEntity = aLogic.getA(entity.getId());
        Assert.assertNotNull(resultEntity);
        Assert.assertEquals(entity.getId(), resultEntity.getId());
    }

    /**
     * Prueba para eliminar un A
     *
     * @generated
     */
    @Test
    public void deleteATest() {
        AEntity entity = data.get(0);
        aLogic.deleteA(entity.getId());
        AEntity deleted = em.find(AEntity.class, entity.getId());
        Assert.assertNull(deleted);
    }

    /**
     * Prueba para actualizar un A
     *
     * @generated
     */
    @Test
    public void updateATest() {
        AEntity entity = data.get(0);
        AEntity pojoEntity = factory.manufacturePojo(AEntity.class);

        pojoEntity.setId(entity.getId());

        aLogic.updateA(pojoEntity);

        AEntity resp = em.find(AEntity.class, entity.getId());

        Assert.assertEquals(pojoEntity.getId(), resp.getId());
    }
}

