package com.OneToOne.dao;

import com.OneToOne.entity.Instructor;

public interface AppDAO {

    void save(Instructor theInstructor);


    Instructor findInstructorById(int theId);


    void deleteInstructorById(int theId);
}
