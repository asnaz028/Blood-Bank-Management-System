package com.example.bloodbank;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface bloodRequest_repo  extends JpaRepository<blood_request,Integer>{

	@Modifying(clearAutomatically=true)
	@Query(value="update blood_request p set p.status = :status  where p.id= :id",nativeQuery=true)
	void setUpdateStatus(@Param("status") String status,@Param("id") int id);	
	
	@Query(value="select * from blood_request p where p.status=:n",nativeQuery=true)
	public List<blood_request> getCompletedRequest(@Param("n") String status);
	
	
}
