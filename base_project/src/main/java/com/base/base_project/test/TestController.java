package com.base.base_project.test;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class TestController {

    @GetMapping("/test")
    public String getMessage(Model model) {
        model.addAttribute("testSTR", "타임리프 사용");

        return "testView";
    }

    @RequestMapping("/member")
    public String getMember(Model model) {
        Member member = new Member(1, "홍길동", "010-0000-0000");
        model.addAttribute("member", member);

        return "member";
    }

    @RequestMapping("/list")
    public String getList(Model model) {
        Member member1 = new Member(1, "홍길동", "010-0000-0000");
        Member member2 = new Member(2, "홍길서", "010-1111-1111");
        Member member3 = new Member(3, "홍길남", "010-2222-2222");

       List<Member> members = new ArrayList<>();

       members.add(member1);
       members.add(member2);
       members.add(member3);

       model.addAttribute("memberList", members);

        return "listMember";
    }
    
}
