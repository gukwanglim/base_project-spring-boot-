package com.base.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.base.project.dto.ResponseDto;
import com.base.project.dto.UserDto;
import com.base.project.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping({"/test"})
    public String index(Model model) {
        model.addAttribute("user", userService.find());

        return "testView";
    }

    @GetMapping({"/list"})
    public String list(Model model) {
        return "admin/list";
    }

    // @GetMapping
    // @RequestMapping
    // public ResponseEntity<List<ProjectDto>> find(@RequestParam(required = false) String projectId) {
    //     return ResponseEntity.ok(projectService.찾기(projectId));
    // }

    @PostMapping
    @ResponseBody
    public ResponseDto<Integer> save(@RequestBody UserDto userDto) {
        userService.저장(userDto);
        return new ResponseDto<Integer>(HttpStatus.OK.value(), 1);
    }

    // @PostMapping
    // @ResponseBody
    // public ResponseEntity<ProjectDto> save(@RequestBody ProjectDto projectDto) {
    //     return ResponseEntity.ok(projectService.저장(projectDto));
    // }

    @PutMapping
    @ResponseBody
    public ResponseEntity<UserDto> update(@RequestBody UserDto userDto) {
        return ResponseEntity.ok(userService.저장(userDto));
    }

    @DeleteMapping
    @ResponseBody
    public ResponseEntity<UserDto> delete(@RequestBody UserDto userDto) {
        return ResponseEntity.ok(userService.삭제(userDto));
    }
    
}
