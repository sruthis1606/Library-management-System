package com.example.first.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.first.model.Member;
import com.example.first.repository.MemberRepository;

@Service
public class MemberService {

    private final MemberRepository repository;

    public MemberService(MemberRepository repository) {
        this.repository = repository;
    }

    public List<Member> getAllMembers() {
        return repository.findAll();
    }

    public Member addMember(Member member) {
        return repository.save(member);
    }

    public Member getMemberById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public Member updateMember(Long id, Member newMember) {
        Member member = repository.findById(id).orElse(null);

        if (member != null) {
            member.setName(newMember.getName());
            member.setEmail(newMember.getEmail());
            member.setPhone(newMember.getPhone());

            return repository.save(member);
        }

        return null;
    }

    public void deleteMember(Long id) {
        repository.deleteById(id);
    }
}