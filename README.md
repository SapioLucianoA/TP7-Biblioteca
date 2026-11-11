# 📚 Gestión de Biblioteca

Práctico Integrador de **Programación Orientada a Objetos** (Java). Sistema que administra los préstamos de los libros de una biblioteca, con socios de dos tipos (estudiantes y docentes), reglas de préstamo propias de cada tipo e informes para la administración.

- **Equipo:** `Equipo Object`
- **Líder:** `Sapio, Luciano`
- **Grupo de laboratorio:** 3
- **Tablero de trabajo (Trello):** `https://trello.com/b/9AhG6laN/tp7-blibioteca`

---

## Sobre el proyecto

Este proyecto es un **trabajo práctico integrador de Programación Orientada a Objetos**. Modela el funcionamiento de una biblioteca: hay libros, socios, préstamos con fecha de retiro y de devolución, y reglas distintas según quién pide el libro. A partir de un diseño dado (diagrama de clases y descripción de los métodos), el trabajo consistió en llevar ese diseño a código Java y lograr que todas las piezas funcionen juntas.

**Como experiencia**, fue un trabajo en equipo: cada subgrupo implementó sus clases de forma independiente y después se integraron en `Biblioteca` y en el programa principal. Eso obligó a ponerse de acuerdo en cómo se llaman y qué hacen los métodos que se usan entre clases, a organizar las tareas en Trello y a trabajar con Git y GitHub (ramas, commits y resolución de merges).

---

## 1. Descripción del problema

Una biblioteca desea administrar los préstamos de sus libros.

- Cada **libro** tiene una ficha de préstamos donde se asientan todos los préstamos realizados.
- Cada **socio** tiene una lista de préstamos donde se asientan los préstamos en su poder.
- Al pedir un préstamo, este se crea solo con la **fecha de retiro**. La biblioteca lo asienta en la ficha del libro y en la del socio. Al devolver el libro, se registra la **fecha de devolución** en el préstamo.

---

## 2. Estructura del repositorio

```
.
├── Biblioteca/
│   ├── Biblioteca.java
│   ├── BibliotecaGUI.java
│   ├── Docente.java
│   ├── Estudiante.java
│   ├── GestionBiblioteca.java
│   ├── Libro.java
│   ├── LibroNoPrestadoException.java
│   ├── Prestamo.java
│   ├── README.TXT
│   └── Socio.java
├── .gitignore
├── README.md
└── desktop.ini
```

---

## 3. Clases del sistema

> Las clases del modelo usan **doble encapsulamiento**: los atributos son privados y los constructores asignan mediante los `set` (privados). Los parámetros llevan el prefijo `p_`.

### `Socio` (abstracta)

| Atributo | Tipo | Descripción |
|---|---|---|
| `dniSocio` | `int` | D.N.I. del socio |
| `nombre` | `String` | Nombre y apellido |
| `diasPrestamo` | `int` | Días que tiene el socio para devolver un libro |
| `prestamos` | `ArrayList<Prestamo>` | Préstamos del socio |

Dos constructores: `Socio(dni, nombre, diasPrestamo)`, que inicia la lista de préstamos vacía, y `Socio(dni, nombre, diasPrestamo, prestamos)`, que recibe una lista existente.

| Método | Descripción |
|---|---|
| `getDniSocio()`, `getNombre()`, `getPrestamos()`, `getDiasPrestamo()` | Consultas |
| `setDiasPrestamo(int)` | Modifica los días de préstamo (lo usa `Docente`) |
| `addPrestamo(Prestamo)` / `removePrestamo(Prestamo)` | Agrega o quita un préstamo de la lista del socio |
| `cantLibrosPrestados()` | Cantidad de préstamos en la lista del socio |
| `puedePedir()` | `true` si ninguno de sus préstamos está vencido a la fecha de hoy |
| `toString()` | `D.N.I.: <dni> \|\| <nombre> (<tipo>) \|\| Libros Prestados: <cantidad>` |
| `soyDeLaClase()` | Abstracto: cada subclase devuelve su tipo |

### `Estudiante` (extiende `Socio`)

| Elemento | Descripción |
|---|---|
| `carrera` | Carrera que cursa. Se consulta con `getCarrera()` |
| `Estudiante(dni, nombre, carrera)` | Constructor. Fija los días de préstamo mediante `super(...)` |
| `puedePedir()` | `true` si tiene menos de 3 libros en su poder y no tiene préstamos vencidos |
| `soyDeLaClase()` | Devuelve `"Estudiante"` |

### `Docente` (extiende `Socio`)

| Elemento | Descripción |
|---|---|
| `area` | Área en la que se desempeña. Se consulta con `getArea()` |
| `Docente(dni, nombre, area)` | Constructor. Inicia con 5 días de préstamo |
| `esResponsable()` | `true` si ninguno de sus préstamos está vencido a la fecha de hoy |
| `cambiarDiasDePrestamo(int)` | Suma días al plazo de préstamo del docente (premio a la responsabilidad) |
| `puedePedir()` | Delega en `Socio.puedePedir()`: sin límite de libros, solo no debe tener vencidos |
| `soyDeLaClase()` | Devuelve `"Docente"` |

### `Prestamo`

Atributos: `fechaRetiro`, `fechaDevolucion` (es `null` mientras el libro no se devuelve), `socio` y `libro`. Se crea con `Prestamo(fechaRetiro, socio, libro)`.

| Método | Descripción |
|---|---|
| `getFechaRetiro()`, `getFechaDevolucion()`, `getSocio()`, `getLibro()` | Consultas |
| `registrarFechaDevolucion(Calendar)` | Asigna la fecha de devolución |
| `vencido(Calendar fecha)` | `true` si `fecha` es posterior al vencimiento (retiro + días de préstamo del socio) |
| `toString()` | Retiro, devolución (o `N/A`), título del libro y nombre del socio |

### `Libro`

Atributos: `titulo`, `edicion`, `editorial`, `anio` y la ficha de `prestamos`. Se crea con `Libro(titulo, edicion, editorial, anio)`.

| Método | Descripción |
|---|---|
| `getTitulo()`, `getEdicion()`, `getEditorial()`, `getAnio()`, `getPrestamos()` | Consultas |
| `agregarPrestamo(Prestamo)` | Asienta un préstamo en la ficha del libro |
| `ultimoPrestamo()` | Último préstamo registrado, o `null` si no tiene historial |
| `prestado()` | `true` si el último préstamo todavía no tiene fecha de devolución |
| `toString()` | `Titulo: <titulo>` |

### `LibroNoPrestadoException`

Extiende `RuntimeException` y recibe un mensaje descriptivo. Se lanza cuando se intenta devolver un libro que no está prestado o consultar quién tiene un libro que no lo está.

### `Biblioteca`

Atributos: `nombre`, `libros` (`ArrayList<Libro>`) y `socios` (`ArrayList<Socio>`).

Constructores: solo con el nombre (vacía), con un libro inicial, con un socio inicial, con ambos, o con listas ya armadas de libros y socios.

| Método | Descripción |
|---|---|
| `nuevoLibro(titulo, edicion, editorial, anio)` | Crea un libro y lo agrega a la colección |
| `nuevoSocioEstudiante(dni, nombre, carrera)` | Crea un estudiante y lo agrega a los socios |
| `nuevoSocioDocente(dni, nombre, area)` | Crea un docente y lo agrega a los socios |
| `prestarLibro(fecha, socio, libro)` | Crea el préstamo y lo agrega a la ficha del libro y a la lista del socio. Devuelve `true` si ambas altas se concretaron |
| `devolverLibro(libro)` | Si el libro está prestado, asigna la fecha actual como devolución de su último préstamo. Si no, lanza `LibroNoPrestadoException` |
| `buscarSocio(dni)` | Devuelve el socio con ese D.N.I., o `null` |
| `cantidadDeSociosPorTipo(tipo)` | Cuenta los socios del tipo indicado (sin distinguir mayúsculas) |
| `prestamosVencidos()` | `ArrayList<Prestamo>` con los vencidos a la fecha de hoy |
| `docentesResponsables()` | `ArrayList<Docente>` con los docentes responsables |
| `quienTieneElLibro(libro)` | Texto con el nombre y D.N.I. del socio que tiene el libro. Si no está prestado, lanza `LibroNoPrestadoException` |
| `listaDeSocios()` | Listado numerado de socios con totales por tipo |
| `listaDeLibros()` | Listado numerado de libros indicando si están prestados |
| `listaDeTitulos()` | Títulos sin repetir (usa un `HashSet<String>`) |
| `listaDeDocentesResponsables()` | Listado de docentes responsables |

También expone `getNombre/setNombre`, `getLibros/setLibros` y `getSocios/setSocios`.

---

## 4. Clase `GestionBiblioteca` (programa principal)

Crea una biblioteca, la carga con datos de ejemplo y ofrece un menú por consola.

**Datos de ejemplo:** 16 libros, 4 docentes, 3 estudiantes y 3 préstamos vencidos.

| Socio | D.N.I. | Libro prestado | Retiro |
|---|---|---|---|
| Juan Perez (docente) | 32444552 | Effective Java | 22/10/2022 |
| Francisco Paenza (estudiante) | 28987498 | Python Crash Course | 22/07/2023 |
| Sebastian Taglia (docente) | 33492162 | Programando Con JAVA | 13/12/2023 |

**Menú**

| Opción | Acción | Método usado |
|---|---|---|
| `1` | Agregar socio | `nuevoSocioEstudiante` / `nuevoSocioDocente` |
| `2` | Agregar libro | `nuevoLibro` |
| `3` | Prestar libro | `prestarLibro` |
| `4` | Devolver libro | `devolverLibro` |
| `5` | Ver préstamos vencidos | `prestamosVencidos` |
| `6` | Docentes que no adeudan libros | `listaDeDocentesResponsables` |
| `7` | Buscar si un libro está prestado | `quienTieneElLibro` |
| `8` | Buscar socio por D.N.I. | `buscarSocio` |
| `9` | Lista de socios | `listaDeSocios` y `cantidadDeSociosPorTipo` |
| `10` | Cantidad de socios por tipo | `cantidadDeSociosPorTipo` |
| `11` | Lista de libros | `listaDeLibros` |
| `0` | Salir | — |

> Si ocurre una excepción (por ejemplo, escribir texto donde se espera un número, o devolver un libro que no está prestado), el programa muestra el error y termina. Hay que volver a ejecutarlo.

---

### 5. `BibliotecaGUI` (interfaz gráfica)

Ventana Swing que usa solo los métodos públicos del modelo. Tiene tres pestañas y un área de texto donde se muestran los resultados.

| Pestaña | Qué permite |
|---|---|
| **Libros** | Agregar libros, ver la lista de libros y la lista de títulos |
| **Socios** | Agregar estudiantes y docentes (sin D.N.I. repetidos), ver la lista de socios, los docentes responsables y la cantidad de socios por tipo |
| **Prestamos** | Prestar y devolver libros, ver quién tiene un libro, ver préstamos vencidos y consultar si un socio puede pedir |

Antes de prestar, la interfaz verifica que el libro no esté prestado y que el socio pueda pedir. Tiene su propio `main` y arranca con una biblioteca vacía.

---

## 6. Cómo compilar y ejecutar

**Requisito:** Java 8 o superior (JDK).

### Con BlueJ

1. Abrir BlueJ y elegir *Proyecto → Abrir proyecto…*, seleccionando la carpeta `Biblioteca`.
2. Compilar con el botón **Compilar**.
3. Clic derecho sobre la clase `GestionBiblioteca` y elegir `void main(String[] args)`.

### Con la terminal

Desde la carpeta que contiene a `Biblioteca/`:

```bash
javac Biblioteca/*.java
java Biblioteca.GestionBiblioteca
```

---

## 7. Guía de uso en BlueJ

### a. Abrir el proyecto

1. En BlueJ, ir a **Proyecto → Abrir proyecto…** y elegir la carpeta `Biblioteca`.
2. Si BlueJ no reconoce la carpeta como proyecto, usar la opción **Abrir proyecto no-BlueJ…** (*Open Non BlueJ…*) del mismo menú.
3. En pantalla aparece un cuadro por cada clase, con las flechas de herencia entre `Socio`, `Estudiante` y `Docente`.

### b. Compilar

Presionar el botón **Compilar** (o `Ctrl + K`). Mientras las clases tengan franjas rayadas, falta compilarlas. Si algún cuadro sigue rayado, hay un error: BlueJ lo muestra en la parte inferior de la ventana.

### c. Ejecutar el menú por consola

1. Clic derecho sobre la clase **`GestionBiblioteca`**.
2. Elegir **`void main(String[] args)`** y aceptar.
3. Se abre la **Terminal** de BlueJ con el menú. Escribir el número de la opción y presionar `Enter`.

Ejemplo de recorrido con los datos de ejemplo:

| Qué hacer | Pasos en la terminal |
|---|---|
| Prestar *Código Limpio* a Cesar Milstein | Opción `3` → D.N.I. `31987123` → número de libro `1` |
| Ver quién tiene ese libro | Opción `7` → número de libro `1` |
| Devolverlo | Opción `4` → número de libro `1` |
| Ver préstamos vencidos | Opción `5` |
| Salir | Opción `0` |

El número de libro es el que muestra la lista de libros (opción `11`).

### d. Ejecutar la interfaz gráfica

**Opción A: directa.** Clic derecho sobre **`BibliotecaGUI`** y elegir **`static void main(String[] args)`**. Se abre la ventana con una biblioteca vacía: primero hay que cargar libros y socios desde sus pestañas.

**Opción B: con datos propios (Banco de objetos).**

1. Clic derecho sobre `Biblioteca` → `new Biblioteca(String p_nombre)`. Escribir el nombre **entre comillas** (`"Biblioteca"`). Aparece un objeto rojo en el banco.
2. Clic derecho sobre ese objeto y llamar a `nuevoLibro(...)`, `nuevoSocioDocente(...)` o `nuevoSocioEstudiante(...)` para cargar datos. Los textos van entre comillas.
3. Clic derecho sobre `BibliotecaGUI` → `new BibliotecaGUI(Biblioteca p_biblioteca)` y escribir el nombre del objeto del banco (por ejemplo `biblioteca1`).
4. Clic derecho sobre el nuevo objeto de la interfaz y llamar a **`void abrir()`**. La ventana se muestra con los datos cargados.

---

## 8. Organización del equipo

El equipo se dividió en cuatro subgrupos que trabajaron de forma independiente, y la clase `GestionBiblioteca` se resolvió entre los seis integrantes.

| Subgrupo | Clases | Integrantes |
|---|---|---|
| Primero | `Prestamo`, `Socio` | <a href="https://github.com/BRbenjamin"><img src="https://upload.wikimedia.org/wikipedia/commons/9/91/Octicons-mark-github.svg" width="16"> Romero, Benjamin</a> |
| Segundo | `Estudiante`, `Docente` | <a href="https://github.com/VeroSGV"><img src="https://upload.wikimedia.org/wikipedia/commons/9/91/Octicons-mark-github.svg" width="16"> Gomez Varela, Verónica</a> |
| Tercero | `Libro` | <a href="https://github.com/vnahuel454"><img src="https://upload.wikimedia.org/wikipedia/commons/9/91/Octicons-mark-github.svg" width="16"> Villagra, Facundo Nahuel</a> |
| Cuarto | `Biblioteca` | <a href="https://github.com/SapioLucianoA"><img src="https://upload.wikimedia.org/wikipedia/commons/9/91/Octicons-mark-github.svg" width="16"> Sapio, Luciano</a> · <a href="https://github.com/appsgustin-rgb"><img src="https://upload.wikimedia.org/wikipedia/commons/9/91/Octicons-mark-github.svg" width="16"> Romero, Agustín</a> · <a href="https://github.com/MaxigabVeglia"><img src="https://upload.wikimedia.org/wikipedia/commons/9/91/Octicons-mark-github.svg" width="16"> Veglia, Marcos</a> |
| Equipo completo | `GestionBiblioteca` | Los seis integrantes |

La planificación y el seguimiento de tareas se hicieron con **Trello**.

---

## 9. Trabajo con Git

<!-- Reemplazar o completar con los pasos que el equipo ya tiene en el README.TXT -->

Flujo básico para trabajar en equipo:

```bash
git clone (https://github.com/SapioLucianoA/TP7-Biblioteca/     # una sola vez, para descargar el proyecto
git pull                                                        # antes de empezar a trabajar: traer los cambios del resto
git add <archivo>                                               # agregar los archivos modificados
git commit -m "mensaje descriptivo"                             # guardar los cambios con un mensaje claro
git push                                                        # subir los cambios al repositorio
```
---

## 10. Cosas a mejorar

| Mejora | Detalle |
|---|---|
| **Base de datos relacional** | Guardar libros, socios y préstamos para que no se pierdan al cerrar el programa) |
| **Identificar ejemplares** | Los libros se eligen por su posición en la lista. Agregar un código por ejemplar (por ejemplo, ISBN o inventario) |
| **Pruebas automáticas** | Agregar pruebas unitarias con JUnit para las reglas de préstamo |
