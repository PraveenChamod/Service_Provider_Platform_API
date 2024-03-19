package com.ServiceProviderPlatform.Service_Provider_Platform_API.repository;

import com.ServiceProviderPlatform.Service_Provider_Platform_API.model.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {
}



