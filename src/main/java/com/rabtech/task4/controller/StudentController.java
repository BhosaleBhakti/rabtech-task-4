package com.rabtech.task4.controller;

import com.rabtech.task4.entity.Student;
import com.rabtech.task4.service.StudentService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    private final StudentService service;

    public StudentController(StudentService service) {
        this.service = service;
    }

    @GetMapping
    public List<Student> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Student getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @GetMapping("/search")
    public List<Student> search(@RequestParam String name) {
        return service.search(name);
    }

    @PostMapping
    public Student create(@Valid @RequestBody Student student) {
        return service.create(student);
    }

    @PutMapping("/{id}")
    public Student update(
            @PathVariable Long id,
            @Valid @RequestBody Student student) {
        return service.update(id, student);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) {
        service.delete(id);
        return "Student deleted successfully";
    }
}