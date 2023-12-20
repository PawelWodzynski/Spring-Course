package com.OneToOne;

import com.OneToOne.dao.AppDAO;
import com.OneToOne.entity.Instructor;
import com.OneToOne.entity.InstructorDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class OneToOneApplication {

	public static void main(String[] args) {
		SpringApplication.run(OneToOneApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(AppDAO appDAO){
		return runner ->{
			//createInstructor(appDAO);

			//findInstructor(appDAO);

			deleteInstructor(appDAO);
		};
	}

	private void deleteInstructor(AppDAO appDAO) {
		int theId = 1;
		System.out.println("Deleting instructor id: " + theId);

		appDAO.deleteInstructorById(theId);

		System.out.println("done");
	}

	private void findInstructor(AppDAO appDAO) {
		int theId = 1;
		System.out.println("Finding instructor id: " + theId);

		Instructor tempInstructor = appDAO.findInstructorById(theId);

		System.out.println("tempInstructor: " + tempInstructor);
		System.out.println("the associated instructorDetail only: " + tempInstructor.getInstructorDetail());
	}

	private void createInstructor(AppDAO appDAO) {

		// create the instructor
		Instructor tempInstructor = new Instructor("pahmet","wodzabala","oilrafinery@turban.com");

		// create the Instructor Detail
		InstructorDetail tempInstructorDetail= new InstructorDetail("youtube.com/pandaisblackitiswhiteanditisasian","zoo");

		// associate the objects
		tempInstructor.setInstructorDetail(tempInstructorDetail);
		//
		// save the instructor
		//
		// NOTE: this will ALSO save details object because of CascadeType.ALL
		//
		System.out.println("Saving Instructor " + tempInstructor);
		appDAO.save(tempInstructor);

		System.out.println("Done");

	}

}
