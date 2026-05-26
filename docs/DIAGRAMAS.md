# Diagramas de flujo — todo-cli

Diagramas Mermaid para cada método principal de `TaskManager.java`.

---

## 1. Menú principal — `main()`

```mermaid
flowchart TD
    A([Inicio]) --> B[tasks = getTasks]
    B --> C{running = true}
    C --> D[printMenu]
    D --> E[Leer opción]
    E --> F{opción válida?}
    F -- no numérica --> G[Por favor ingresa un número válido]
    G --> D
    F -- numérica --> H{switch opción}
    H -- 1 --> I[displayTasks]
    H -- 2 --> J[Leer descripción\naddTask]
    H -- 3 --> K[displayTasks\nLeer posición\nmarkCompleted]
    H -- 4 --> L[Mostrar countPending]
    H -- 5 --> M[running = false\n¡Hasta luego!]
    H -- otro --> N[Opción inválida]
    I --> D
    J --> D
    K --> D
    L --> D
    N --> D
    M --> O([Fin])
```

---

## 2. Mostrar tareas — `displayTasks()`

```mermaid
flowchart TD
    A([Inicio]) --> B{tasks vacía?}
    B -- sí --> C[No hay tareas registradas]
    C --> Z([Fin])
    B -- no --> D[Crear AsciiTable\nAgregar encabezado]
    D --> E[i = 0]
    E --> F{i < tasks.size?}
    F -- no --> G[table.render\nImprimir tabla]
    G --> Z
    F -- sí --> H[task = tasks.get i\nstatus = X o vacío]
    H --> I[table.addRow i+1, status, description]
    I --> J[i++]
    J --> F
```

---

## 3. Agregar tarea — `addTask()`

```mermaid
flowchart TD
    A([Inicio\ntasks, description]) --> B[new Task con description y completed=false]
    B --> C[tasks.add nueva tarea]
    C --> D[Imprimir ¡Tarea agregada!]
    D --> E([Retorna tasks modificada])
```

---

## 4. Marcar completada — `markCompleted()`

```mermaid
flowchart TD
    A([Inicio\ntasks, position]) --> B[index = position - 1]
    B --> C{try}
    C --> D[task = tasks.get index]
    D --> E[task.setCompleted true]
    E --> F[Imprimir tarea marcada]
    F --> Z([Fin])
    C -- IndexOutOfBoundsException --> G[Imprimir posición inválida]
    G --> Z
```

---

## 5. Contar pendientes — `countPending()` recursivo

```mermaid
flowchart TD
    A([countPending\ntasks, index]) --> B{index == tasks.size?}
    B -- sí\ncaso base --> C([Retorna 0])
    B -- no --> D{tasks.get index\ncompletada?}
    D -- no está completada --> E[return 1 + countPending tasks, index+1]
    D -- sí está completada --> F[return countPending tasks, index+1]
    E --> A
    F --> A
```

**Traza con lista `[pendiente, completada, pendiente]`:**

```
countPending(tasks, 0)
  → tasks[0] pendiente → 1 + countPending(tasks, 1)
      → tasks[1] completada → countPending(tasks, 2)
          → tasks[2] pendiente → 1 + countPending(tasks, 3)
              → index == size → return 0
          → return 1 + 0 = 1
      → return 1
  → return 1 + 1 = 2
```
