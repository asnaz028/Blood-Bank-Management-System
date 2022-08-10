package com.example.bloodbank;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface add_donor_repo extends JpaRepository<blood_donor,Integer> {

}
