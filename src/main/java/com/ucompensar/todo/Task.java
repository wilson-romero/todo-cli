package com.ucompensar.todo;

/**
 * Modelo de datos que representa una tarea en la lista de pendientes.
 *
 * <p>Cada tarea tiene una descripción textual y un estado que indica
 * si ya fue completada o sigue pendiente.</p>
 */
public class Task {

    /** Texto descriptivo de la tarea. */
    private String description;

    /** Indica si la tarea fue completada (true) o está pendiente (false). */
    private boolean completed;
}
