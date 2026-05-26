# todo-cli

Gestor de tareas de consola en Java. Actividad 6 — Algoritmos y Programación, Universidad Compensar 2026-1.

## Requisitos

- JDK 21 LTS
- Maven 3.9+

> Con SDKMAN: `sdk env` instala las versiones exactas desde `.sdkmanrc`.

## Librerías externas

| Librería | Versión | Uso |
|---|---|---|
| Lombok | 1.18.34 | Genera getters, setters y constructor en `Task` |
| AsciiTable | 0.3.2 | Renderiza la lista de tareas como tabla con bordes |

## Compilar

```bash
mvn clean package
```

## Ejecutar

```bash
mvn exec:java
```

O directamente con el jar:

```bash
java -jar target/todo-cli-1.0.0.jar
```
