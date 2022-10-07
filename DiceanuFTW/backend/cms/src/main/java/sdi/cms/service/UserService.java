package sdi.cms.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sdi.cms.converter.UserBasicConverter;
import sdi.cms.converter.UserCompleteConverter;
import sdi.cms.dto.UserBasicDto;
import sdi.cms.dto.UserCompleteDto;
import sdi.cms.model.participant.Role;
import sdi.cms.model.participant.User;
import sdi.cms.repository.UserRepository;
import sdi.cms.security.AuthRequest;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserBasicConverter userBasicConverter;

    @Autowired
    private UserCompleteConverter userCompleteConverter;

    public User registerUser(final AuthRequest authRequest) {
        final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        return userRepository.save(
            User
                .builder()
                .email(authRequest.getEmail())
                .password(passwordEncoder.encode(authRequest.getPassword()))
                .role(Role.BASIC)
                .build()
        );
    }

    public Optional<User> findByEmail(String email) {
        return userRepository.findByEmail(email);
    }


//
//    @Transactional
//    public Optional<User> updateUserById(UserCompleteDto userDto) {
//        var user = userCompleteConverter.convertDtoToModel(userDto);
//
//        Optional<User> managedUserOptional = userRepository.findById(user.getId());
//        managedUserOptional.ifPresent(managedUser -> {
//            managedUser.setAffiliation(user.getAffiliation() != null ? user.getAffiliation() : managedUser.getAffiliation());
//            managedUser.setName(user.getName() != null ? user.getName() : managedUser.getName());
//            managedUser.setRole(user.getRole() != null ? user.getRole() : managedUser.getRole());
//            managedUser.setWebPage(user.getWebPage() != null ? user.getWebPage() : managedUser.getWebPage());
//        });
//
//        return managedUserOptional;
//    }

    //    Unit of Work
    @Transactional
    public Optional<User> updateUserByEmail(UserCompleteDto userDto) {
        var user = userCompleteConverter.convertDtoToModel(userDto);

        Optional<User> managedUserOptional = userRepository.findByEmail(user.getEmail());
        managedUserOptional.ifPresent(managedUser -> {
            managedUser.setAffiliation(user.getAffiliation() != null ? user.getAffiliation() : managedUser.getAffiliation());
            managedUser.setName(user.getName() != null ? user.getName() : managedUser.getName());
            managedUser.setRole(user.getRole() != null ? user.getRole() : managedUser.getRole());
            managedUser.setWebPage(user.getWebPage() != null ? user.getWebPage() : managedUser.getWebPage());
        });

        return managedUserOptional;
    }


    public List<User> getAuthors() {
        return userRepository
            .findAll()
            .stream()
            .filter(user -> user.getRole().equals(Role.AUTHOR))
            .collect(Collectors.toList());
    }

    public List<User> getReviewers() {
        return userRepository
            .findAll()
            .stream()
            .filter(user -> user.getRole().equals(Role.REVIEWER))
            .collect(Collectors.toList());
    }

    public List<User> getListeners() {
        return userRepository
            .findAll()
            .stream()
            .filter(user -> user.getRole().equals(Role.LISTENER))
            .collect(Collectors.toList());
    }

    public List<User> getChairs() {
        return userRepository
            .findAll()
            .stream()
            .filter(user -> user.getRole().equals(Role.CHAIR))
            .collect(Collectors.toList());
    }

    public List<User> getProgramCommitteeMembers() {
        return userRepository
            .findAll()
            .stream()
            .filter(user -> user.getRole().equals(Role.PROGRAM_COMMITTEE_MEMBER))
            .collect(Collectors.toList());
    }

    public List<User> getSteeringCommitteeMembers() {
        return userRepository
            .findAll()
            .stream()
            .filter(user -> user.getRole().equals(Role.STEERING_COMMITTEE_MEMBER))
            .collect(Collectors.toList());
    }

    public List<User> getAdministrators() {
        return userRepository
            .findAll()
            .stream()
            .filter(user -> user.getRole().equals(Role.ADMINISTRATOR))
            .collect(Collectors.toList());
    }

    public List<UserBasicDto> getAllUsersUserBasicDto() {
        return userBasicConverter.convertModelsToDtos(userRepository.findAll());
    }

    public List<UserCompleteDto> getAllUsersUserCompleteDto() {
        return userCompleteConverter.convertModelsToDtos(userRepository.findAll());
    }


    public List<UserBasicDto> getAuthorsUserBasicDto() {
        return userBasicConverter.convertModelsToDtos(getAuthors());
    }

    public List<UserCompleteDto> getAuthorsUserCompleteDto() {
        return userCompleteConverter.convertModelsToDtos(getAuthors());
    }

    public List<UserBasicDto> getReviewersUserBasicDto() {
        return userBasicConverter.convertModelsToDtos(getReviewers());
    }

    public List<UserCompleteDto> getReviewersUserCompleteDto() {
        return userCompleteConverter.convertModelsToDtos(getReviewers());
    }

    public List<UserBasicDto> getAdministratorsUserBasicDto() {
        return userBasicConverter.convertModelsToDtos(getAdministrators());
    }

    public List<UserCompleteDto> getAdministratorsUserCompleteDto() {
        return userCompleteConverter.convertModelsToDtos(getAdministrators());
    }

    public List<UserBasicDto> getListenersUserBasicDto() {
        return userBasicConverter.convertModelsToDtos(getListeners());
    }

    public List<UserCompleteDto> getListenersUserCompleteDto() {
        return userCompleteConverter.convertModelsToDtos(getListeners());
    }

    public List<UserBasicDto> getChairsUserBasicDto() {
        return userBasicConverter.convertModelsToDtos(getChairs());
    }

    public List<UserCompleteDto> getChairsUserCompleteDto() {
        return userCompleteConverter.convertModelsToDtos(getChairs());
    }

    public List<UserBasicDto> getProgramCommitteeMembersUserBasicDto() {
        return userBasicConverter.convertModelsToDtos(getProgramCommitteeMembers());
    }

    public List<UserCompleteDto> getProgramCommitteeMembersUserCompleteDto() {
        return userCompleteConverter.convertModelsToDtos(getProgramCommitteeMembers());
    }

    public List<UserBasicDto> getSteeringCommitteeMembersUserBasicDto() {
        return userBasicConverter.convertModelsToDtos(getSteeringCommitteeMembers());
    }

    public List<UserCompleteDto> getSteeringCommitteeMembersUserCompleteDto() {
        return userCompleteConverter.convertModelsToDtos(getSteeringCommitteeMembers());
    }
}
