package com.assign2.assignment2.models;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student,Integer> {
    List<Student> findByWeight(int weight);
    List<Student> findByHeight(int height);
    List<Student> findByName(String name);
    List<Student> findByGpa(double gpa);
    List<Student> findByHaircolour(String haircolour);
    List<Student> findByFavcolour(String favcolour);
}