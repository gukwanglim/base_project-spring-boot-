package com.base.base_project.controller;

import java.util.List;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.base.base_project.dto.ProjectDto;
import com.base.base_project.dto.ResponseDto;
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

    @GetMapping
    @RequestMapping
    public ResponseEntity<List<ProjectDto>> find(@RequestParam(required = false) String projectId) {
        return ResponseEntity.ok(projectService.찾기(projectId));
    }

    @PostMapping
    @ResponseBody
    public ResponseDto<Integer> save(@RequestBody ProjectDto projectDto) {
        projectService.저장(projectDto);
        return new ResponseDto<Integer>(HttpStatus.OK.value(), 1);
    }

    // @PostMapping
    // @ResponseBody
    // public ResponseEntity<ProjectDto> save(@RequestBody ProjectDto projectDto) {
    //     return ResponseEntity.ok(projectService.저장(projectDto));
    // }

    @PutMapping
    @ResponseBody
    public ResponseEntity<ProjectDto> update(@RequestBody ProjectDto projectDto) {
        return ResponseEntity.ok(projectService.저장(projectDto));
    }

    @DeleteMapping
    @ResponseBody
    public ResponseEntity<ProjectDto> delete(@RequestBody ProjectDto projectDto) {
        return ResponseEntity.ok(projectService.삭제(projectDto));
    }

}
