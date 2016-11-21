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
import co.edu.uniandes.csw.model.api.ICircleLogic;
import co.edu.uniandes.csw.model.dtos.detail.CircleDetailDTO;
import co.edu.uniandes.csw.model.entities.CircleEntity;
import java.util.ArrayList;
import javax.ws.rs.WebApplicationException;

/**
 * URI: circles/
 * @generated
 */
@Path("/circles")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class CircleResource {

    @Inject private ICircleLogic circleLogic;
    @Context private HttpServletResponse response;
    @QueryParam("page") private Integer page;
    @QueryParam("limit") private Integer maxRecords;

   
    /**
     * Convierte una lista de CircleEntity a una lista de CircleDetailDTO.
     *
     * @param entityList Lista de CircleEntity a convertir.
     * @return Lista de CircleDetailDTO convertida.
     * @generated
     */
    private List<CircleDetailDTO> listEntity2DTO(List<CircleEntity> entityList){
        List<CircleDetailDTO> list = new ArrayList<>();
        for (CircleEntity entity : entityList) {
            list.add(new CircleDetailDTO(entity));
        }
        return list;
    }


    /**
     * Obtiene la lista de los registros de Circle
     *
     * @return Colección de objetos de CircleDetailDTO
     * @generated
     */
    @GET
    public List<CircleDetailDTO> getCircles() {
        if (page != null && maxRecords != null) {
            this.response.setIntHeader("X-Total-Count", circleLogic.countCircles());
            return listEntity2DTO(circleLogic.getCircles(page, maxRecords));
        }
        return listEntity2DTO(circleLogic.getCircles());
    }

    /**
     * Obtiene los datos de una instancia de Circle a partir de su ID
     *
     * @param id Identificador de la instancia a consultar
     * @return Instancia de CircleDetailDTO con los datos del Circle consultado
     * @generated
     */
    @GET
    @Path("{id: \\d+}")
    public CircleDetailDTO getCircle(@PathParam("id") Long id) {
        return new CircleDetailDTO(circleLogic.getCircle(id));
    }

    /**
     * Se encarga de crear un Circle en la base de datos
     *
     * @param dto Objeto de CircleDetailDTO con los datos nuevos
     * @return Objeto de CircleDetailDTOcon los datos nuevos y su ID
     * @generated
     */
    @POST
    @StatusCreated
    public CircleDetailDTO createCircle(CircleDetailDTO dto) {
        return new CircleDetailDTO(circleLogic.createCircle(dto.toEntity()));
    }

    /**
     * Actualiza la información de una instancia de Circle
     *
     * @param id Identificador de la instancia de Circle a modificar
     * @param dto Instancia de CircleDetailDTO con los nuevos datos
     * @return Instancia de CircleDetailDTO con los datos actualizados
     * @generated
     */
    @PUT
    @Path("{id: \\d+}")
    public CircleDetailDTO updateCircle(@PathParam("id") Long id, CircleDetailDTO dto) {
        CircleEntity entity = dto.toEntity();
        entity.setId(id);
        return new CircleDetailDTO(circleLogic.updateCircle(entity));
    }

    /**
     * Elimina una instancia de Circle de la base de datos
     *
     * @param id Identificador de la instancia a eliminar
     * @generated
     */
    @DELETE
    @Path("{id: \\d+}")
    public void deleteCircle(@PathParam("id") Long id) {
        circleLogic.deleteCircle(id);
    }
    
}
