package org.gnp.intedoc.repositories;

import org.gnp.intedoc.entities.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.gnp.intedoc.entities.QMember;

public interface MemberRepository extends JpaRepository<Member, Long>, QuerydslPredicateExecutor<Member> {
    Member findByEmail(String email);

    default boolean exists(String email) {

        return exists(QMember.member.email.eq(email));
    }
}