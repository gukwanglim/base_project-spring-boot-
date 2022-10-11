package com.base.base_project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.base.base_project.dto.ProjectDto;
import com.base.base_project.dto.ResponseDto;
import com.base.base_project.model.Project;
import com.base.base_project.service.ProjectService;

@Controller
@RequestMapping("/user")
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    @GetMapping({"/test"})
    public String index(Model model) {
        model.addAttribute("project", projectService.find());

        return "testView";
    }

    @GetMapping({"/list"})
    public String list(Model model) {
        return "list";
    }

    @PostMapping
    @RequestMapping
    public ResponseDto<Integer> save(@RequestBody ProjectDto projectDto) {
        projectService.저장(projectDto);
        return new ResponseDto<Integer>(HttpStatus.OK.value(), 1);
    }

    // @GetMapping
    // @RequestMapping
    // public ResponseDto<Integer> save(@RequestBody ProjectDto projectDto) {
    //     projectService.저장(projectDto);
    //     return new ResponseDto<Integer>(HttpStatus.OK.value(), 1);
    // }
}
