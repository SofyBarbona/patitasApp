# patitasApp

Aplicación creada en Android Studio, lenguaje Kotlin.
Ofrece un listado de Gatos con sus respectivas carácteristicas, los datos fueron obtenidos de LA API: https://www.api-ninjas.com/api/cats.
Ofrece un listado de los refugios que brindan Gatos rescatados en adopción

Recursos implementados en el desarrollo:
+ Se realizó el maquetado de las pantallas con navegación. Se incluyeron:.
    - Login: con su respectivo funcionamiento lógico,
    - Registro de nuevo usuario: con su respectivo funcionamiento lógico,
    - Menú,
    - Barra superior.
    - Iconos con imágenes nativas de Android y no nativas
+ Se incorporó el llamado a API Rest elegida (mediante el uso de corutinas), donde se obtuvo:
    - Lista con los datos principales de los elementos
    - Datos completos de elementos.
+ Se incorporó el manejo de Base de Datos local para almacenar los usuarios registrados.
+ Se incorporó el funcionamiento de “Recordar Usuario” con SHARED PREFERENCES. En donde, al seleccionarlo, ya no pide los datos cada vez que abre la app.
+ Se incorporó el uso de Fragmentos en la pantalla de la FICHA de los gatos.
+ Se incorporó un SERVICIO que permite reproducir sonido al comienzo de la aplicación
+ Genera una NOTIFICACIÓN cuando se activa la opción de RecordarUsuario.

Desarrolladores:
+ Camila Florencia Garcia
+ Nicolas Irrera
+ Sofia Barbona
