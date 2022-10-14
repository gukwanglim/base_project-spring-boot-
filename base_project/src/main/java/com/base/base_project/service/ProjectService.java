package com.base.base_project.service;

import java.util.List;
import java.util.stream.Collector;

import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.base.base_project.dto.ProjectDto;
import com.base.base_project.model.Project;
import com.base.base_project.repositroy.ProjectRepositroy;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProjectService {

    // @RequiredArgsConstructor와 final을 사용하여 @Autowired를 대체
    // private final ProjectRepositroy projectRepositroy;

    @Autowired
    private ProjectRepositroy projectRepositroy;

    public List<Project> find() {    // Project 테이블에 들어있는 모든 내용을 findAll()을 사용하여 가져오는 것은 list의 형태로 들고 오게 된다.
        return projectRepositroy.findAll();
    } 

    @Transactional
    public List<ProjectDto> 찾기(String projectId) {
        return projectRepositroy.findByUserId("%" + projectId + "%").stream().map(project -> new ProjectDto(project)).collect(Collector.toList());
    }

    // @Transactional
    // public void 저장(ProjectDto projectDto) {
    //     projectRepositroy.save(projectDto.toEntity());
    //     // projectRepositroy.mSave(projectDto.getUserNm(), projectDto.getUserId(), projectDto.getUserPw());
    // }

    @Transactional
    public ProjectDto 저장(ProjectDto projectDto) {
        return new ProjectDto(projectRepositroy.save(projectDto.toEntity()));
    }

    @Transactional
    public ProjectDto 삭제(ProjectDto projectDto) {
        projectRepositroy.deleteById(projectDto.getUserNo());
        return projectDto;
    }
    
}
