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
}
