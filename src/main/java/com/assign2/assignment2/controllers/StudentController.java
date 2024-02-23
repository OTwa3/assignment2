package com.assign2.assignment2.controllers;

//import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.assign2.assignment2.models.Student;
import com.assign2.assignment2.models.StudentRepository;

import jakarta.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class StudentController {

    @Autowired
    private StudentRepository studentRepo;

    @GetMapping("/student/view")
    public String getAllStudent(Model model){
        System.out.println("Getting all user");
        // get all student from data base
        List<Student> student = studentRepo.findAll();
        // end of database call
        model.addAttribute("stu", student);
        return "student/showAll";
    }

    @PostMapping("/student/add")
    public String addStudent(@RequestParam Map<String, String> newstudent, HttpServletResponse response){
        System.out.println("ADD student");
        String newName = newstudent.get("name");
        int newWeight = Integer.parseInt(newstudent.get("weight"));
        int newHeight = Integer.parseInt(newstudent.get("height"));
        String newhairColour = newstudent.get("haircolour");
        double newGpa = Double.parseDouble(newstudent.get("gpa"));
        String newFavColour = newstudent.get("favcolour");
        studentRepo.save(new Student(newName, newWeight, newHeight, newhairColour, newGpa, newFavColour));
        response.setStatus(201);
        return "student/addedStudent";
    }

    @PostMapping("/student/edit")
    public String editStudent(@RequestParam("name") String studentName, @RequestParam("weight") int studentWeight, @RequestParam("height") int studentHeight, @RequestParam("haircolour") String studentHairColour, @RequestParam("gpa") double studentGPA, @RequestParam("favcolour") String studentFavColour, HttpServletResponse response){
        System.out.println("EDIT student with name " + studentName);
        List<Student> studentsToUpdate = studentRepo.findByName(studentName);
        Student studentToUpdate = studentsToUpdate.get(0);
        studentToUpdate.setWeight(studentWeight);
        studentToUpdate.setHeight(studentHeight);
        studentToUpdate.setHaircolour(studentHairColour);
        studentToUpdate.setGpa(studentGPA);
        studentToUpdate.setFavcolour(studentFavColour);
        studentRepo.save(studentToUpdate);
        response.setStatus(201);
        return "student/editedStudent";
    }

    @PostMapping("/student/delete")
    public String deleteStudent(@RequestParam("name") String studentName, HttpServletResponse response){
        List<Student> studentToDelete = studentRepo.findByName(studentName);
        System.out.println("DELETE student with name" + studentName);
        studentRepo.deleteAll(studentToDelete);
        response.setStatus(201);
        return "student/deletedStudent";
    }

    @PostMapping("/student/toedit")
    public String findEdit(@RequestParam("name") String studentName, Model model, HttpServletResponse response) {
        System.out.println("Redirecting to edit page with name " + studentName);
        List<Student> studentToEdit = studentRepo.findByName(studentName);
        model.addAttribute("student", studentToEdit.get(0));
        return "student/edit";
    }
    

    public String postMethodName(@RequestBody String entity) {
        
        
        return entity;
    }
    
    
    
}
