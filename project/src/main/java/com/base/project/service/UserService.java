package com.base.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.base.project.dto.UserDto;
import com.base.project.model.User;
import com.base.project.repositroy.UserRepositroy;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {
    
    // @RequiredArgsConstructor와 final을 사용하여 @Autowired를 대체
    // private final ProjectRepositroy projectRepositroy;

    @Autowired
    private UserRepositroy userRepositroy;

    @Autowired
    private BCryptPasswordEncoder encoder;

    public List<User> find() {    // Project 테이블에 들어있는 모든 내용을 findAll()을 사용하여 가져오는 것은 list의 형태로 들고 오게 된다.
        return userRepositroy.findAll();
    } 

    // @Transactional
    // public List<ProjectDto> 찾기(String projectId) {
    //     return projectRepositroy.findByUserId("%" + projectId + "%").stream().map(project -> new ProjectDto(project)).collect(Collector.toList());
    // }

    // @Transactional
    // public void 저장(ProjectDto projectDto) {
    //     projectRepositroy.save(projectDto.toEntity());
    //     // projectRepositroy.mSave(projectDto.getUserNm(), projectDto.getUserId(), projectDto.getUserPw());
    // }

    @Transactional
    public UserDto 저장(UserDto userDto) {

        // String rawPassword = userDto.getUserPw();
        // String encPassword = encoder.encode(rawPassword);
        // userDto.set(encPassword);

        return new UserDto(userRepositroy.save(userDto.toEntity()));
    }

    @Transactional
    public UserDto 삭제(UserDto userDto) {
        userRepositroy.deleteById(userDto.getUserNo());
        return userDto;
    }

}
