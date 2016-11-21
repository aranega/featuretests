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
package co.edu.uniandes.csw.model.ejbs;

import co.edu.uniandes.csw.model.api.IALogic;
import co.edu.uniandes.csw.model.entities.AEntity;
import co.edu.uniandes.csw.model.persistence.APersistence;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.NoResultException;

/**
 * @generated
 */
@Stateless
public class ALogic implements IALogic {

    @Inject private APersistence persistence;


    /**
     * Obtiene el número de registros de A.
     *
     * @return Número de registros de A.
     * @generated
     */
    public int countAs() {
        return persistence.count();
    }

    /**
     * Obtiene la lista de los registros de A.
     *
     * @return Colección de objetos de AEntity.
     * @generated
     */
    @Override
    public List<AEntity> getAs() {
        return persistence.findAll();
    }

    /**
     * Obtiene la lista de los registros de A indicando los datos para la paginación.
     *
     * @param page Número de página.
     * @param maxRecords Número de registros que se mostraran en cada página.
     * @return Colección de objetos de AEntity.
     * @generated
     */
    @Override
    public List<AEntity> getAs(Integer page, Integer maxRecords) {
        return persistence.findAll(page, maxRecords);
    }

    /**
     * Obtiene los datos de una instancia de A a partir de su ID.
     *
     * @param id Identificador de la instancia a consultar
     * @return Instancia de AEntity con los datos del A consultado.
     * @generated
     */
    public AEntity getA(Long id) {
        return persistence.find(id);
    }

    /**
     * Se encarga de crear un A en la base de datos.
     *
     * @param entity Objeto de AEntity con los datos nuevos
     * @return Objeto de AEntity con los datos nuevos y su ID.
     * @generated
     */
    @Override
    public AEntity createA(AEntity entity) {
        persistence.create(entity);
        return entity;
    }

    /**
     * Actualiza la información de una instancia de A.
     *
     * @param entity Instancia de AEntity con los nuevos datos.
     * @return Instancia de AEntity con los datos actualizados.
     * @generated
     */
    @Override
    public AEntity updateA(AEntity entity) {
        return persistence.update(entity);
    }

    /**
     * Elimina una instancia de A de la base de datos.
     *
     * @param id Identificador de la instancia a eliminar.
     * @generated
     */
    @Override
    public void deleteA(Long id) {
        persistence.delete(id);
    }
  
}
