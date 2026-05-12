Microservicio Cerveza - Sistema de Gestión de Producción

Este proyecto consiste en una arquitectura de microservicios  para la gestion integral de una planta de produccion de cerveza artesanal. El sistema permite administrar el inventario de insumos, los procesos de fermentacion, el control de calidad, el envasado y la logística de pedidos. 

Se destaca la implementación del patron CSR (Controller-Service-Repository), asegurando respuestas REST estandarizadas mediante el uso de DTOs y un manejo centralizado de excepciones para garantizar la robustez del sistema.


Modelado Inicial: El diseño original de las tablas y sus relaciones se proyecto considerando un esquema relacional complejo para asegurar la integridad referencial.
Migración y Refactorización: Uno de los desafíos técnicos fue la adaptación del DDL inicial a los estándares. Realizamos una refactorización masiva para migrar de nombres en  (id_material) a (idMaterial), asegurando que el backend se comunicara perfectamente con la base de datos MySQL.

El proyecto se construyó bajo un enfoque distribuido. Definimos en conjunto las entidades base y luego dividimos las responsabilidades para cubrir los módulos requeridos por la pauta:

Sergio Cerda: Desarrollo de los modulos de Calidad, Distribucion, Envasado, Fermentacion e Inventario de Materiales.
Matias Silva: Desarrollo de los modulos de Mantenimiento, Pedido, Producción, Recetas y Stock Final.

Junto con el codigo, uno de los obstáculos más grandes que tuvimos fue el uso de Git y GitHub. Al principio nos costó conectar nuestros repositorios y entender el flujo de trabajo para no sobreescribir los avances del otro. Nos tomo tiempo dominar los comandos para asegurar que cada microservicio estuviera actualizado en la nube. Tambien tuvimos q rehacer todo el trabajo por un error con las ramas por lo que rescatamos lo que pudimos y empezamos con lo q se pudo salvar.

El otro gran desafio fue la estandarizacion del codigo. Tuvimos que rehacer gran parte de los controladores y servicios para que todos siguieran la misma logica de respuesta ResponseEntity y validación de datos. Cuando por fin logramos levantar la base de datos sin errores de simbolos, revisamos juntos por que saltaban algunos errores de dependencia y arreglandolos en equipo para asegurar que el sistema fuera totalmente funcional.
