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

import co.edu.uniandes.csw.model.entities.SquareEntity;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

/**
 * @generated
 */
@XmlRootElement
public class SquareDTO implements Serializable{

    private Integer x;
    private Integer y;

    /**
     * @generated
     */
    public SquareDTO() {
    }

    /**
     * Crea un objeto SquareDTO a partir de un objeto SquareEntity.
     *
     * @param entity Entidad SquareEntity desde la cual se va a crear el nuevo objeto.
     * @generated
     */
    public SquareDTO(SquareEntity entity) {
	   if (entity!=null){
        this.x=entity.getX();
        this.y=entity.getY();
       }
    }

    /**
     * Convierte un objeto SquareDTO a SquareEntity.
     *
     * @return Nueva objeto SquareEntity.
     * @generated
     */
    public SquareEntity toEntity() {
        SquareEntity entity = new SquareEntity();
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
