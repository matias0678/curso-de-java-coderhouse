Endpoints 

////////////////////////
//CLIENTE
////////////////////////

Agregar (POST)
/cliente/agregar
body: {
  nombre String,
  mail String,
  dni int,
  mail, int
}

Listar (GET)
/cliente/listar

Buscar por id (GET)
/cliente/buscar/{id}

Eliminar (DELETE)
/cliente/eliminar/{id}

Actualizar (PUT)
/cliente/cambiar/{id}
body: {
  nombre String,
  mail String,
  dni int,
  mail, int
}

///////////////////////////////
//PRODUCTO
///////////////////////////////
Agregar (post)
/producto/agregar
body: {
  nombre String,
  precio double,
  stock int,
}

Listar (GET)
/producto/listar

Buscar por id (GET)
/producto/buscar/{id}

Eliminar (DELETE)
/producto/eliminar/{id}

Actualizar (PUT)
/producto/cambiar/{id}
body: {
  nombre String,
  precio double,
  stock int,
}

////////////////////////
//VENTA
////////////////////////
realizar venta (POST)
/venta/crear/{clienteId}
body:{
  producto:{
    id
  }
  cantidad
}

Listar (GET)
/venta/listar

Buscar (GET)
/venta/buscar/{id}


