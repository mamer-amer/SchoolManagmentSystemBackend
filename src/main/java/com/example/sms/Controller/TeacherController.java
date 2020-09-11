package com.example.sms.Controller;


import com.example.sms.DTO.StudentDTO;
import com.example.sms.DTO.TeacherDTO;
import com.example.sms.MODEL.Student;
import com.example.sms.MODEL.Teacher;
import com.example.sms.REPOSITORY.StudentRepository;
import com.example.sms.REPOSITORY.TeacherRepository;
import com.example.sms.SERVICE.StudentService;
import com.example.sms.SERVICE.TeacherService;
import com.sun.istack.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class TeacherController {

    @Autowired
    TeacherRepository teacherRepository;

    @Autowired
    TeacherService teacherService;

    @PostMapping("/teacher")
    private ResponseEntity<Teacher> save(@RequestBody TeacherDTO teacherDTO){
        return teacherService.saveTeacher(teacherDTO);
    }

    @PutMapping("/teacher/{id}")
    private ResponseEntity<Teacher> update(@NotNull @RequestBody TeacherDTO teacherDTO, @NotNull @PathVariable("id") long id){
        return teacherService.updateTeacher(id,teacherDTO);
    }

    @GetMapping("/teacher/{id}")
    private ResponseEntity<Teacher> getById(@NotNull @PathVariable("id") long id){
        return teacherService.getById(id);
    }
}
