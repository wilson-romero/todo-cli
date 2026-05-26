# todo-cli

> **Actividad 6 · Algoritmos y Programación · UCompensar 2026-1**  
> Autor: Wilson Romero Carrasco — Ciencia de Datos

Aplicación de consola en Java que permite gestionar una lista de tareas pendientes. Demuestra el uso de funciones, procedimientos, recursión y librerías externas como criterios de la rúbrica de evaluación.

---

## Funcionalidades

| # | Opción en el menú | Qué demuestra |
|---|---|---|
| 1 | Ver todas las tareas | Procedimiento con parámetros, iteración con AsciiTable |
| 2 | Agregar nueva tarea | Función con parámetros y retorno, Lombok |
| 3 | Marcar tarea como completada | Procedimiento con parámetros, manejo de errores |
| 4 | Mostrar total de tareas pendientes | Función recursiva |
| 5 | Salir | Variable bandera `running` |

---

## Mapa rúbrica → código

| Criterio | Estructura | Dónde aparece |
|---|---|---|
| Función sin parámetros con retorno | `getTasks()` — retorna `List<Task>` | `TaskManager.java` |
| Procedimiento con parámetros sin retorno | `displayTasks(tasks)` — imprime tabla, no retorna | `TaskManager.java` |
| Función con parámetros y retorno | `addTask(tasks, description)` — retorna lista modificada | `TaskManager.java` |
| Procedimiento con parámetros sin retorno | `markCompleted(tasks, position)` — modifica lista, no retorna | `TaskManager.java` |
| Función recursiva con parámetros y retorno | `countPending(tasks, index)` — cuenta pendientes recursivamente | `TaskManager.java` |
| Sobrecarga de función | `countPending(tasks)` — conveniencia, arranca en índice 0 | `TaskManager.java` |
| Bucle cond. al comienzo (`while`) | `while (running)` — repite el menú hasta que el usuario sale | `main()` |
| Decisión múltiple (`switch`) | `switch (option)` — enruta las 5 opciones del menú | `main()` |
| Variable bandera | `boolean running` — controla el ciclo principal | `main()` |
| Manejo de errores | `try-catch IndexOutOfBoundsException` — posición inválida | `markCompleted()` |
| Manejo de errores | `try-catch NumberFormatException` — entrada no numérica | `readInt()` |
| Método reutilizable | `readInt(scanner)` — lectura segura de enteros con eco para evidencia | `TaskManager.java` |
| Librería externa 1 (Lombok) | `@Getter @Setter @AllArgsConstructor` — elimina boilerplate | `Task.java` |
| Librería externa 2 (AsciiTable) | Tabla con bordes + `CWC_LongestLine` para ancho automático | `displayTasks()` |
| Documentación | Javadoc (`@param`, `@return`) en todos los métodos públicos | `Task.java`, `TaskManager.java` |

---

## Tecnologías

- **Java 21 LTS**
- **Maven 3.9+** — gestión de dependencias y ejecución
- **Lombok 1.18.34** — genera getters, setters y constructor de `Task` sin boilerplate
- **AsciiTable 0.3.2** — renderiza la lista de tareas como tabla con bordes en consola

> Lombok se declara con `scope: provided`: actúa solo en tiempo de compilación y **no** queda en el `.jar` final.

---

## Diagramas de flujo

Los diagramas están en [`docs/DIAGRAMAS.md`](docs/DIAGRAMAS.md) escritos en Mermaid (GitHub los renderiza automáticamente):

| Diagrama | Qué muestra |
|---|---|
| 1. Menú principal | Bucle `while` + switch + bandera `running` |
| 2. `displayTasks` | Iteración `for` + construcción de tabla AsciiTable |
| 3. `addTask` | Creación de objeto + retorno de lista modificada |
| 4. `markCompleted` | Conversión 1-based + `try-catch` |
| 5. `countPending` | Árbol de llamadas recursivas (caso base y recursivo) |

---

## Requisitos previos

- JDK 21 o superior
- Maven 3.9+

> Si usas **SDKMAN**, el archivo `.sdkmanrc` en la raíz selecciona automáticamente
> Java 21 y Maven 3.9. Actívalo con `sdk env` antes de compilar.

---

## Compilar y ejecutar

```bash
# Activar las versiones correctas (requiere SDKMAN)
sdk env

# Compilar
mvn clean package

# Ejecutar interactivo
mvn exec:java
```

### Reproducir los escenarios de evidencia

```bash
# Escenario A: flujo completo (5 tareas, marcar 2, contar pendientes)
mvn -q exec:java < demo_input.txt > evidence/01_full_flow.txt

# Escenario B: validaciones de entrada (opciones inválidas, posiciones fuera de rango)
mvn -q exec:java < validation_input.txt > evidence/02_validations.txt
```

Las salidas quedan en `evidence/` para adjuntar como evidencia en el informe.

---

## Estructura del proyecto

```
todo-cli/
├── .sdkmanrc                    # Versión de Java y Maven (SDKMAN)
├── .gitignore
├── pom.xml
├── README.md
├── demo_input.txt               # stdin escenario A — flujo completo
├── validation_input.txt         # stdin escenario B — validaciones
├── evidence/
│   ├── 01_full_flow.txt         # Salida escenario A
│   └── 02_validations.txt       # Salida escenario B
├── docs/
│   └── DIAGRAMAS.md             # Diagramas de flujo (Mermaid)
└── src/main/java/com/ucompensar/todo/
    ├── Task.java                # Modelo de datos (Lombok)
    └── TaskManager.java         # Lógica + menú + main
```
