package Biblioteca;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Calendar;

/**
 * Interfaz gráfica (Swing) para la clase Biblioteca.
 * Permite agregar libros y socios, prestar y devolver libros, y consultar
 * listados, utilizando únicamente los métodos públicos de las clases del modelo.
 * Los resultados se muestran en un área de texto ubicada en la parte inferior.
 * 
 * @author (Sapio Luciano / Agustin Romero)
 * @version 1.0
 */
public class BibliotecaGUI extends JFrame {

    /** Modelo con el que interactúa la interfaz. */
    private Biblioteca biblioteca;

    /** Área de texto donde se muestran los resultados de cada operación. */
    private JTextArea salida;
    /** Lista desplegable con los socios registrados. */
    private JComboBox<Socio> cmbSocios;
    /** Lista desplegable con los libros de la biblioteca. */
    private JComboBox<Libro> cmbLibros;

    // Pestaña Libros
    /** Campo de texto para el título del libro. */
    private JTextField txtTitulo;
    /** Campo de texto para la edición del libro. */
    private JTextField txtEdicion;
    /** Campo de texto para la editorial del libro. */
    private JTextField txtEditorial;
    /** Campo de texto para el año de publicación del libro. */
    private JTextField txtAnio;

    // Pestaña Socios
    /** Campo de texto para el DNI del socio. */
    private JTextField txtDni;
    /** Campo de texto para el nombre del socio. */
    private JTextField txtNombre;
    /** Campo de texto para la carrera (Estudiante) o el área (Docente). */
    private JTextField txtExtra;
    /** Lista para elegir el tipo de socio a crear. */
    private JComboBox<String> cmbTipo;
    /** Lista para elegir el tipo de socio a contar. */
    private JComboBox<String> cmbTipoContar;

    /**
     * Constructor con una biblioteca existente.
     * Arma la ventana y carga los combos con los datos de la biblioteca recibida.
     * La ventana queda oculta hasta invocar setVisible(true) o abrir().
     * 
     * @param p_biblioteca La biblioteca que será manejada por la interfaz.
     */
    public BibliotecaGUI(Biblioteca p_biblioteca) {
        super("Biblioteca: " + p_biblioteca.getNombre());
        this.biblioteca = p_biblioteca;
        this.armarVentana();
        this.refrescarCombos();
    }

    /**
     * Constructor por defecto.
     * Crea una biblioteca vacía y muestra la ventana de inmediato.
     */
    public BibliotecaGUI() {
        this(new Biblioteca("Biblioteca"));
        this.setVisible(true);
    }

    /**
     * Punto de entrada del programa.
     * Crea la ventana en el hilo de eventos de Swing.
     * 
     * @param args Argumentos de línea de comandos (no se utilizan).
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new BibliotecaGUI().setVisible(true);
            }
        });
    }

    /**
     * Vuelve a mostrar la ventana si fue cerrada.
     * Los datos de la biblioteca se conservan mientras el objeto exista.
     */
    public void abrir() {
        this.setVisible(true);
    }

    // ---------------- ARMADO ----------------

    /**
     * Configura la ventana principal: tamaño, posición y distribución.
     * Ubica las pestañas arriba, el área de salida al centro 
     * y el botón de limpieza abajo.
     */
    private void armarVentana() {
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(760, 560);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(5, 5));

        JTabbedPane tabs = new JTabbedPane();
        tabs.addTab("Libros", panelLibros());
        tabs.addTab("Socios", panelSocios());
        tabs.addTab("Prestamos", panelPrestamos());
        add(tabs, BorderLayout.NORTH);

        salida = new JTextArea();
        salida.setEditable(false);
        salida.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 12));
        add(new JScrollPane(salida), BorderLayout.CENTER);

        JButton limpiar = new JButton("Limpiar salida");
        limpiar.addActionListener(e -> salida.setText(""));
        add(limpiar, BorderLayout.SOUTH);
    }

    /**
     * Construye la pestaña de libros.
     * Incluye los campos para cargar un libro y los botones 
     * para agregarlo y listar libros y títulos.
     * 
     * @return El panel de la pestaña Libros.
     */
    private JPanel panelLibros() {
        JPanel p = new JPanel(new GridLayout(0, 2, 4, 4));
        txtTitulo = new JTextField();
        txtEdicion = new JTextField();
        txtEditorial = new JTextField();
        txtAnio = new JTextField();

        p.add(new JLabel("Titulo:"));    p.add(txtTitulo);
        p.add(new JLabel("Edicion:"));   p.add(txtEdicion);
        p.add(new JLabel("Editorial:")); p.add(txtEditorial);
        p.add(new JLabel("Anio:"));      p.add(txtAnio);

        JButton agregar = new JButton("Agregar libro");
        agregar.addActionListener(e -> agregarLibro());
        JButton listar = new JButton("Lista de libros");
        listar.addActionListener(e -> escribir(biblioteca.listaDeLibros()));
        JButton titulos = new JButton("Lista de titulos");
        titulos.addActionListener(e -> escribir("Titulos:\n" + biblioteca.listaDeTitulos()));

        p.add(agregar);
        p.add(listar);
        p.add(titulos);
        p.add(new JLabel(""));
        return p;
    }

    /**
     * Construye la pestaña de socios.
     * Incluye los campos para cargar un socio (Estudiante o Docente) 
     * y los botones para agregarlo, listar socios, listar docentes 
     * responsables y contar socios por tipo.
     * 
     * @return El panel de la pestaña Socios.
     */
    private JPanel panelSocios() {
        JPanel p = new JPanel(new GridLayout(0, 2, 4, 4));
        txtDni = new JTextField();
        txtNombre = new JTextField();
        txtExtra = new JTextField();
        cmbTipo = new JComboBox<String>(new String[] { "Estudiante", "Docente" });
        cmbTipoContar = new JComboBox<String>(new String[] { "Estudiante", "Docente" });

        p.add(new JLabel("Tipo:"));              p.add(cmbTipo);
        p.add(new JLabel("DNI:"));               p.add(txtDni);
        p.add(new JLabel("Nombre:"));            p.add(txtNombre);
        p.add(new JLabel("Carrera / Area:"));    p.add(txtExtra);

        JButton agregar = new JButton("Agregar socio");
        agregar.addActionListener(e -> agregarSocio());
        JButton listar = new JButton("Lista de socios");
        listar.addActionListener(e -> escribir(biblioteca.listaDeSocios()));
        JButton resp = new JButton("Docentes responsables");
        resp.addActionListener(e -> escribir(biblioteca.listaDeDocentesResponsables()));
        JButton contar = new JButton("Cantidad por tipo ->");
        contar.addActionListener(e -> {
            String t = (String) cmbTipoContar.getSelectedItem();
            escribir("Socios tipo " + t + ": " + biblioteca.cantidadDeSociosPorTipo(t));
        });

        p.add(agregar);
        p.add(listar);
        p.add(resp);
        JPanel pc = new JPanel(new GridLayout(1, 2));
        pc.add(contar);
        pc.add(cmbTipoContar);
        p.add(pc);
        return p;
    }

    /**
     * Construye la pestaña de préstamos.
     * Incluye los combos de socio y libro, y los botones para prestar, 
     * devolver, consultar quién tiene un libro, ver préstamos vencidos 
     * y verificar si un socio puede pedir libros.
     * 
     * @return El panel de la pestaña Préstamos.
     */
    private JPanel panelPrestamos() {
        JPanel p = new JPanel(new GridLayout(0, 2, 4, 4));
        cmbSocios = new JComboBox<Socio>();
        cmbLibros = new JComboBox<Libro>();

        p.add(new JLabel("Socio:")); p.add(cmbSocios);
        p.add(new JLabel("Libro:")); p.add(cmbLibros);

        JButton prestar = new JButton("Prestar libro");
        prestar.addActionListener(e -> prestar());
        JButton devolver = new JButton("Devolver libro");
        devolver.addActionListener(e -> devolver());
        JButton quien = new JButton("Quien tiene el libro");
        quien.addActionListener(e -> quienTiene());
        JButton vencidos = new JButton("Prestamos vencidos");
        vencidos.addActionListener(e -> vencidos());
        JButton puede = new JButton("Socio puede pedir?");
        puede.addActionListener(e -> puedePedir());

        p.add(prestar);
        p.add(devolver);
        p.add(quien);
        p.add(vencidos);
        p.add(puede);
        p.add(new JLabel(""));
        return p;
    }

    // ---------------- ACCIONES ----------------

    /**
     * Lee los campos de la pestaña Libros y agrega el libro a la biblioteca.
     * Informa en la salida si faltan datos o si edición y año no son numéricos.
     */
    private void agregarLibro() {
        try {
            String titulo = txtTitulo.getText().trim();
            String editorial = txtEditorial.getText().trim();
            if (titulo.isEmpty() || editorial.isEmpty()) {
                escribir("Falta titulo o editorial.");
                return;
            }
            int edicion = Integer.parseInt(txtEdicion.getText().trim());
            int anio = Integer.parseInt(txtAnio.getText().trim());
            biblioteca.nuevoLibro(titulo, edicion, editorial, anio);
            escribir("Libro agregado: " + titulo);
            txtTitulo.setText("");
            txtEdicion.setText("");
            txtEditorial.setText("");
            txtAnio.setText("");
            refrescarCombos();
        } catch (NumberFormatException ex) {
            escribir("Edicion y anio deben ser numeros.");
        }
    }

    /**
     * Lee los campos de la pestaña Socios y agrega un Estudiante o un Docente 
     * según el tipo elegido. No permite DNI repetidos.
     * Informa en la salida si faltan datos o si el DNI no es numérico.
     */
    private void agregarSocio() {
        try {
            int dni = Integer.parseInt(txtDni.getText().trim());
            String nombre = txtNombre.getText().trim();
            String extra = txtExtra.getText().trim();
            if (nombre.isEmpty() || extra.isEmpty()) {
                escribir("Falta nombre o carrera/area.");
                return;
            }
            if (biblioteca.buscarSocio(dni) != null) {
                escribir("Ya existe socio con DNI " + dni + ".");
                return;
            }
            if (cmbTipo.getSelectedItem().equals("Estudiante")) {
                biblioteca.nuevoSocioEstudiante(dni, nombre, extra);
            } else {
                biblioteca.nuevoSocioDocente(dni, nombre, extra);
            }
            escribir("Socio agregado: " + nombre + " (" + dni + ")");
            txtDni.setText("");
            txtNombre.setText("");
            txtExtra.setText("");
            refrescarCombos();
        } catch (NumberFormatException ex) {
            escribir("DNI debe ser numero.");
        }
    }

    /**
     * Presta el libro seleccionado al socio seleccionado con la fecha actual.
     * Antes de prestar verifica que el libro no esté prestado 
     * y que el socio pueda pedir libros.
     */
    private void prestar() {
        Socio socio = (Socio) cmbSocios.getSelectedItem();
        Libro libro = (Libro) cmbLibros.getSelectedItem();
        if (socio == null || libro == null) {
            escribir("Elegir socio y libro.");
            return;
        }
        if (libro.prestado()) {
            escribir("Libro ya prestado: " + libro.getTitulo());
            return;
        }
        if (!socio.puedePedir()) {
            escribir(socio.getNombre() + " no puede pedir libros.");
            return;
        }
        if (biblioteca.prestarLibro(Calendar.getInstance(), socio, libro)) {
            escribir("Prestado: " + libro.getTitulo() + " -> " + socio.getNombre());
        } else {
            escribir("No se pudo prestar.");
        }
        refrescarCombos();
    }

    /**
     * Devuelve el libro seleccionado y quita el préstamo de la lista de su socio.
     * Si el libro no estaba prestado, muestra el mensaje de la 
     * excepción LibroNoPrestadoException.
     */
    private void devolver() {
        Libro libro = (Libro) cmbLibros.getSelectedItem();
        if (libro == null) {
            escribir("Elegir libro.");
            return;
        }
        try {
            Prestamo prestamo = libro.ultimoPrestamo();
            biblioteca.devolverLibro(libro);
            // saca el prestamo de la lista del socio (ya no esta en su poder)
            prestamo.getSocio().removePrestamo(prestamo);
            escribir("Devuelto: " + libro.getTitulo());
        } catch (LibroNoPrestadoException ex) {
            escribir(ex.getMessage());
        }
        refrescarCombos();
    }

    /**
     * Muestra qué socio tiene el libro seleccionado.
     * Si el libro no está prestado, muestra el mensaje de la excepción.
     */
    private void quienTiene() {
        Libro libro = (Libro) cmbLibros.getSelectedItem();
        if (libro == null) {
            escribir("Elegir libro.");
            return;
        }
        try {
            escribir(biblioteca.quienTieneElLibro(libro));
        } catch (LibroNoPrestadoException ex) {
            escribir(ex.getMessage());
        }
    }

    /**
     * Muestra todos los préstamos vencidos de la biblioteca, 
     * o un aviso si no hay ninguno.
     */
    private void vencidos() {
        ArrayList<Prestamo> lista = biblioteca.prestamosVencidos();
        if (lista.isEmpty()) {
            escribir("No hay prestamos vencidos.");
            return;
        }
        StringBuilder sb = new StringBuilder("Prestamos vencidos:");
        for (Prestamo p : lista) {
            sb.append(p.toString());
        }
        escribir(sb.toString());
    }

    /**
     * Informa si el socio seleccionado puede pedir libros.
     */
    private void puedePedir() {
        Socio socio = (Socio) cmbSocios.getSelectedItem();
        if (socio == null) {
            escribir("Elegir socio.");
            return;
        }
        escribir(socio.getNombre() + (socio.puedePedir() ? " PUEDE pedir." : " NO puede pedir."));
    }

    // ---------------- AUXILIARES ----------------

    /**
     * Vacía y vuelve a llenar los combos de socios y libros 
     * con los datos actuales de la biblioteca.
     */
    private void refrescarCombos() {
        cmbSocios.removeAllItems();
        for (Socio s : biblioteca.getSocios()) {
            cmbSocios.addItem(s);
        }
        cmbLibros.removeAllItems();
        for (Libro l : biblioteca.getLibros()) {
            cmbLibros.addItem(l);
        }
    }

    /**
     * Agrega un texto al final del área de salida y desplaza la vista hasta él.
     * 
     * @param texto El mensaje a mostrar.
     */
    private void escribir(String texto) {
        salida.append(texto + "\n\n");
        salida.setCaretPosition(salida.getDocument().getLength());
    }
}