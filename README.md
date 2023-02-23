# :hammer_and_wrench: META, Protocolos de objetos, Patrón IoC, Reflexión

## Arquitecturas Empresariales

### :pushpin: Daniel Felipe Hernández Mancipe

<br/>

Servidor web (tipo Apache) en Java. El servidor es capaz de entregar páginas html e imágenes tipo png. Igualmente el servidor provee un framework IoC para la construcción de aplicaciones web a partir de POJOs. Usando el servidor web se construye una aplicación web de ejemplo (hola mundo). El servidor atiende múltiples solicitudes no concurrentes. Se desarrolló un prototipo mínimo que demuestra capacidades reflexijas de Java y permite cargar un bean (POJO) y derivar una aplicación web a partir de él.

En resumen, una vez el servidor está desplegado en [localhost](https://localhost:35000/):

![connect from browser](../media/using2.png?raw=true):

- Entrega archivos estáticos como páginas HTML, CSS, JS e imágenes.

Se puede acceder a los archivos estáticos, como archivos .jpg:

![using jpg](../media/using3.png?raw=true)

archivos .png:

![using png](../media/using4.png?raw=true)

archivos .json:

![using json](../media/using5.png?raw=true)

o archivos .js:

![using js](../media/using6.png?raw=true)

- Entrega recursos dinámicos usando el framework reflexivo desarrollado.

![dinamic res](../media/using7.png?raw=true)

## Getting Started

### Prerequisites

- Java >= 11.x
- Maven >= 3.x
- Git >= 2.x
- JUnit 4.x

### Installing

Simplemente clone el repositorio:

```bash
git clone https://github.com/danielhndz/AREM-taller4.git
```

Luego compile el proyecto con maven:

```bash
cd <project-folder>
mvn compile
```

Si salió bien, debería tener una salida similar a esta:

![compile output](../media/mvn_compile.png?raw=true)

### Using

Debe estar en la carpeta raíz del proyecto para ejecutarlo correctamente.

```bash
mvn exec:java -Dexec.mainClass="edu.escuelaing.arem.Launcher" -Dexec.args="edu.escuelaing.arem.microspring.Controllers"
```

![output for first use](../media/using1.png?raw=true)

Ahora puede conectarse al servidor desplegado en [localhost](https://localhost:35000/):

![connect from browser](../media/using2.png?raw=true)

Se puede bajar el servidor con una simple petición HTTP a [/exit](https://localhost:35000/exit):

![shutdown](../media/shutdown.png?raw=true)

## Built With

- [Maven](https://maven.apache.org/) - Dependency Management
- [Git](https://git-scm.com/) - Version Management
- [JUnit4](https://junit.org/junit4/) - Unit testing framework for Java

## Design Metaphor

- Autor: Daniel Hernández
- Última modificación: 23/02/2023

### Backend Class Diagram

- [Diagrama de paquetes](/src/main/java/edu/escuelaing/arem/)

![Diagrama de paquetes](../media/pkgs.png?raw=true)

Los nombres de los paquetes intentan ser representativos en términos de la funcionalidad que está implementada en dicho paquete. La clase [Launcher](/src/main/java/edu/escuelaing/arem/Launcher.java) arranca el proyecto.

![Diagrama de paquetes con clases](../media/pkgs_simple.png?raw=true)

- La clase [HttpServer](/src/main/java/edu/escuelaing/arem/server/HttpServer.java) modela el servidor mediante un [ServerSocket](https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/net/ServerSocket.html). Esta clase implementa el patrón `Singleton`.

- La clase [FilesReader](/src/main/java/edu/escuelaing/arem/utils/FilesReader.java) del paquete [utils](/src/main/java/edu/escuelaing/arem/utils/) es la que se encarga de leer y devolver los recursos solicitados.

- La clase [RequestProcessor](/src/main/java/edu/escuelaing/arem/utils/FilesReader.java) del paquete [utils](/src/main/java/edu/escuelaing/arem/utils/) es la que se encarga de analizar y procesar las diferentes peticiones que llegan al servidor.

- La interfaz [RestService](/src/main/java/edu/escuelaing/arem/utils/FilesReader.java) del paquete [services](/src/main/java/edu/escuelaing/arem/services/) es la que se encarga de modelar las diferentes respuestas que envía el servidor.

- La interfaz [UriProcessor](/src/main/java/edu/escuelaing/arem/microspring/UriProcessor.java) del paquete [microspring](/src/main/java/edu/escuelaing/arem/microspring/) define un contrato que debe ser implementado por cualquier procesador de URI, para modelar el inicio de un componente y la invocación de un método de un componente.

- La clase [MicroSpring](/src/main/java/edu/escuelaing/arem/microspring/MicroSpringBoot.java) del paquete [microspring](/src/main/java/edu/escuelaing/arem/microspring/) es la implementación de la interfaz [UriProcessor](/src/main/java/edu/escuelaing/arem/microspring/UriProcessor.java).

- La anotación [RequestMapping](/src/main/java/edu/escuelaing/arem/microspring/RequestMapping.java) del paquete [microspring](/src/main/java/edu/escuelaing/arem/microspring/) se utiliza para marcar métodos en una clase que deben ser mapeados a rutas de URI específicas.

- La clase [MicroSpringBoot](/src/main/java/edu/escuelaing/arem/microspring/MicroSpringBoot.java) del paquete [microspring](/src/main/java/edu/escuelaing/arem/microspring/) se utiliza como segundo punto de entrada, para cargar las clases específicas que necesita en el contexto de `microframework`.

## Authors

- **Daniel Hernández** - _Initial work_ - [danielhndz](https://github.com/danielhndz)

## License

This project is licensed under the GPLv3 License - see the [LICENSE.md](LICENSE.md) file for details

## Javadoc

Para generar Javadocs independientes para el proyecto en la carpeta `/target/site/apidocs` ejecute:

```bash
mvn javadoc:javadoc
```
