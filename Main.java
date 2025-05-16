import java.util.ArrayList;
import java.util.Scanner;

// Clase principal del programa
public class Main {
    // Lista que almacena objetos de tipo Articulo
    static ArrayList<Articulo> lista = new ArrayList<>();
    // Scanner para entrada de datos por consola
    static Scanner sc = new Scanner(System.in);

    // Método principal ----------------------------------------------------------------------
    public static void main(String[] args) {
        int opcion;
        // Bucle principal del programa con menú interactivo
        do {
            System.out.println("\n-\u2630- Menú de Artículos -\u2630-");
            System.out.println(" \u2714 1. Crear artículo");
            System.out.println("\uD83D\uDCCB 2. Listar artículos");
            System.out.println("\u270F\uFE0F 3. Modificar artículo ");
            System.out.println("\u274C 4. Eliminar artículo");
            System.out.println("\uD83D\uDCBE 5. Cargar lista preestablecida");
            System.out.println("\uD83D\uDEAA 6. Salir \n");
            System.out.print("\uD83D\uDC49 Seleccione una opción: ");
            opcion = sc.nextInt();         // Leer opción del usuario
            sc.nextLine();                 // Limpiar buffer del scanner

            // Estructura switch para manejar las opciones
            switch (opcion) {
                case 1 -> crearArticulo();
                case 2 -> listarArticulos();
                case 3 -> modificarArticulo();
                case 4 -> eliminarArticulo();
                case 5 -> cargarListaPreestablecida();
                case 6 -> System.out.println("Saliendo...\uD83D\uDEAA");
                default -> System.out.println("\u274C Opción inválida");
            }
        } while (opcion != 6); // Repetir hasta que el usuario elija salir
    }

    // Método para crear un nuevo artículo----------------------------------------------
    public static void crearArticulo() {
        System.out.println("\n-\u2714- Crear Artículos -\u2714-");
        //INGRESO ID
        int id = validarID();
        System.out.println("   \u279C ID agregado \uD83D\uDCCB\u2714\n");
        //INGRESO NOMBRE
        String nombre = validarNombre();
        System.out.println("   \u279C NOMBRE agregado \uD83D\uDCCB\u2714\n");
        //INGRESO PRECIO
        String precio = validarPrecio();
        System.out.println("   \u279C PRECIO agregado \uD83D\uDCCB\u2714\n");

        // Crear un nuevo objeto Articulo y agregarlo a la lista
        Articulo nuevo = new Articulo(id, nombre.toUpperCase(), Double.parseDouble(precio));
        lista.add(nuevo);
        System.out.println(" \u279C\uD83D\uDCCB\u2714 Artículo agregado.");
    } // Fin de métodp principal--------------------------------------------------------------

    // Método para mostrar todos los artículos de la lista -----------------------------------
    public static void listarArticulos() {
        System.out.println("\n-\uD83D\uDCCB- Lista de Artículos -\uD83D\uDCCB");
        if (lista.isEmpty()) {//Si lista vacía...
            System.out.println("\u274C No hay artículos cargados \uD83D\uDE15"); //...Muesta mensaje
        } else { //Si la lista no está vacía
            for (Articulo articuloEnLista : lista) { // Recorre la lista y accede a cada instancia asignándole el nombre articuloEnLista a cada uno.
                articuloEnLista.mostrar();   // Llamada polimórfica al método mostrar()
            }
        }
    }

    // Método para modificar un artículo existente -------------------------------------------
    public static void modificarArticulo() {
        System.out.print("\uD83D\uDD04 Artículo a modificar: \n");
        int id = validarIDEditarYModificar(); //Método para validación numérica de ingreso por consola - línea 134
        for (Articulo articulo : lista) {
            if (articulo.getId() == id) {

                System.out.print("\uD83D\uDD04 Nuevo nombre: ");
                articulo.setNombre(sc.nextLine().toUpperCase());   // Usar setter para cambiar nombre
                System.out.print("\uD83D\uDD04 Nuevo precio: ");
                articulo.setPrecio(sc.nextDouble()); // Usar setter para cambiar precio
                System.out.println(" \u279C\uD83D\uDCCB\u2714 Artículo actualizado.");
                return;
            }
        }
        System.out.println("\u274C Artículo no encontrado \uD83D\uDE15");
    }

    // Método para eliminar un artículo por ID ------------------------------------------------
    public static void eliminarArticulo() {
        System.out.print("\u274C Artículo a eliminar: \n");
        int id = validarIDEditarYModificar(); //Método para validación numérica de ingreso por consola - línea 134
        for (Articulo articulo : lista) {
            if (articulo.getId() == id) {
                System.out.println("Ud. quiere eliminar el Artículo: ID: " + articulo.getId() + " | Nombre: " + articulo.getNombre() + " | Precio: $" + articulo.getPrecio() + " ?");
                System.out.println("\u270F\uFE0F SI / NO");
                String respuesta = sc.nextLine();
                if (respuesta.equalsIgnoreCase("si")) {
                    lista.removeIf(a -> a.getId() == id); // Usamos removeIf con expresión lambda para eliminar por ID
                    System.out.println("\n \u279C\uD83D\uDCCB\u2714\u274C Artículo eliminado");
                }
                return;
            }
        }
        System.out.println("\n \u274C Artículo no encontrado \uD83D\uDE15");
    }

    //Método para cargar artículos --------------------------------------------------------
    public static void cargarListaPreestablecida() {
        System.out.println("\n-\uD83D\uDCBE- Artículos cargados -\uD83D\uDCBE-");
        lista.add(new Articulo(100, "Cafe", 200.00));
        lista.add(new Articulo(101, "Harina", 250.00));
        lista.add(new Articulo(102, "Palmitos", 350.50));
        lista.add(new Articulo(103, "Yerba", 150));
        lista.add(new Articulo(104, "mermelada", 200.00));
        lista.add(new Articulo(105, "Cacao", 125.00));
        lista.add(new Articulo(106, "picadillo", 100.60));
        lista.add(new Articulo(107, "Pate", 100.00));
        lista.add(new Articulo(108, "caballa", 130.00));
        lista.add(new Articulo(109, "Arroz", 170.00));
        lista.add(new Articulo(110, "arvejas", 250.00));
        lista.add(new Articulo(111, "Sardinas", 400.30));
        lista.add(new Articulo(112, "atun", 345.23));
        lista.add(new Articulo(113, "Choclo", 160.33));
        lista.add(new Articulo(114, "lentejas", 250.00));

        listarArticulos();
    }

    //VALIDACIONES -----------------------------------------------------------------------------

    //Método que valida el ingreso por consola de Id para ingresar artículo ---------------------
    public static int validarID() {
        String id = "";
        int contador = 0; // Se inicializa en 0 para que la primera vez del do while vaya al else. Si contador mayor a 0, pasa a los if de errores de ingreso.
        do {
            if (contador > 0) { //Se inicia en 1 cuando los las validaciones de do while fallan **
                if (id.length() > 4) {
                    System.out.print("\u274C Debe ingresar sólo 4 números: ");
                }else if (id.isEmpty()) {
                    System.out.print("\u274C El ID no debe estar vacío: ");
                } else if (!id.matches("^[0-9]+$")) {
                    System.out.print("\u274C El ID solo debe contener números: ");
                } else if (existeId(Integer.parseInt(id))) {
                    System.out.print("\u274C El ID ya se encuentra asignado: ");
                } else {
                    break; // ID válido
                }
            } else {
                System.out.print("\u270F\uFE0F Ingrese un ID: ");
            }
            id = sc.nextLine();
            contador++;
        } while (id.isEmpty() || !id.matches("^[0-9]+$") || existeId(Integer.parseInt(id))); // ** validaciones
        return Integer.parseInt(id);
    }

    //Método que valida el ingreso por consola de Id Para editar y modificar artículo --------------
    public static int validarIDEditarYModificar() {
        String id = "";
        int contador = 0; // Se inicializa en 0 para que la primera vez del do while vaya al else. Si contador mayor a 0, pasa a los if de errores de ingreso.
        do {
            if (contador > 0) { //Se inicia en 1 cuando los las validaciones de do while fallan **
                if (id.length() > 4) {
                    System.out.print("\u274C Debe ingresar sólo 4 números: ");
                }else if (id.isEmpty()) {
                    System.out.print("\u274C El ID no debe estar vacío: ");
                } else if (!id.matches("^[0-9]+$")) {
                    System.out.print("\u274C El ID solo debe contener números: ");
                } else {
                    break; // ID válido
                }
            } else {
                System.out.print("\u270F\uFE0F Ingrese un ID: ");
            }
            id = sc.nextLine();
            contador++;
        } while (id.isEmpty() || !id.matches("^[0-9]+$") || existeId(Integer.parseInt(id))); // ** validaciones
        return Integer.parseInt(id);
    }

    // Método que verifica si existe Id ------------------------------------------------------
    public static boolean existeId(int id) {
        for (Articulo articuloId : lista) {
            if (articuloId.getId() == id) {
                return true;
            }
        }
        return false;
    }

    //Método que valida ingreso por consola de Nombre de artículo -----------------------------
    public static String validarNombre() {
        String nombre = "";
        int contadorNombre = 0; // Se inicializa en 0 para que la primera vez del do while vaya al else. Si contador mayor a 0, pasa a los if de errores de ingreso.
        do {
            if (contadorNombre > 0) { //Se inicia en 1 cuando los las validaciones de do while fallan **
                if (nombre.length() > 10) {
                    System.out.print("\u274C El Nombre es demasiado largo, ingrese menos de 10 caracteres: ");
                } else if (nombre.isEmpty()) {
                    System.out.print("\u274C El Nombre no debe estar vacío: ");
                } else if (!nombre.matches("^[a-zA-Z\\s]+$")) {
                    System.out.print("\u274C El Nombre solo debe contener letras: ");
                } else if (existeNombre(nombre)){
                    System.out.print("\u274C El Nombre ya se encuentra asignado: ");
                }else{
                    break; // Nombre válido
                }
            } else {
                System.out.print("\u270F\uFE0F Ingrese un Nombre: ");
            }
            nombre = sc.nextLine().toUpperCase();
            contadorNombre++;
        } while (nombre.length() > 10 || nombre.isEmpty() || !nombre.matches("^[a-zA-Z\\s]+$") || existeNombre(nombre));// ** validaciones
        return nombre;
    }

    // Metodo que verifica si existe Nombre ----------------------------------------------------
    public static boolean existeNombre(String nombre){
        for (Articulo articuloNombre : lista) {
            if (articuloNombre.getNombre().equalsIgnoreCase(nombre)){
                return true;
            }
        }
        return false;
    }

    //Método que valida el ingreso por consola de Precio ----------------------------------------
    public static String validarPrecio() {
        String ingresoPrecio = "";
        int contadorPrecio = 0;
        do {
            if (contadorPrecio > 0) {
                if (ingresoPrecio.isEmpty()) {
                    System.out.print("\u274C El Precio no puede estar vacío; ");
                } else if (!ingresoPrecio.matches("^[0-9,.$]*$")) {
                    System.out.print("\u274C Debe ingresar valores numéricos: ");
                }
            } else {
                System.out.print("\u270F\uFE0F Precio: ");
            }
            ingresoPrecio = sc.nextLine().replace(',', '.');
            contadorPrecio++;
        } while (!ingresoPrecio.matches("^[0-9,.$]*$") || ingresoPrecio.isEmpty());
        return ingresoPrecio;
    }
}
