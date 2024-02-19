import java.util.Scanner;

public class ListaEnlazada {

    private Nodo<Integer> cabeza;
    private int tamanio;
    private Scanner scanner;

    public ListaEnlazada() {
        cabeza = null;
        tamanio = 0;
        scanner = new Scanner(System.in);
    }

    public void menu() {
        System.out.println("\nLista enlazada");
        System.out.println("1. Insertar al inicio");
        System.out.println("2. Insertar al final");
        System.out.println("3. Recorrer");
        System.out.println("4. Buscar elemento");
        System.out.println("5. Borrar un elemento");
        System.out.println("6. Salir");
        System.out.print("Ingrese su elección: ");
        int opcion = scanner.nextInt();

        switch (opcion) {
            case 1:
                insertarAlInicio(opcion);
                break;
            case 2:
                insertarAlFinal(opcion);
                break;
            case 3:
                recorrer();
                break;
            case 4:
                buscarElemento(opcion);
                break;
            case 5:
                borrarElemento(opcion);
                break;
            case 6:
                System.out.println("Saliendo del programa...");
                break;
            default:
                System.out.println("Opción inválida.");
        }
    }

    private void insertarAlInicio(int valor) {
        Nodo<Integer> nuevoNodo = new Nodo<>(valor);
        nuevoNodo.siguiente = cabeza;
        cabeza = nuevoNodo;
        tamanio++;
    }

    private void insertarAlFinal(int valor) {
        Nodo<Integer> nuevoNodo = new Nodo<>(valor);
        if (cabeza == null) {
            cabeza = nuevoNodo;
        } else {
            Nodo<Integer> actual = cabeza;
            while (actual.siguiente != null) {
                actual = actual.siguiente;
            }
            actual.siguiente = nuevoNodo;
        }
        tamanio++;
    }

    private void recorrer() {
        if (cabeza == null) {
            System.out.println("La lista está vacía.");
            return;
        }

        System.out.println("Elementos de la lista:");
        Nodo<Integer> actual = cabeza;
        while (actual != null) {
            System.out.println(actual.valor);
            actual = actual.siguiente;
        }
    }

    private int buscarElemento(int valor) {
        if (cabeza == null) {
            return -1;
        }

        int posicion = 0;
        Nodo<Integer> actual = cabeza;
        while (actual != null && actual.valor != valor) {
            actual = actual.siguiente;
            posicion++;
        }

        if (actual == null) {
            return -1;
        } else {
            return posicion;
        }
    }

    private void borrarElemento(int posicion) {
        if (cabeza == null) {
            System.out.println("La lista está vacía.");
            return;
        }

        if (posicion < 0 || posicion >= tamanio) {
            System.out.println("Posición inválida.");
            return;
        }

        if (posicion == 0) {
            cabeza = cabeza.siguiente;
        } else {
            Nodo<Integer> anterior = null;
            Nodo<Integer> actual = cabeza;
            for (int i = 0; i < posicion; i++) {
                anterior = actual;
                actual = actual.siguiente;
            }
            anterior.siguiente = actual.siguiente;
        }
        tamanio--;
    }

    public static void main(String[] args) {
        ListaEnlazada programa = new ListaEnlazada();

        while (true) {
            programa.menu();
            if (!programa.scanner.hasNextInt()) {
                programa.scanner.next(); // Limpiar buffer para evitar entrada no válida
            }
        }
    }
}

class Nodo<T> {

    T valor;
    Nodo<T> siguiente;

    public Nodo(T valor) {
        this.valor = valor;
        this.siguiente = null;
    }
}
