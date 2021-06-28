package project.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


import project.hrms.entities.concretes.Favorite;

public interface FavoriteDao extends JpaRepository<Favorite, Integer> {

	
	List<Favorite> getByCandidate_Id(int candidateId);
	
	boolean existsByJobAdvertisementId(int id);
	
	
	
}
