package project.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import project.hrms.entities.concretes.Education;

public interface EducationDao extends JpaRepository<Education, Integer>{

}
