package com.example.first.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.first.model.Member;

public interface MemberRepository extends JpaRepository<Member, Long> {
}