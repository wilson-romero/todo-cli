package com.ucompensar.todo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * Modelo de datos que representa una tarea en la lista de pendientes.
 *
 * <p>Cada tarea tiene una descripción textual y un estado que indica
 * si ya fue completada o sigue pendiente.</p>
 *
 * <p>Lombok genera automáticamente getters, setters y el constructor
 * de todos los campos, reduciendo el código repetitivo (boilerplate).</p>
 */
@Getter
@Setter
@AllArgsConstructor
public class Task {

    /** Texto descriptivo de la tarea. */
    private String description;

    /** Indica si la tarea fue completada (true) o está pendiente (false). */
    private boolean completed;
}
