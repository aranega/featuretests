# Tabla de contenidos
-  [Introducción](#introducción)
-  [API](#api-de-la-aplicación-model)
  - [Recurso Circle](#recurso-circle)
    - [GET /circles](#GET-/circles)
    - [GET /circles/{id}](#GET-/circles/{id})
    - [POST /circles](#POST-/circles)
    - [PUT /circles/{id}](#PUT-/circles/{id})
    - [DELETE /circles/{id}](#DELETE-/circles/{id})
  - [Recurso Shape](#recurso-shape)
    - [GET /shapes](#GET-/shapes)
    - [GET /shapes/{id}](#GET-/shapes/{id})
    - [POST /shapes](#POST-/shapes)
    - [PUT /shapes/{id}](#PUT-/shapes/{id})
    - [DELETE /shapes/{id}](#DELETE-/shapes/{id})
  - [Recurso Square](#recurso-square)
    - [GET /squares](#GET-/squares)
    - [GET /squares/{id}](#GET-/squares/{id})
    - [POST /squares](#POST-/squares)
    - [PUT /squares/{id}](#PUT-/squares/{id})
    - [DELETE /squares/{id}](#DELETE-/squares/{id})
  - [Recurso A](#recurso-a)
    - [GET /as](#GET-/as)
    - [GET /as/{id}](#GET-/as/{id})
    - [POST /as](#POST-/as)
    - [PUT /as/{id}](#PUT-/as/{id})
    - [DELETE /as/{id}](#DELETE-/as/{id})

# API Rest
## Introducción
La comunicación entre cliente y servidor se realiza intercambiando objetos JSON. Para cada entidad se hace un mapeo a JSON, donde cada uno de sus atributos se transforma en una propiedad de un objeto JSON. Todos los servicios se generan en la URL /model.api/api/. Por defecto, todas las entidades tienen un atributo `id`, con el cual se identifica cada registro:

```javascript
{
    id: '',
    attribute_1: '',
    attribute_2: '',
    ...
    attribute_n: ''
}
```

Cuando se transmite información sobre un registro específico, se realiza enviando un objeto con la estructura mencionada en la sección anterior.
La única excepción se presenta al solicitar al servidor una lista de los registros en la base de datos, que incluye información adicional para manejar paginación de lado del servidor en el header `X-Total-Count` y los registros se envían en el cuerpo del mensaje como un arreglo.

La respuesta del servidor al solicitar una colección presenta el siguiente formato:

```javascript
[{}, {}, {}, {}, {}, {}]
```

## API de la aplicación model
### Recurso Circle
El objeto Circle tiene 2 representaciones JSON:	

#### Representación Minimum
```javascript
{
    x: '' /*Tipo Integer*/,
    y: '' /*Tipo Integer*/
}
```




#### GET /circles

Retorna una colección de objetos Circle en representación Detail.

#### Parámetros

#### N/A

#### Respuesta

Código|Descripción|Cuerpo
:--|:--|:--
200|OK|Colección de [representaciones Detail](#recurso-circle)
409|Un objeto relacionado no existe|Mensaje de error
500|Error interno|Mensaje de error

#### GET /circles/{id}

Retorna una colección de objetos Circle en representación Detail.

#### Parámetros

Nombre|Ubicación|Descripción|Requerido|Esquema
:--|:--|:--|:--|:--
id|Path|ID del objeto Circle a consultar|Sí|Integer

#### Respuesta

Código|Descripción|Cuerpo
:--|:--|:--
200|OK|Objeto Circle en [representaciones Detail](#recurso-circle)
404|No existe un objeto Circle con el ID solicitado|Mensaje de error
500|Error interno|Mensaje de error

#### POST /circles

Es el encargado de crear objetos Circle.

#### Parámetros

Nombre|Ubicación|Descripción|Requerido|Esquema
:--|:--|:--|:--|:--
body|body|Objeto Circle que será creado|Sí|[Representación Detail](#recurso-circle)

#### Respuesta

Código|Descripción|Cuerpo
:--|:--|:--
201|El objeto Circle ha sido creado|[Representación Detail](#recurso-circle)
409|Un objeto relacionado no existe|Mensaje de error
500|No se pudo crear el objeto Circle|Mensaje de error

#### PUT /circles/{id}

Es el encargado de actualizar objetos Circle.

#### Parámetros

Nombre|Ubicación|Descripción|Requerido|Esquema
:--|:--|:--|:--|:--
id|Path|ID del objeto Circle a actualizar|Sí|Integer
body|body|Objeto Circle nuevo|Sí|[Representación Detail](#recurso-circle)

#### Respuesta

Código|Descripción|Cuerpo
:--|:--|:--
201|El objeto Circle actualizado|[Representación Detail](#recurso-circle)
409|Un objeto relacionado no existe|Mensaje de error
500|No se pudo actualizar el objeto Circle|Mensaje de error

#### DELETE /circles/{id}

Elimina un objeto Circle.

#### Parámetros

Nombre|Ubicación|Descripción|Requerido|Esquema
:--|:--|:--|:--|:--
id|Path|ID del objeto Circle a eliminar|Sí|Integer

#### Respuesta

Código|Descripción|Cuerpo
:--|:--|:--
204|Objeto eliminado|N/A
500|Error interno|Mensaje de error



[Volver arriba](#tabla-de-contenidos)
### Recurso Shape
El objeto Shape tiene 2 representaciones JSON:	

#### Representación Minimum
```javascript
{
    x: '' /*Tipo Integer*/,
    y: '' /*Tipo Integer*/
}
```




#### GET /shapes

Retorna una colección de objetos Shape en representación Detail.

#### Parámetros

#### N/A

#### Respuesta

Código|Descripción|Cuerpo
:--|:--|:--
200|OK|Colección de [representaciones Detail](#recurso-shape)
409|Un objeto relacionado no existe|Mensaje de error
500|Error interno|Mensaje de error

#### GET /shapes/{id}

Retorna una colección de objetos Shape en representación Detail.

#### Parámetros

Nombre|Ubicación|Descripción|Requerido|Esquema
:--|:--|:--|:--|:--
id|Path|ID del objeto Shape a consultar|Sí|Integer

#### Respuesta

Código|Descripción|Cuerpo
:--|:--|:--
200|OK|Objeto Shape en [representaciones Detail](#recurso-shape)
404|No existe un objeto Shape con el ID solicitado|Mensaje de error
500|Error interno|Mensaje de error

#### POST /shapes

Es el encargado de crear objetos Shape.

#### Parámetros

Nombre|Ubicación|Descripción|Requerido|Esquema
:--|:--|:--|:--|:--
body|body|Objeto Shape que será creado|Sí|[Representación Detail](#recurso-shape)

#### Respuesta

Código|Descripción|Cuerpo
:--|:--|:--
201|El objeto Shape ha sido creado|[Representación Detail](#recurso-shape)
409|Un objeto relacionado no existe|Mensaje de error
500|No se pudo crear el objeto Shape|Mensaje de error

#### PUT /shapes/{id}

Es el encargado de actualizar objetos Shape.

#### Parámetros

Nombre|Ubicación|Descripción|Requerido|Esquema
:--|:--|:--|:--|:--
id|Path|ID del objeto Shape a actualizar|Sí|Integer
body|body|Objeto Shape nuevo|Sí|[Representación Detail](#recurso-shape)

#### Respuesta

Código|Descripción|Cuerpo
:--|:--|:--
201|El objeto Shape actualizado|[Representación Detail](#recurso-shape)
409|Un objeto relacionado no existe|Mensaje de error
500|No se pudo actualizar el objeto Shape|Mensaje de error

#### DELETE /shapes/{id}

Elimina un objeto Shape.

#### Parámetros

Nombre|Ubicación|Descripción|Requerido|Esquema
:--|:--|:--|:--|:--
id|Path|ID del objeto Shape a eliminar|Sí|Integer

#### Respuesta

Código|Descripción|Cuerpo
:--|:--|:--
204|Objeto eliminado|N/A
500|Error interno|Mensaje de error



[Volver arriba](#tabla-de-contenidos)
### Recurso Square
El objeto Square tiene 2 representaciones JSON:	

#### Representación Minimum
```javascript
{
    x: '' /*Tipo Integer*/,
    y: '' /*Tipo Integer*/
}
```




#### GET /squares

Retorna una colección de objetos Square en representación Detail.

#### Parámetros

#### N/A

#### Respuesta

Código|Descripción|Cuerpo
:--|:--|:--
200|OK|Colección de [representaciones Detail](#recurso-square)
409|Un objeto relacionado no existe|Mensaje de error
500|Error interno|Mensaje de error

#### GET /squares/{id}

Retorna una colección de objetos Square en representación Detail.

#### Parámetros

Nombre|Ubicación|Descripción|Requerido|Esquema
:--|:--|:--|:--|:--
id|Path|ID del objeto Square a consultar|Sí|Integer

#### Respuesta

Código|Descripción|Cuerpo
:--|:--|:--
200|OK|Objeto Square en [representaciones Detail](#recurso-square)
404|No existe un objeto Square con el ID solicitado|Mensaje de error
500|Error interno|Mensaje de error

#### POST /squares

Es el encargado de crear objetos Square.

#### Parámetros

Nombre|Ubicación|Descripción|Requerido|Esquema
:--|:--|:--|:--|:--
body|body|Objeto Square que será creado|Sí|[Representación Detail](#recurso-square)

#### Respuesta

Código|Descripción|Cuerpo
:--|:--|:--
201|El objeto Square ha sido creado|[Representación Detail](#recurso-square)
409|Un objeto relacionado no existe|Mensaje de error
500|No se pudo crear el objeto Square|Mensaje de error

#### PUT /squares/{id}

Es el encargado de actualizar objetos Square.

#### Parámetros

Nombre|Ubicación|Descripción|Requerido|Esquema
:--|:--|:--|:--|:--
id|Path|ID del objeto Square a actualizar|Sí|Integer
body|body|Objeto Square nuevo|Sí|[Representación Detail](#recurso-square)

#### Respuesta

Código|Descripción|Cuerpo
:--|:--|:--
201|El objeto Square actualizado|[Representación Detail](#recurso-square)
409|Un objeto relacionado no existe|Mensaje de error
500|No se pudo actualizar el objeto Square|Mensaje de error

#### DELETE /squares/{id}

Elimina un objeto Square.

#### Parámetros

Nombre|Ubicación|Descripción|Requerido|Esquema
:--|:--|:--|:--|:--
id|Path|ID del objeto Square a eliminar|Sí|Integer

#### Respuesta

Código|Descripción|Cuerpo
:--|:--|:--
204|Objeto eliminado|N/A
500|Error interno|Mensaje de error



[Volver arriba](#tabla-de-contenidos)
### Recurso A
El objeto A tiene 2 representaciones JSON:	

#### Representación Minimum
```javascript
{
    id: '' /*Tipo Boolean*/
}
```




#### GET /as

Retorna una colección de objetos A en representación Detail.

#### Parámetros

#### N/A

#### Respuesta

Código|Descripción|Cuerpo
:--|:--|:--
200|OK|Colección de [representaciones Detail](#recurso-a)
409|Un objeto relacionado no existe|Mensaje de error
500|Error interno|Mensaje de error

#### GET /as/{id}

Retorna una colección de objetos A en representación Detail.

#### Parámetros

Nombre|Ubicación|Descripción|Requerido|Esquema
:--|:--|:--|:--|:--
id|Path|ID del objeto A a consultar|Sí|Integer

#### Respuesta

Código|Descripción|Cuerpo
:--|:--|:--
200|OK|Objeto A en [representaciones Detail](#recurso-a)
404|No existe un objeto A con el ID solicitado|Mensaje de error
500|Error interno|Mensaje de error

#### POST /as

Es el encargado de crear objetos A.

#### Parámetros

Nombre|Ubicación|Descripción|Requerido|Esquema
:--|:--|:--|:--|:--
body|body|Objeto A que será creado|Sí|[Representación Detail](#recurso-a)

#### Respuesta

Código|Descripción|Cuerpo
:--|:--|:--
201|El objeto A ha sido creado|[Representación Detail](#recurso-a)
409|Un objeto relacionado no existe|Mensaje de error
500|No se pudo crear el objeto A|Mensaje de error

#### PUT /as/{id}

Es el encargado de actualizar objetos A.

#### Parámetros

Nombre|Ubicación|Descripción|Requerido|Esquema
:--|:--|:--|:--|:--
id|Path|ID del objeto A a actualizar|Sí|Integer
body|body|Objeto A nuevo|Sí|[Representación Detail](#recurso-a)

#### Respuesta

Código|Descripción|Cuerpo
:--|:--|:--
201|El objeto A actualizado|[Representación Detail](#recurso-a)
409|Un objeto relacionado no existe|Mensaje de error
500|No se pudo actualizar el objeto A|Mensaje de error

#### DELETE /as/{id}

Elimina un objeto A.

#### Parámetros

Nombre|Ubicación|Descripción|Requerido|Esquema
:--|:--|:--|:--|:--
id|Path|ID del objeto A a eliminar|Sí|Integer

#### Respuesta

Código|Descripción|Cuerpo
:--|:--|:--
204|Objeto eliminado|N/A
500|Error interno|Mensaje de error



[Volver arriba](#tabla-de-contenidos)
