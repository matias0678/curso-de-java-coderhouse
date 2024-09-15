Endpoints 

//////////////////
CLIENTE
/////////////////////
Agregar (post)
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

//////////////////
PRODUCTO
//////////////////
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

////////////////
VENTA
///////////////////
realizar venta (POST)
/venta/crear/{clienteId}
body:{
  producto:{
    id
  }
  cantidad
}


