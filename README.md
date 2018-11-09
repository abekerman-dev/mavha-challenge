# Test Técnico MAvha

## Características de la solución a desarrollar

Se pide implementar una solución que permita guardar y listar personas que tienen DNI (que actúa como su ID), nombre, apellido y edad.

La aplicación debe:

 1. Proveer endpoints para
  1.1 Listar personas, usando filtros opcionales por DNI, nombre y edad
  1.2 Dar de alta personas
 2. Contar con tests unitarios para el alta y el listado de personas.
 3. Usar maven y basarse en el Spring framework.
 4. Utilizar una base de datos en memoria hsqldb.
 5. Se debe poder _deployar_ en Jboss/Wildfly.

Los endpoints mencionados se pueden encontrar en [esta colección de Postman](https://www.getpostman.com/collections/2868fce4ef0f2cb06de0).

## Ejecutar la aplicación

Se puede ejecutar la aplicación de dos formas

1. Ejecución manual
2. Con docker
    
> Por supuesto, antes de comenzar con cualquiera de ellas, se debe bajar/clonar este repo y luego seguir las instrucciones de la alternativa de ejecución elegida.

### Ejecución manual

Como requisito previo, se debe contar con un servidor JBoss/Wildfly donde deployar el war que se va a generar a partir de la aplicación.

A continuación tenemos que empaquetar el war que vamos a deployar en el server, lo que hacemos sencillamente con el comando `mvn package`. Por supuesto, maven tiene que estar ya instalado.

### Con docker

Se recomienda esta opción ya que en un solo paso y de forma sencilla se puede lanzar la aplicación con todo integrado (servidor Jboss/Wildfly más la aplicación deployada en él).

Para esto, se debe simplemente correr el comando `docker-compose up`, lo que iniciará el build de una imagen con todo lo necesario para correr la aplicación dentro del servidor.

#### En este paso, si todo salió según lo esperado, la aplicación ya debería estar accesible y se puede comenzar a probar vía Postman.

## Autor

* **Andrés Bekerman** - [GitHub](https://github.com/abekerman-dev)
