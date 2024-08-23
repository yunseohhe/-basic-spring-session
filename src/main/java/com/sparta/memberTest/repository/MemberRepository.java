package com.sparta.memberTest.repository;


import com.sparta.memberTest.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {
}
