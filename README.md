# Easyknowledge4u

-----------------------

## Acerca del proyecto

Proyecto de la asignatura de Desarrollo de Aplicaciones Distribuidas del grado de Ingeniería de Computadores de la Universidad Rey Juan Carlos. Consiste en crear una pagina web de una academia de formación.

## Descripción de la aplicación

La aplicación tiene 2 partes:

Una **parte pública**, que permite navegar por la web, navegar por los distintos servicios, inicio de sesión y contacto.

Una **parte privada**, que permite la gestión de los diferentes cursos, crear, editar o borrar cursos.

## Entidades

**Cliente**: usuario que accede a nuestra página web, pueden ser alumnos, docentes y administradores de la web.

**Cursos**: los distintos cursos ofertados en nuestra web, pueden ser de matemáticas, inglés o informática inicialmente, se pueden tanto crear nuevos, editar los existentes o eliminarlos.

**Contacto**: una forma de recibir feedback mediante un email de contacto, número de contacto además de un buzón de mensajes/dudas vía e-mail.

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

<img width="811" alt="Captura de pantalla 2021-03-17 a las 22 42 14" src="https://user-images.githubusercontent.com/43385877/111542616-4050f100-8772-11eb-9792-d601f1afd824.png">




Diagrama E/R:

![Untitled Document](https://user-images.githubusercontent.com/43385877/111541267-8a38d780-8770-11eb-9bf4-c06194ed658d.png)


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

<img width="1440" alt="Captura de pantalla 2021-03-17 a las 21 42 21" src="https://user-images.githubusercontent.com/43385877/111535760-c0bf2400-8769-11eb-8184-2050cf24e119.png">

Navegando por las entidades principales, tenemos cliente, curso e inscripción.

Cliente:

<img width="1440" alt="Captura de pantalla 2021-03-17 a las 21 45 16" src="https://user-images.githubusercontent.com/43385877/111536088-17c4f900-876a-11eb-979e-7600217eb5a6.png">

Contacto:
<img width="1440" alt="Captura de pantalla 2021-03-17 a las 21 45 56" src="https://user-images.githubusercontent.com/43385877/111536165-31664080-876a-11eb-8b2d-956bb16d4c73.png">

Cursos:
<img width="1440" alt="Captura de pantalla 2021-03-17 a las 21 46 25" src="https://user-images.githubusercontent.com/43385877/111536210-3fb45c80-876a-11eb-93e3-46d3002e5716.png">

La relación cliente-cursos refleja las ID de los clientes apuntados a los diferentes cursos:
<img width="1440" alt="Captura de pantalla 2021-03-17 a las 21 46 50" src="https://user-images.githubusercontent.com/43385877/111536309-61154880-876a-11eb-8c75-eef1ab566574.png">


-----------------------

## Fase 3 

-----------------------

En esta fase se ha implementado Spring Security, controlando el acceso a diferentes paginas de la web en función a los permisos del usuario.

Diagrama de navegación:

![Diagrama de navegación](https://user-images.githubusercontent.com/43385877/110509987-02652480-8103-11eb-9131-45df49ed904c.png)

A continuación se muestran varias capturas de la aplicación durante esta Fase 3 del proyecto:



Pagina principal con opción de inicio de sesión arriba a la derecha:
![1](https://user-images.githubusercontent.com/43385877/114379064-a752a180-9b88-11eb-9ee6-e8f2acace541.PNG)

Podremos navegar por los diferentes cursos ofertados y consultar sus precios sin necesidad de estar loggeados en la web: 

![2](https://user-images.githubusercontent.com/43385877/114379826-95bdc980-9b89-11eb-818e-cf7628cb5abc.PNG)

Se han definido 2 tipos de usuarios: Administrador y usuario.

Si iniciamos sesion como administrador con las credenciales correctas, podremos: Crear, editar y borrar cursos:
![3](https://user-images.githubusercontent.com/43385877/114379936-c00f8700-9b89-11eb-9967-dcfbeba5609f.PNG)
![4](https://user-images.githubusercontent.com/43385877/114379965-ca318580-9b89-11eb-91d3-03fff305e764.PNG)
![5](https://user-images.githubusercontent.com/43385877/114379996-d584b100-9b89-11eb-95f8-73d9efe5161d.PNG)












