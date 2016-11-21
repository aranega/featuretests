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
package co.edu.uniandes.csw.model.resources;

import co.edu.uniandes.csw.auth.provider.StatusCreated;
import java.util.List;
import javax.inject.Inject;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import co.edu.uniandes.csw.model.api.IALogic;
import co.edu.uniandes.csw.model.dtos.detail.ADetailDTO;
import co.edu.uniandes.csw.model.entities.AEntity;
import java.util.ArrayList;
import javax.ws.rs.WebApplicationException;

/**
 * URI: as/
 * @generated
 */
@Path("/as")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class AResource {

    @Inject private IALogic aLogic;
    @Context private HttpServletResponse response;
    @QueryParam("page") private Integer page;
    @QueryParam("limit") private Integer maxRecords;

   
    /**
     * Convierte una lista de AEntity a una lista de ADetailDTO.
     *
     * @param entityList Lista de AEntity a convertir.
     * @return Lista de ADetailDTO convertida.
     * @generated
     */
    private List<ADetailDTO> listEntity2DTO(List<AEntity> entityList){
        List<ADetailDTO> list = new ArrayList<>();
        for (AEntity entity : entityList) {
            list.add(new ADetailDTO(entity));
        }
        return list;
    }


    /**
     * Obtiene la lista de los registros de A
     *
     * @return Colección de objetos de ADetailDTO
     * @generated
     */
    @GET
    public List<ADetailDTO> getAs() {
        if (page != null && maxRecords != null) {
            this.response.setIntHeader("X-Total-Count", aLogic.countAs());
            return listEntity2DTO(aLogic.getAs(page, maxRecords));
        }
        return listEntity2DTO(aLogic.getAs());
    }

    /**
     * Obtiene los datos de una instancia de A a partir de su ID
     *
     * @param id Identificador de la instancia a consultar
     * @return Instancia de ADetailDTO con los datos del A consultado
     * @generated
     */
    @GET
    @Path("{id: \\d+}")
    public ADetailDTO getA(@PathParam("id") Long id) {
        return new ADetailDTO(aLogic.getA(id));
    }

    /**
     * Se encarga de crear un A en la base de datos
     *
     * @param dto Objeto de ADetailDTO con los datos nuevos
     * @return Objeto de ADetailDTOcon los datos nuevos y su ID
     * @generated
     */
    @POST
    @StatusCreated
    public ADetailDTO createA(ADetailDTO dto) {
        return new ADetailDTO(aLogic.createA(dto.toEntity()));
    }

    /**
     * Actualiza la información de una instancia de A
     *
     * @param id Identificador de la instancia de A a modificar
     * @param dto Instancia de ADetailDTO con los nuevos datos
     * @return Instancia de ADetailDTO con los datos actualizados
     * @generated
     */
    @PUT
    @Path("{id: \\d+}")
    public ADetailDTO updateA(@PathParam("id") Long id, ADetailDTO dto) {
        AEntity entity = dto.toEntity();
        entity.setId(id);
        return new ADetailDTO(aLogic.updateA(entity));
    }

    /**
     * Elimina una instancia de A de la base de datos
     *
     * @param id Identificador de la instancia a eliminar
     * @generated
     */
    @DELETE
    @Path("{id: \\d+}")
    public void deleteA(@PathParam("id") Long id) {
        aLogic.deleteA(id);
    }
    
}
