package com.trustflair.demo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestionScoutsRepository extends JpaRepository<QuestionScoutsEntity, String>{

}
