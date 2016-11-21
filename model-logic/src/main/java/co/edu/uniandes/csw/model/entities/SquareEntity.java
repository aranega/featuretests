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
package co.edu.uniandes.csw.model.entities;

import java.io.Serializable;
import javax.persistence.Entity;
import co.edu.uniandes.csw.crud.spi.entity.BaseEntity;


/**
 * @generated
 */
@Entity
public class SquareEntity extends BaseEntity implements Serializable {

    private Integer x;

    private Integer y;

    /**
     * Obtiene el atributo x.
     *
     * @return atributo x.
     * @generated
     */
    public Integer getX(){
        return x;
    }

    /**
     * Establece el valor del atributo x.
     *
     * @param x nuevo valor del atributo
     * @generated
     */
    public void setX(Integer x){
        this.x = x;
    }

    /**
     * Obtiene el atributo y.
     *
     * @return atributo y.
     * @generated
     */
    public Integer getY(){
        return y;
    }

    /**
     * Establece el valor del atributo y.
     *
     * @param y nuevo valor del atributo
     * @generated
     */
    public void setY(Integer y){
        this.y = y;
    }
}
