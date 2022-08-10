package com.example.bloodbank;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface blood_stock_repo extends JpaRepository<blood_stock,String> {

	@Modifying(clearAutomatically=true)
	@Query(value="update blood_stock p set p.units = :units  where bloodgrp= :bloodgrp",nativeQuery=true)
	void setUpdateStock(@Param("units") String units,@Param("bloodgrp") String bloodgrp);	
}
