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
package co.edu.uniandes.csw.model.dtos.minimum;

import co.edu.uniandes.csw.model.entities.ShapeEntity;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

/**
 * @generated
 */
@XmlRootElement
public class ShapeDTO implements Serializable{

    private Integer x;
    private Integer y;

    /**
     * @generated
     */
    public ShapeDTO() {
    }

    /**
     * Crea un objeto ShapeDTO a partir de un objeto ShapeEntity.
     *
     * @param entity Entidad ShapeEntity desde la cual se va a crear el nuevo objeto.
     * @generated
     */
    public ShapeDTO(ShapeEntity entity) {
	   if (entity!=null){
        this.x=entity.getX();
        this.y=entity.getY();
       }
    }

    /**
     * Convierte un objeto ShapeDTO a ShapeEntity.
     *
     * @return Nueva objeto ShapeEntity.
     * @generated
     */
    public ShapeEntity toEntity() {
        ShapeEntity entity = new ShapeEntity();
        entity.setX(this.getX());
        entity.setY(this.getY());
    return entity;
    }

    /**
     * Obtiene el atributo x.
     *
     * @return atributo x.
     * @generated
     */
    public Integer getX() {
        return x;
    }

    /**
     * Establece el valor del atributo x.
     *
     * @param x nuevo valor del atributo
     * @generated
     */
    public void setX(Integer x) {
        this.x = x;
    }

    /**
     * Obtiene el atributo y.
     *
     * @return atributo y.
     * @generated
     */
    public Integer getY() {
        return y;
    }

    /**
     * Establece el valor del atributo y.
     *
     * @param y nuevo valor del atributo
     * @generated
     */
    public void setY(Integer y) {
        this.y = y;
    }

}
