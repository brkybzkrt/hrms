package project.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import project.hrms.entities.concretes.ProgrammingLanguage;

public interface ProgrammingLanguageDao extends JpaRepository<ProgrammingLanguage, Integer>{

}
