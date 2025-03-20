import java.io.*;
import java.util.*;

// Clase principal que representa una tarea
class Task {
    private String title;
    private String description;
    private boolean isCompleted;

    public Task(String title, String description) {
        this.title = title;
        this.description = description;
        this.isCompleted = false;
    }

    public void completeTask() {
        this.isCompleted = true;
    }

    @Override
    public String toString() {
        return "Tarea: " + title + " - " + (isCompleted ? "Completada" : "Pendiente");
    }

    // Getters y Setters
    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }
}

// Clase para gestionar tareas
class TaskManager {
    private List<Task> tasks;

    public TaskManager() {
        tasks = new ArrayList<>();
    }

    public void addTask(Task task) {
        tasks.add(task);
    }

    public void listTasks() {
        if (tasks.isEmpty()) {
            System.out.println("No hay tareas disponibles.");
        } else {
            tasks.forEach(System.out::println);
        }
    }

    public void completeTask(String title) throws Exception {
        boolean found = false;
        for (Task task : tasks) {
            if (task.getTitle().equalsIgnoreCase(title)) {
                task.completeTask();
                found = true;
                break;
            }
        }
        if (!found) {
            throw new Exception("Tarea no encontrada: " + title);
        }
    }

    public void removeTask(String title) throws Exception {
        boolean removed = tasks.removeIf(task -> task.getTitle().equalsIgnoreCase(title));
        if (!removed) {
            throw new Exception("Tarea no encontrada: " + title);
        }
    }

    public void exportTasks(String filename) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            for (Task task : tasks) {
                writer.write(task.toString());
                writer.newLine();
            }
        }
        System.out.println("Tareas exportadas a " + filename);
    }
}

// Clase principal para ejecutar el programa
public class TaskApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TaskManager manager = new TaskManager();
        boolean running = true;

        while (running) {
            System.out.println("\n--- Administrador de Tareas ---");
            System.out.println("1. Agregar tarea");
            System.out.println("2. Lista de tareas");
            System.out.println("3. Completar tarea");
            System.out.println("4. Eliminar tarea");
            System.out.println("5. Exportar tareas");
            System.out.println("6. Salir");
            System.out.print("Elige una opción: ");

            int option = scanner.nextInt();
            scanner.nextLine(); 

            try {
                switch (option) {
                    case 1:
                        System.out.print("Título de la tarea: ");
                        String title = scanner.nextLine();
                        System.out.print("Descripción de la tarea: ");
                        String description = scanner.nextLine();
                        manager.addTask(new Task(title, description));
                        System.out.println("¡Tarea agregada!");
                        break;
                    case 2:
                        manager.listTasks();
                        break;
                    case 3:
                        System.out.print("Título de la tarea a completar: ");
                        String completeTitle = scanner.nextLine();
                        manager.completeTask(completeTitle);
                        System.out.println("¡Tarea marcada como completada!");
                        break;
                    case 4:
                        System.out.print("Título de la tarea a eliminar: ");
                        String removeTitle = scanner.nextLine();
                        manager.removeTask(removeTitle);
                        System.out.println("¡Tarea eliminada!");
                        break;
                    case 5:
                        System.out.print("Nombre del archivo para exportar las tareas: ");
                        String filename = scanner.nextLine();
                        manager.exportTasks(filename);
                        break;
                    case 6:
                        running = false;
                        System.out.println("¡Adiós!");
                        break;
                    default:
                        System.out.println("Opción inválida.");
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }

        scanner.close();
    }
}