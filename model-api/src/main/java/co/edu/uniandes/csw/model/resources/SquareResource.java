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
import co.edu.uniandes.csw.model.api.ISquareLogic;
import co.edu.uniandes.csw.model.dtos.detail.SquareDetailDTO;
import co.edu.uniandes.csw.model.entities.SquareEntity;
import java.util.ArrayList;
import javax.ws.rs.WebApplicationException;

/**
 * URI: squares/
 * @generated
 */
@Path("/squares")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class SquareResource {

    @Inject private ISquareLogic squareLogic;
    @Context private HttpServletResponse response;
    @QueryParam("page") private Integer page;
    @QueryParam("limit") private Integer maxRecords;

   
    /**
     * Convierte una lista de SquareEntity a una lista de SquareDetailDTO.
     *
     * @param entityList Lista de SquareEntity a convertir.
     * @return Lista de SquareDetailDTO convertida.
     * @generated
     */
    private List<SquareDetailDTO> listEntity2DTO(List<SquareEntity> entityList){
        List<SquareDetailDTO> list = new ArrayList<>();
        for (SquareEntity entity : entityList) {
            list.add(new SquareDetailDTO(entity));
        }
        return list;
    }


    /**
     * Obtiene la lista de los registros de Square
     *
     * @return Colección de objetos de SquareDetailDTO
     * @generated
     */
    @GET
    public List<SquareDetailDTO> getSquares() {
        if (page != null && maxRecords != null) {
            this.response.setIntHeader("X-Total-Count", squareLogic.countSquares());
            return listEntity2DTO(squareLogic.getSquares(page, maxRecords));
        }
        return listEntity2DTO(squareLogic.getSquares());
    }

    /**
     * Obtiene los datos de una instancia de Square a partir de su ID
     *
     * @param id Identificador de la instancia a consultar
     * @return Instancia de SquareDetailDTO con los datos del Square consultado
     * @generated
     */
    @GET
    @Path("{id: \\d+}")
    public SquareDetailDTO getSquare(@PathParam("id") Long id) {
        return new SquareDetailDTO(squareLogic.getSquare(id));
    }

    /**
     * Se encarga de crear un Square en la base de datos
     *
     * @param dto Objeto de SquareDetailDTO con los datos nuevos
     * @return Objeto de SquareDetailDTOcon los datos nuevos y su ID
     * @generated
     */
    @POST
    @StatusCreated
    public SquareDetailDTO createSquare(SquareDetailDTO dto) {
        return new SquareDetailDTO(squareLogic.createSquare(dto.toEntity()));
    }

    /**
     * Actualiza la información de una instancia de Square
     *
     * @param id Identificador de la instancia de Square a modificar
     * @param dto Instancia de SquareDetailDTO con los nuevos datos
     * @return Instancia de SquareDetailDTO con los datos actualizados
     * @generated
     */
    @PUT
    @Path("{id: \\d+}")
    public SquareDetailDTO updateSquare(@PathParam("id") Long id, SquareDetailDTO dto) {
        SquareEntity entity = dto.toEntity();
        entity.setId(id);
        return new SquareDetailDTO(squareLogic.updateSquare(entity));
    }

    /**
     * Elimina una instancia de Square de la base de datos
     *
     * @param id Identificador de la instancia a eliminar
     * @generated
     */
    @DELETE
    @Path("{id: \\d+}")
    public void deleteSquare(@PathParam("id") Long id) {
        squareLogic.deleteSquare(id);
    }
    
}
