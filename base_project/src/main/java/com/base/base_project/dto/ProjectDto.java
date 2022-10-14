package com.base.base_project.dto;

import com.base.base_project.model.Project;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ProjectDto {
    private int userNo;
    private String userNm;
    private String userId;
    private String userPw;

    public ProjectDto(Project entity) {
        this.userNo = entity.getUserNo();
        this.userNm = entity.getUserNm();
        this.userId = entity.getUserId();
        this.userPw = entity.getUserPw();
    }

    public Project toEntity() {
        return Project.builder()
                            .userNo(userNo)
                            .userNm(userNm)
                            .userId(userId)
                            .userPw(userPw)
                            .build();
    }
}
