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

import co.edu.uniandes.csw.model.api.ISquareLogic;
import co.edu.uniandes.csw.model.entities.SquareEntity;
import co.edu.uniandes.csw.model.persistence.SquarePersistence;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.NoResultException;

/**
 * @generated
 */
@Stateless
public class SquareLogic implements ISquareLogic {

    @Inject private SquarePersistence persistence;


    /**
     * Obtiene el número de registros de Square.
     *
     * @return Número de registros de Square.
     * @generated
     */
    public int countSquares() {
        return persistence.count();
    }

    /**
     * Obtiene la lista de los registros de Square.
     *
     * @return Colección de objetos de SquareEntity.
     * @generated
     */
    @Override
    public List<SquareEntity> getSquares() {
        return persistence.findAll();
    }

    /**
     * Obtiene la lista de los registros de Square indicando los datos para la paginación.
     *
     * @param page Número de página.
     * @param maxRecords Número de registros que se mostraran en cada página.
     * @return Colección de objetos de SquareEntity.
     * @generated
     */
    @Override
    public List<SquareEntity> getSquares(Integer page, Integer maxRecords) {
        return persistence.findAll(page, maxRecords);
    }

    /**
     * Obtiene los datos de una instancia de Square a partir de su ID.
     *
     * @param id Identificador de la instancia a consultar
     * @return Instancia de SquareEntity con los datos del Square consultado.
     * @generated
     */
    public SquareEntity getSquare(Long id) {
        return persistence.find(id);
    }

    /**
     * Se encarga de crear un Square en la base de datos.
     *
     * @param entity Objeto de SquareEntity con los datos nuevos
     * @return Objeto de SquareEntity con los datos nuevos y su ID.
     * @generated
     */
    @Override
    public SquareEntity createSquare(SquareEntity entity) {
        persistence.create(entity);
        return entity;
    }

    /**
     * Actualiza la información de una instancia de Square.
     *
     * @param entity Instancia de SquareEntity con los nuevos datos.
     * @return Instancia de SquareEntity con los datos actualizados.
     * @generated
     */
    @Override
    public SquareEntity updateSquare(SquareEntity entity) {
        return persistence.update(entity);
    }

    /**
     * Elimina una instancia de Square de la base de datos.
     *
     * @param id Identificador de la instancia a eliminar.
     * @generated
     */
    @Override
    public void deleteSquare(Long id) {
        persistence.delete(id);
    }
  
}
