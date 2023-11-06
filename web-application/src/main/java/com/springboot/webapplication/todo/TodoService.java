package com.springboot.webapplication.todo;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

@Service
public class TodoService {
    private static List<Todo> todos = new ArrayList<>();
    private static int todosCount = 0;
    static {
        todos.add(new Todo(++todosCount, "TaskTrek", "Get AWS Certified",
                LocalDate.now().plusYears(1), "In-Progress"));
        todos.add(new Todo(++todosCount, "TaskTrek", "Learn Google Cloud",
                LocalDate.now().plusYears(2), "In-Progress"));
        todos.add(new Todo(++todosCount, "TaskTrek", "Learn AI & ML",
                LocalDate.now().plusYears(3), "Not Started"));
    }
    public List<Todo> findbyUsername(String username){
        Predicate<? super Todo> predicate =
                todo -> todo.getUsername().equalsIgnoreCase(username);
        return todos.stream().filter(predicate).toList();
    }
    public void addTodo(String username, String description, LocalDate targetDate, String status){
        Todo todo = new Todo(++todosCount, username, description, targetDate, status);
        todos.add(todo);
    }
    public void deleteById(int id){
        Predicate<? super Todo> predicate = todo -> todo.getId() == id;
        todos.removeIf(predicate);
    }

    public Todo findById(int id) {
        Predicate<? super Todo> predicate = todo -> todo.getId() == id;
        Todo todo = todos.stream().filter(predicate).findFirst().get();
        return todo;
    }

    public void updateTodo(Todo todo) {
        deleteById(todo.getId());
        todos.add(todo);
    }
}
