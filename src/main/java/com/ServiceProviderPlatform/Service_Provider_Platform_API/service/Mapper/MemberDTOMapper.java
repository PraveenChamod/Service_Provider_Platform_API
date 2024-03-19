package com.ServiceProviderPlatform.Service_Provider_Platform_API.service.Mapper;

import com.ServiceProviderPlatform.Service_Provider_Platform_API.dto.AddressDTO;
import com.ServiceProviderPlatform.Service_Provider_Platform_API.dto.MemberDTO;
import com.ServiceProviderPlatform.Service_Provider_Platform_API.model.Address;
import com.ServiceProviderPlatform.Service_Provider_Platform_API.model.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MemberDTOMapper implements Function<Member, MemberDTO> {
    private final AddressDTOMapper addressDTOMapper;
    private final ClientDTOMapper clientDTOMapper;

    @Override
    public MemberDTO apply(Member member){
        return new MemberDTO(
                member.getId(),
                member.getFirstName(),
                member.getLastName(),
                mapToDTOList(member.getAddresses()),
                member.getBirthday(),
                member.getGender(),
                member.getLanguage(),
                clientDTOMapper.apply(member.getClient())
        );
    }

    public List<AddressDTO> mapToDTOList(List<Address> addressList) {
        return addressList.stream()
                .map(addressDTOMapper)
                .collect(Collectors.toList());
    }
}
