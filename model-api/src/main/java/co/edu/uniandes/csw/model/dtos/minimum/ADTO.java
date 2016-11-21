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

import co.edu.uniandes.csw.model.entities.AEntity;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

/**
 * @generated
 */
@XmlRootElement
public class ADTO implements Serializable{

    private Boolean id;

    /**
     * @generated
     */
    public ADTO() {
    }

    /**
     * Crea un objeto ADTO a partir de un objeto AEntity.
     *
     * @param entity Entidad AEntity desde la cual se va a crear el nuevo objeto.
     * @generated
     */
    public ADTO(AEntity entity) {
	   if (entity!=null){
        this.id=entity.getId();
       }
    }

    /**
     * Convierte un objeto ADTO a AEntity.
     *
     * @return Nueva objeto AEntity.
     * @generated
     */
    public AEntity toEntity() {
        AEntity entity = new AEntity();
        entity.setId(this.getId());
    return entity;
    }

    /**
     * Obtiene el atributo id.
     *
     * @return atributo id.
     * @generated
     */
    public Boolean getId() {
        return id;
    }

    /**
     * Establece el valor del atributo id.
     *
     * @param id nuevo valor del atributo
     * @generated
     */
    public void setId(Boolean id) {
        this.id = id;
    }

}
