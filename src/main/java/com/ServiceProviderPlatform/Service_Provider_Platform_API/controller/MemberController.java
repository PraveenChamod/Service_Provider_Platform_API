package com.ServiceProviderPlatform.Service_Provider_Platform_API.controller;

import com.ServiceProviderPlatform.Service_Provider_Platform_API.dto.MemberDTO;
import com.ServiceProviderPlatform.Service_Provider_Platform_API.dto.TrainerDTO;
import com.ServiceProviderPlatform.Service_Provider_Platform_API.enums.ActiveStatus;
import com.ServiceProviderPlatform.Service_Provider_Platform_API.enums.ApplicationRole;
import com.ServiceProviderPlatform.Service_Provider_Platform_API.model.*;
import com.ServiceProviderPlatform.Service_Provider_Platform_API.service.MemberService;
import com.ServiceProviderPlatform.Service_Provider_Platform_API.service.TrainerService;
import com.ServiceProviderPlatform.Service_Provider_Platform_API.service.UserRoleService;
import com.ServiceProviderPlatform.Service_Provider_Platform_API.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping(path ="/api/v1/member")
public class MemberController {
    private final MemberService memberService;
    private final UserService userService;
    private final UserRoleService userRoleService;
    private final TrainerService trainerService;

    @PostMapping("/create-client-profile/{id}")
    public MemberDTO createClientProfile(@Validated @RequestBody Member member, @PathVariable(name = "id") Long id) {

        Optional<User> existingUserOptional = userService.findUserById(id);
        if (existingUserOptional.isPresent()){
            User existingUser = existingUserOptional.get();

            Member memberIn = Member.builder()
                    .firstName(member.getFirstName())
                    .lastName(member.getLastName())
                    .birthday(member.getBirthday())
                    .gender(member.getGender())
                    .language(member.getLanguage())
                    .build();

            List<Address> addresses = new ArrayList<>();
            if (member.getAddresses() != null) {
                for (Address addressIn : member.getAddresses()) {
                    Address address = Address.builder()
                            .street(addressIn.getStreet())
                            .city(addressIn.getCity())
                            .state(addressIn.getState())
                            .postalCode(addressIn.getPostalCode())
                            .country(addressIn.getCountry())
                            .build();
                    address.setMember(memberIn);
                    addresses.add(address);
                }
            }

            Client clientIn = Client.builder()
                    .experienceLevel(member.getClient().getExperienceLevel())
                    .experienceType(member.getClient().getExperienceType())
                    .trainingGoal(member.getClient().getTrainingGoal())
                    .status(ActiveStatus.ACTIVE)
                    .member(memberIn)
                    .build();

            memberIn.setAddresses(addresses);
            memberIn.setClient(clientIn);
            memberIn.setUser(existingUser);
            return memberService.saveMember(memberIn);
        }
        return null;
    }

    @PostMapping("/create-trainer-profile/{id}")
    public TrainerDTO expandProfileToTrainer(@Validated @RequestBody Trainer trainer, @PathVariable(name = "id") Long id) {

        Optional<User> existingUserOptional = userService.findUserById(id);
        if (existingUserOptional.isPresent()){
            User existingUser = existingUserOptional.get();
            List<UserRole> existingUserRoles = existingUser.getUserRoles();
            Optional<UserRole> optionalTrainerRole = userRoleService.findByName(ApplicationRole.TRAINER);
            if(optionalTrainerRole.isPresent()){
                UserRole trainerRole = optionalTrainerRole.get();
                existingUserRoles.add(trainerRole);
            }
            existingUser.setUserRoles(existingUserRoles);
            userService.updateUser(existingUser);

            Member existingMember = existingUser.getMember();
            Trainer trainerIn = Trainer.builder()
                    .businessLocation(trainer.getBusinessLocation())
                    .telephone(trainer.getTelephone())
                    .brandName(trainer.getBrandName())
                    .status(ActiveStatus.ACTIVE)
                    .member(existingMember)
                    .build();
            return trainerService.saveTrainer(trainerIn);
        }
        return null;
    }
}

