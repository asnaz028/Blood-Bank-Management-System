package com.example.bloodbank;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface admin_repo extends JpaRepository<admin,Integer> {

	admin	findByusername(String username);
}
