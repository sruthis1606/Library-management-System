package com.example.first.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.first.model.Member;
import com.example.first.services.MemberService;

@RestController
@RequestMapping("/members")
public class MemberController {

    private final MemberService service;

    public MemberController(MemberService service) {
        this.service = service;
    }

    @GetMapping
    public List<Member> getMembers() {
        return service.getAllMembers();
    }

    @PostMapping
    public Member addMember(@RequestBody Member member) {
        return service.addMember(member);
    }

    @GetMapping("/{id}")
    public Member getMemberById(@PathVariable Long id) {
        return service.getMemberById(id);
    }

    @PutMapping("/{id}")
    public Member updateMember(
            @PathVariable Long id,
            @RequestBody Member member) {
        return service.updateMember(id, member);
    }

    @DeleteMapping("/{id}")
    public String deleteMember(@PathVariable Long id) {
        service.deleteMember(id);
        return "Member deleted successfully!";
    }
}