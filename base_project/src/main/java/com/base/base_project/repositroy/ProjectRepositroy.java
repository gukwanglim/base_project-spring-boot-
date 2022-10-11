package com.base.base_project.repositroy;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.base.base_project.model.Project;

public interface ProjectRepositroy extends JpaRepository<Project, Integer>{
    
    @Query(value="INSERT INTO reply(userNo, userNm, userId, userPw) VALUES(?1, ?2, ?3, ?4);", nativeQuery = true)
	void mSave(String userNm, String userId, String userPw);
}
