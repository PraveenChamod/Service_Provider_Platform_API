package com.ServiceProviderPlatform.Service_Provider_Platform_API.service;

import com.ServiceProviderPlatform.Service_Provider_Platform_API.dto.MemberDTO;
import com.ServiceProviderPlatform.Service_Provider_Platform_API.exception.CustomException;
import com.ServiceProviderPlatform.Service_Provider_Platform_API.model.Member;
import com.ServiceProviderPlatform.Service_Provider_Platform_API.repository.MemberRepository;
import com.ServiceProviderPlatform.Service_Provider_Platform_API.service.Mapper.MemberDTOMapper;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;
    private final MemberDTOMapper memberDTOMapper;

    @Transactional
    public MemberDTO saveMember(Member member) {
        try{
            Member savedMember = memberRepository.save(member);
            return memberDTOMapper.apply(savedMember);
        } catch (Exception e) {
            throw new CustomException("An error occurred while saving member.", e);
        }
    }
}
