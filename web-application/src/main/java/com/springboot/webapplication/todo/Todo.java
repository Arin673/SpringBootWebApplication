package com.springboot.webapplication.todo;

import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

public class Todo {
    private int id;
    private String userName;
    @Size(min=10, message="Enter minimum 10 characters")
    private String description;
    @FutureOrPresent
    private LocalDate targetDate;
    private String status;

    public Todo(int id, String userName, String description, LocalDate targetDate, String status) {
        super();
        this.id = id;
        this.userName = userName;
        this.description = description;
        this.targetDate = targetDate;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getTargetDate() {
        return targetDate;
    }

    public void setTargetDate(LocalDate targetDate) {
        this.targetDate = targetDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Todo{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", description='" + description + '\'' +
                ", targetDate=" + targetDate +
                ", status='" + status + '\'' +
                '}';
    }
}
