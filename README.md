# Easyknowledge4u

-----------------------

## Acerca del proyecto

Proyecto de la asignatura de Desarrollo de Aplicaciones Distribuidas del grado de Ingeniería de Computadores de la Universidad Rey Juan Carlos. Consiste en crear una pagina web de una academia de formación.

## Descripción de la aplicación

La aplicación tiene 2 partes:

Una **parte pública**, que permite navegar por la web, navegar por los distintos servicios, inicio de sesión y contacto.

Una **parte privada**, que permite la gestión de la cuenta de usuario y realizar los pagos de los cursos así como ver en cuales esta inscrito.

## Entidades

**Cliente**: usuario que accede a nuestra página web, pueden ser alumnos, docentes y administradores de la web.

**Cursos**: los distintos cursos ofertados en nuestra web, pueden ser de educación primaria, secundaría, bachillerato o universitarios.

**Inscripción**: contiene la pantalla con los campos a rellenar con los datos del usuario para la inscripción y el coste del curso.

**Contacto**: contiene una ubicación de la academia con google maps, un email de contacto, número de contacto además de un buzón de mensajes vía e-mail.

## Funcionamiento del servicio interno

Envío de correo al cliente con la confirmación del curso y la información del mismo

Servicio de pago online

## Integrantes

Juan Pablo Bernal Gutiérrez - jp.bernal.2018@alumnos.urjc.es - https://github.com/jpbernal

-----------------------

## Fase 2 

-----------------------

Diagrama de navegación:

![Diagrama de navegación](https://user-images.githubusercontent.com/43385877/110509987-02652480-8103-11eb-9131-45df49ed904c.png)

Diagrama UML:

![Diagrama UML](https://user-images.githubusercontent.com/43385877/110636624-c4243f80-81ac-11eb-8a4e-68d51aad64ea.png)


Diagrama E/R:

![Diagrama E:R](https://user-images.githubusercontent.com/43385877/110686777-16328880-81e0-11eb-98b2-4d5931d46e81.png)


-----------------------

A continuación se muestran capturas de pantallas de la Fase 2 de la aplicacion de las pantallas principales.

Pantalla principal - Index:

<img width="1440" alt="index" src="https://user-images.githubusercontent.com/43385877/110630690-fbdbb900-81a5-11eb-917a-65825e00c6ef.png">

¿Eres nuevo? - Registro:

Aquí deberemos introducir un nombre, correo electrónico y contraseña.

<img width="1440" alt="registro" src="https://user-images.githubusercontent.com/43385877/110630787-19a91e00-81a6-11eb-8a17-d6028100ca17.png">

Si nos registramos correctamente nos dirigirá a esta pantalla:

<img width="1440" alt="registro correcto" src="https://user-images.githubusercontent.com/43385877/110630985-5a089c00-81a6-11eb-9cd1-14118788f677.png">

Si ya tenemos una cuenta creada podremos iniciar sesion con nuestro credenciales, en este caso correo y contraseña

<img width="1440" alt="inicio sesion" src="https://user-images.githubusercontent.com/43385877/110631088-71e02000-81a6-11eb-8431-f67a99f30627.png">

Si los creedenciales introducidos son correctos, nos dirigirá a esta pantalla:

<img width="1440" alt="inicio sesion correcto" src="https://user-images.githubusercontent.com/43385877/110631155-83292c80-81a6-11eb-9684-1fb21d91e02d.png">


En el index podremos navegar a diferentes pestañas, entre ellas, los cursos disponibles y una pestaña de contacto.

Cursos:

Podremos inscribirnos a diferentes cursos, introduciendo primero el nombre del cliente. Si el nombre que introducimos no esta registrado previamente en la base de datos como cliente, no dejará inscribirse en dicho curso.

<img width="1440" alt="Captura de pantalla 2021-03-17 a las 21 36 30" src="https://user-images.githubusercontent.com/43385877/111535055-f9123280-8768-11eb-802b-ae80a6cd4d91.png">

Contacto:

Podremos enviar un mensaje a modo feedback o consulta que queramos realizar, introduciendo nuestro nombre y correo. No será necesario que el usuario este registrado previamente.

<img width="1440" alt="Captura de pantalla 2021-03-17 a las 21 39 45" src="https://user-images.githubusercontent.com/43385877/111535375-51e1cb00-8769-11eb-90be-2ce817a3adf1.png">


La aplicación utiliza una base de datos embedida H2, la cual podemos acceder vía web:

<img width="1440" alt="h2-console" src="https://user-images.githubusercontent.com/43385877/110631391-c08dba00-81a6-11eb-8238-d66d3e65f269.png">


Una vez accedemos nos encontramos con esta pantalla, en la que vemos las distintas entidades y sus relaciones

<img width="1440" alt="bd" src="https://user-images.githubusercontent.com/43385877/110631475-da2f0180-81a6-11eb-89db-2dfcd78a8db8.png">


Navegando por las entidades principales, tenemos cliente, curso e inscripción.

Cliente:

<img width="1440" alt="cliente_BD" src="https://user-images.githubusercontent.com/43385877/110631611-fe8ade00-81a6-11eb-947c-0efeeaa2d997.png">

Cursos:

<img width="1440" alt="curso_bd" src="https://user-images.githubusercontent.com/43385877/110631634-05195580-81a7-11eb-8046-545017f90bf4.png">












