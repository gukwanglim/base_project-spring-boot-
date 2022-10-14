package com.base.base_project.repositroy;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.base.base_project.model.Project;

public interface ProjectRepositroy extends JpaRepository<Project, Integer>{
    
    // QueryDSL 사용해보기(현재 사용하는 건 QueryDSL 아님)
    @Query(value="INSERT INTO project(userNm, userId, userPw) VALUES(?1, ?2, ?3);", nativeQuery = true)
	void mSave(String userNm, String userId, String userPw);


    // 이 부분이 QueryDSL? 그냥 값을 불러올 수 있게 만드는 방법?
    Optional<Project> findByUserNo(int userNo);

    Optional<Project> findByUserNm(String userNm);

    Optional<Project> findByUserId(String userId);

    Optional<Project> findByUserPw(String userPw);
}
