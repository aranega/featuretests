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

import co.edu.uniandes.csw.model.api.IShapeLogic;
import co.edu.uniandes.csw.model.entities.ShapeEntity;
import co.edu.uniandes.csw.model.persistence.ShapePersistence;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.NoResultException;

/**
 * @generated
 */
@Stateless
public class ShapeLogic implements IShapeLogic {

    @Inject private ShapePersistence persistence;


    /**
     * Obtiene el número de registros de Shape.
     *
     * @return Número de registros de Shape.
     * @generated
     */
    public int countShapes() {
        return persistence.count();
    }

    /**
     * Obtiene la lista de los registros de Shape.
     *
     * @return Colección de objetos de ShapeEntity.
     * @generated
     */
    @Override
    public List<ShapeEntity> getShapes() {
        return persistence.findAll();
    }

    /**
     * Obtiene la lista de los registros de Shape indicando los datos para la paginación.
     *
     * @param page Número de página.
     * @param maxRecords Número de registros que se mostraran en cada página.
     * @return Colección de objetos de ShapeEntity.
     * @generated
     */
    @Override
    public List<ShapeEntity> getShapes(Integer page, Integer maxRecords) {
        return persistence.findAll(page, maxRecords);
    }

    /**
     * Obtiene los datos de una instancia de Shape a partir de su ID.
     *
     * @param id Identificador de la instancia a consultar
     * @return Instancia de ShapeEntity con los datos del Shape consultado.
     * @generated
     */
    public ShapeEntity getShape(Long id) {
        return persistence.find(id);
    }

    /**
     * Se encarga de crear un Shape en la base de datos.
     *
     * @param entity Objeto de ShapeEntity con los datos nuevos
     * @return Objeto de ShapeEntity con los datos nuevos y su ID.
     * @generated
     */
    @Override
    public ShapeEntity createShape(ShapeEntity entity) {
        persistence.create(entity);
        return entity;
    }

    /**
     * Actualiza la información de una instancia de Shape.
     *
     * @param entity Instancia de ShapeEntity con los nuevos datos.
     * @return Instancia de ShapeEntity con los datos actualizados.
     * @generated
     */
    @Override
    public ShapeEntity updateShape(ShapeEntity entity) {
        return persistence.update(entity);
    }

    /**
     * Elimina una instancia de Shape de la base de datos.
     *
     * @param id Identificador de la instancia a eliminar.
     * @generated
     */
    @Override
    public void deleteShape(Long id) {
        persistence.delete(id);
    }
  
}
