# Proyecto Reactiva

## Descripción
Se requiere desarrollar una API completa que no solo gestionará todos los servicios esenciales para un carrito de compras, sino que también permitirá administrar los productos del sistema, así como las órdenes de compra y las órdenes de ventas. Esta API será una solución integral para cualquier plataforma de comercio electrónico, ofreciendo una amplia gama de funcionalidades para facilitar las transacciones en línea y la gestión de inventario.

Con esta API, los desarrolladores podrán integrar fácilmente funciones de comercio electrónico en sus aplicaciones y sitios web, ofreciendo a los usuarios una experiencia de compra fluida y sin problemas. Además, la API estará diseñada con un enfoque en la escalabilidad, la seguridad y el rendimiento, garantizando que pueda manejar cargas de trabajo intensivas y proteger los datos confidenciales de los usuarios en todo momento.

- [ ] Generación de reporte de compras en un intervalo de tiempo, fecha inicial y fecha final como parámetros de entrada.
- [ ] Generación de reporte de ventas en un intervalo de tiempo, fecha inicial y fecha final como parámetros de entrada.
- [ ] Generación de reporte de ventas del top 5 de artículos en un intervalo de tiempo, fecha inicial y fecha final como parámetros de entrada.

## Servicios
### Productos
Permite administrar cada uno de los productos de la plataforma.
Services requeridos como referencia, es posible que se necesiten algunos adicionales. 

- [x] Creación
- [x] Edición
- [x] Listado
- [x] BuscarById
- [x] BuscarName
- [ ] ModificarStock
- [x] Eliminado

Datos básicos de la Clase Producto, Está es una referencia, si es necesario se pueden agregar más propiedades.

**Ejemplo:**
```
{
  "id" : 1,
  "Name" : "MacBook",
  "Price" : 1500,
  "Description" : "Mac",
  "imageUrl" : "image.png",
  "Stock" : 1
}

{
  "id" : 2,
  "Name" : Lenovo,
  "Price" : 1000,
  "Description" : "Lenovo",
  "imageUrl" : "image.png",
  "Stock" : 1
}
```

### Carrito de compras
Dentro de la funcionalidad del carrito de compras debemos permitir las siguientes acciones o services

- [x] Agregar un artículo al carrito: Permite a los usuarios agregar productos al carrito de compras.
- [x] Eliminar un artículo del carrito: Permite a los usuarios eliminar productos del carrito de compras.
- [x] Actualizar la cantidad de un artículo: Permite a los usuarios aumentar o disminuir la cantidad de un producto en el carrito.
- [x] Obtener el contenido del carrito: Devuelve la lista de productos en el carrito junto con sus cantidades y precios.
- [x] Vaciar el carrito: Elimina todos los productos del carrito.
- [x] Calcular el total: Calcula el total de la compra, incluidos los impuestos y los costos de envío si corresponde.
- [ ] Registrar orden. (Ordenes de Ventas)

### Ordenes de Ventas
Permite que nuestra api realice ventas de los productos del inventario, debe permitir registrar múltiples productos es decir, que puedo comprar más de un producto en la misma Orden:

Se debe tener en cuenta que al momento de realizar una venta de un producto se debe disminuir la cantidad de productos o stock.

Las acciones son las siguientes
- [ ] Creación
- [ ] Edición
- [ ] Cancelación
- [ ] Listar Ordenes
- [ ] Listar Ordenes con Producto

### Ordenes de Compras
Permite que nuestra api realice compras de los productos del inventario, mantener el STOCK actualizado e incrementarlo según el número de ítems comprados.

Las acciones son las siguientes
- [ ] Creación
- [ ] Edición
- [ ] Cancelación
- [ ] Listar Ordenes

**Ejemplos:** registrar compras de artículos.
* Comprar 10 unidades de producto 1
* Comprar 30 unidades del producto 2
