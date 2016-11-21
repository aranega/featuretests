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
import co.edu.uniandes.csw.model.api.IShapeLogic;
import co.edu.uniandes.csw.model.dtos.detail.ShapeDetailDTO;
import co.edu.uniandes.csw.model.entities.ShapeEntity;
import java.util.ArrayList;
import javax.ws.rs.WebApplicationException;

/**
 * URI: shapes/
 * @generated
 */
@Path("/shapes")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ShapeResource {

    @Inject private IShapeLogic shapeLogic;
    @Context private HttpServletResponse response;
    @QueryParam("page") private Integer page;
    @QueryParam("limit") private Integer maxRecords;

   
    /**
     * Convierte una lista de ShapeEntity a una lista de ShapeDetailDTO.
     *
     * @param entityList Lista de ShapeEntity a convertir.
     * @return Lista de ShapeDetailDTO convertida.
     * @generated
     */
    private List<ShapeDetailDTO> listEntity2DTO(List<ShapeEntity> entityList){
        List<ShapeDetailDTO> list = new ArrayList<>();
        for (ShapeEntity entity : entityList) {
            list.add(new ShapeDetailDTO(entity));
        }
        return list;
    }


    /**
     * Obtiene la lista de los registros de Shape
     *
     * @return Colección de objetos de ShapeDetailDTO
     * @generated
     */
    @GET
    public List<ShapeDetailDTO> getShapes() {
        if (page != null && maxRecords != null) {
            this.response.setIntHeader("X-Total-Count", shapeLogic.countShapes());
            return listEntity2DTO(shapeLogic.getShapes(page, maxRecords));
        }
        return listEntity2DTO(shapeLogic.getShapes());
    }

    /**
     * Obtiene los datos de una instancia de Shape a partir de su ID
     *
     * @param id Identificador de la instancia a consultar
     * @return Instancia de ShapeDetailDTO con los datos del Shape consultado
     * @generated
     */
    @GET
    @Path("{id: \\d+}")
    public ShapeDetailDTO getShape(@PathParam("id") Long id) {
        return new ShapeDetailDTO(shapeLogic.getShape(id));
    }

    /**
     * Se encarga de crear un Shape en la base de datos
     *
     * @param dto Objeto de ShapeDetailDTO con los datos nuevos
     * @return Objeto de ShapeDetailDTOcon los datos nuevos y su ID
     * @generated
     */
    @POST
    @StatusCreated
    public ShapeDetailDTO createShape(ShapeDetailDTO dto) {
        return new ShapeDetailDTO(shapeLogic.createShape(dto.toEntity()));
    }

    /**
     * Actualiza la información de una instancia de Shape
     *
     * @param id Identificador de la instancia de Shape a modificar
     * @param dto Instancia de ShapeDetailDTO con los nuevos datos
     * @return Instancia de ShapeDetailDTO con los datos actualizados
     * @generated
     */
    @PUT
    @Path("{id: \\d+}")
    public ShapeDetailDTO updateShape(@PathParam("id") Long id, ShapeDetailDTO dto) {
        ShapeEntity entity = dto.toEntity();
        entity.setId(id);
        return new ShapeDetailDTO(shapeLogic.updateShape(entity));
    }

    /**
     * Elimina una instancia de Shape de la base de datos
     *
     * @param id Identificador de la instancia a eliminar
     * @generated
     */
    @DELETE
    @Path("{id: \\d+}")
    public void deleteShape(@PathParam("id") Long id) {
        shapeLogic.deleteShape(id);
    }
    
}
