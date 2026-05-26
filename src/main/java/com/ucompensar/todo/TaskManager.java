package com.ucompensar.todo;

import de.vandermeer.asciitable.AsciiTable;

import java.util.ArrayList;
import java.util.List;

/**
 * Gestor de tareas: contiene toda la lógica de negocio y el menú principal.
 *
 * <p>Todos los métodos son estáticos; la clase actúa como módulo de utilidades
 * y punto de entrada de la aplicación.</p>
 */
public class TaskManager {

    // ===================================================================
    // INICIALIZACIÓN
    // ===================================================================

    /**
     * Crea y retorna la lista inicial de tareas precargadas.
     *
     * <p>Método sin parámetros con retorno — demuestra función pura.</p>
     *
     * @return lista con 3 tareas de ejemplo
     */
    public static List<Task> getTasks() {
        List<Task> tasks = new ArrayList<>();
        tasks.add(new Task("Comprar leche", false));
        tasks.add(new Task("Hacer ejercicio", true));
        tasks.add(new Task("Llamar al médico", false));
        return tasks;
    }

    // ===================================================================
    // VISUALIZACIÓN
    // ===================================================================

    /**
     * Muestra la lista de tareas en una tabla con bordes usando AsciiTable.
     *
     * <p>Método con parámetros sin retorno — procedimiento de visualización.</p>
     *
     * @param tasks lista de tareas a mostrar
     */
    public static void displayTasks(List<Task> tasks) {
        if (tasks.isEmpty()) {
            System.out.println("No hay tareas registradas.");
            return;
        }

        // Construye la tabla con columnas: número, estado, descripción
        AsciiTable table = new AsciiTable();
        table.addRule();
        table.addRow("#", "Estado", "Descripción");
        table.addRule();

        for (int i = 0; i < tasks.size(); i++) {
            Task task = tasks.get(i);
            String status = task.isCompleted() ? "[X]" : "[ ]";
            table.addRow(i + 1, status, task.getDescription());
        }

        table.addRule();
        System.out.println(table.render());
    }

    // ===================================================================
    // AGREGAR TAREA
    // ===================================================================

    /**
     * Crea una nueva tarea y la añade al final de la lista.
     *
     * <p>Método con parámetros y con retorno — demuestra función que
     * modifica y devuelve la colección.</p>
     *
     * @param tasks       lista actual de tareas
     * @param description texto descriptivo de la nueva tarea
     * @return lista con la nueva tarea incluida
     */
    public static List<Task> addTask(List<Task> tasks, String description) {
        // La nueva tarea siempre inicia como pendiente (completed = false)
        tasks.add(new Task(description, false));
        System.out.println("¡Tarea agregada!");
        return tasks;
    }

    // ===================================================================
    // MARCAR COMO COMPLETADA
    // ===================================================================

    /**
     * Marca como completada la tarea en la posición indicada por el usuario.
     *
     * <p>Método con parámetros sin retorno — procedimiento que modifica
     * la lista original. La posición recibida es 1-based (como la ve el
     * usuario en pantalla); internamente se convierte a 0-based.</p>
     *
     * @param tasks    lista de tareas
     * @param position número de tarea mostrado al usuario (empieza en 1)
     */
    public static void markCompleted(List<Task> tasks, int position) {
        try {
            // Convierte posición visible (1-based) a índice interno (0-based)
            int index = position - 1;
            Task task = tasks.get(index);
            task.setCompleted(true);
            System.out.println("¡Tarea '" + task.getDescription() + "' marcada como completada!");
        } catch (IndexOutOfBoundsException e) {
            // Informa al usuario sin romper el programa
            System.out.println("Posición inválida. Por favor ingresa un número de la lista.");
        }
    }
}
