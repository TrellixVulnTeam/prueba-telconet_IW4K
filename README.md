# eventos

### Es importante no cambiar los archivos de configuración y/o puertos ya establecidos

Este es un proyecto para demostrar el uso de la herramienta Springboot

## Para comenzar:

### Clonar el repositorio

```shell
git clone https://gitlab.com/23julio2021/lissette-noemi-candelario-muniz.git
```
### Crear o ejecutar el query en mysql, ublicado en la siguiente ruta
   query/bd_gestion.sql

### Instalar paquetes maven

Instalar los paquetes npm descritos en el archivo `pom.xml` e iniciar el proyecto:

```shell
mvn clean install

mvn spring-boot:run
```

El comando `mvn spring-boot:run` arranca la aplicación, observa cambios del código fuente y se accede a traves del puerto `5000`

Para apagar el server manualmente usar `Ctrl+C`

El comando para ejecutar el fontend es ´ng serve´
