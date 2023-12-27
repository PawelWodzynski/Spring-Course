package com.OneToOne.dao;

import com.OneToOne.entity.Instructor;
import com.OneToOne.entity.InstructorDetail;

public interface AppDAO {

    void save(Instructor theInstructor);


    Instructor findInstructorById(int theId);


    void deleteInstructorById(int theId);

    InstructorDetail findInstructorDetailById(int theId);

    void deleteInstructorDetailById(int theId);
}
