# eitec_back

El codigo fue desarrollado en java 11 y en spring boot 2.6.7 con el IDE IntelliJ IDEA.

Puedes clonar este reposito e importar el proyecto en eclipse para su compilacion o puedes acceder a las siguientes urls 

El uso de la api necesita las siguientes credenciales

    Usuario Administrador : username: jmoreira password: admin
    Usuario cliente : username: cliente password cliente
    Usuario delivery : username: repartidor password: delivery

Las url son las siguientes:

localhost:8080/caja/registrar esta es una solicitud de tipo post que recive el siguiente parametro

{
"nombre": "empanada",
"precio": 3.00,
"cantidad": 8,
"descripcion": "esto es una caja de empanadas"
}

localhost:8080/imagen/guardar esta es una solicitud de tipo post y recive 2 parametros

    file : el archivo de la imagen que se desea guardar
    id : el identificador de la caja a la que se le desea asociar la imagen

localhost:8080/pedido/registrar esta es una solicitud tipo pst y recive el siguiente parametro

{
"cliente": "Alejandro",
"fecha": "2022-01-24",
"tipoPago": true,
"estado": false,
"total": null,
"direccion": "Quito Av 10 de Agosto",
"telefono": "0987456321",
"cajas": null,
"usuarioId": 2
}

En donde

    usuarioId: es el id del usuario que registra el pedido
    tipoPago: true si es con tarjeto o false si es con efectivo
    estado: true si fue entregado o false si aun no es entregado

localhost:8080/pedido/addCajaPedido es una peticion de tipo post y recive 2 parametros

    idcaja: identificador de la caja que se quiere agregar al pedido
    idpedido: identificador del pedido

localhost:8080/pedido/listar es una peticion tipo get que retorna todos los pedidos

localhost:8080/caja/listar es una peticion de tipo get que retorna todas las cajas

localhost:8080/usuario/listaEnvios/id es una peticion de tipo get cuyo parametro id recive el id del usuario tipo delivery y retorna los datos del usuario y la lista de pedidos que tiene a su cargo