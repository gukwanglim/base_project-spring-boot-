package com.base.project.dto;

import com.base.project.model.User;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
    private int userNo;
    private String userNm;
    private String userId;
    private String userPw;
    private String encPassword;

    public UserDto(User entity) {
        this.userNo = entity.getUserNo();
        this.userNm = entity.getUserNm();
        this.userId = entity.getUserId();
        this.userPw = entity.getUserPw();
        // this.encPassword = entity.setUserPw();
    }

    public User toEntity() {
        return User.builder()
                            .userNo(userNo)
                            .userNm(userNm)
                            .userId(userId)
                            .userPw(userPw)
                            .build();
    }
}
