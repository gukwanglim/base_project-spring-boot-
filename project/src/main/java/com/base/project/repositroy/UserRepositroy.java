package com.base.project.repositroy;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.base.project.model.User;

public interface UserRepositroy extends JpaRepository<User, Integer> {
    
    // QueryDSL 사용해보기(현재 사용하는 건 QueryDSL 아님)
    @Query(value="INSERT INTO user(userNm, userId, userPw) VALUES(?1, ?2, ?3);", nativeQuery = true)
	void mSave(String userNm, String userId, String userPw);


    // 이 부분이 QueryDSL? 그냥 값을 불러올 수 있게 만드는 방법?
    Optional<User> findByUserNo(int userNo);

    Optional<User> findByUserNm(String userNm);

    Optional<User> findByUserId(String userId);

    Optional<User> findByUserPw(String userPw);
    
}
