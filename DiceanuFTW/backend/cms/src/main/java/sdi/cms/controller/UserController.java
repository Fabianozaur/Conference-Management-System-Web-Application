package sdi.cms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import sdi.cms.dto.UserCompleteDto;
import sdi.cms.service.UserService;


@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/users/findByEmail", method = RequestMethod.GET)
    public ResponseEntity<?> getUserByEmail(@RequestParam String email) {
        var response = userService
            .findByEmail(email)
            .map(user -> new ResponseEntity<>(user, HttpStatus.OK))
            .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));

        System.out.println("/users/findByEmail:GET Request response: " + response);

        return response;
    }

    @RequestMapping(value = "/users/update", method = RequestMethod.PUT)
    public ResponseEntity<?> updateUser(@RequestBody UserCompleteDto userDto) {
        var response = userService
            .updateUserByEmail(userDto)
            .map(user -> new ResponseEntity<>(user, HttpStatus.OK))
            .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));

        System.out.println("/users/update:PUT Request response: " + response);

        return response;
    }

    @RequestMapping(value = "/usersComplete", method = RequestMethod.GET)
    public ResponseEntity<?> getAllUsersComplete() {
        var response = new ResponseEntity<>(
            userService.getAllUsersUserCompleteDto(),
            HttpStatus.OK
        );

        System.out.println("/usersComplete:GET Request response: " + response);

        return response;
    }

    @RequestMapping(value = "/usersBasic", method = RequestMethod.GET)
    public ResponseEntity<?> getAllUsersBasic() {
        var response = new ResponseEntity<>(
            userService.getAllUsersUserBasicDto(),
            HttpStatus.OK
        );

        System.out.println("/usersBasic:GET Request response: " + response);

        return response;
    }

    @RequestMapping(value = "/users/AuthorsBasic", method = RequestMethod.GET)
    public ResponseEntity<?> getAuthorsBasic() {
        var response = new ResponseEntity<>(
            userService.getAuthorsUserBasicDto(),
            HttpStatus.OK
        );

        System.out.println("/users/AuthorsBasic:GET Request response: " + response);

        return response;
    }

    @RequestMapping(value = "/users/AuthorsComplete", method = RequestMethod.GET)
    public ResponseEntity<?> getAuthorsComplete() {
        var response = new ResponseEntity<>(
            userService.getAuthorsUserCompleteDto(),
            HttpStatus.OK
        );

        System.out.println("/users/AuthorsComplete:GET Request response: " + response);

        return response;
    }


    @RequestMapping(value = "/users/ReviewersBasic", method = RequestMethod.GET)
    public ResponseEntity<?> getReviewersBasic() {
        var response = new ResponseEntity<>(
            userService.getReviewersUserBasicDto(),
            HttpStatus.OK
        );

        System.out.println("/users/ReviewersBasic:GET Request response: " + response);

        return response;
    }

    @RequestMapping(value = "/users/ReviewersComplete", method = RequestMethod.GET)
    public ResponseEntity<?> getReviewersComplete() {
        var response = new ResponseEntity<>(
            userService.getReviewersUserCompleteDto(),
            HttpStatus.OK
        );

        System.out.println("/users/ReviewersComplete:GET Request response: " + response);

        return response;
    }

    @RequestMapping(value = "/users/ListenersBasic", method = RequestMethod.GET)
    public ResponseEntity<?> getListenersBasic() {
        var response = new ResponseEntity<>(
            userService.getListenersUserBasicDto(),
            HttpStatus.OK
        );

        System.out.println("/users/ListenersBasic:GET Request response: " + response);

        return response;
    }

    @RequestMapping(value = "/users/ListenersComplete", method = RequestMethod.GET)
    public ResponseEntity<?> getListenersComplete() {
        var response = new ResponseEntity<>(
            userService.getListenersUserCompleteDto(),
            HttpStatus.OK
        );

        System.out.println("/users/ListenersComplete:GET Request response: " + response);

        return response;
    }

    @RequestMapping(value = "/users/ChairsBasic", method = RequestMethod.GET)
    public ResponseEntity<?> getChairsBasic() {
        var response = new ResponseEntity<>(
            userService.getChairsUserBasicDto(),
            HttpStatus.OK
        );

        System.out.println("/users/ChairsBasic:GET Request response: " + response);

        return response;
    }

    @RequestMapping(value = "/users/ChairsComplete", method = RequestMethod.GET)
    public ResponseEntity<?> getChairsComplete() {
        var response = new ResponseEntity<>(
            userService.getListenersUserCompleteDto(),
            HttpStatus.OK
        );

        System.out.println("/users/ChairsComplete:GET Request response: " + response);

        return response;
    }

    @RequestMapping(value = "/users/ProgramCommitteeMembersBasic", method = RequestMethod.GET)
    public ResponseEntity<?> getProgramCommitteeMembersBasic() {
        var response = new ResponseEntity<>(
            userService.getProgramCommitteeMembersUserBasicDto(),
            HttpStatus.OK
        );

        System.out.println("/users/ProgramCommitteeMembersBasic:GET Request response: " + response);

        return response;
    }

    @RequestMapping(value = "/users/ProgramCommitteeMembersComplete", method = RequestMethod.GET)
    public ResponseEntity<?> getProgramCommitteeMembersComplete() {
        var response = new ResponseEntity<>(
            userService.getProgramCommitteeMembersUserCompleteDto(),
            HttpStatus.OK
        );

        System.out.println("/users/ProgramCommitteeMembersComplete:GET Request response: " + response);

        return response;
    }

    @RequestMapping(value = "/users/SteeringCommitteeMembersBasic", method = RequestMethod.GET)
    public ResponseEntity<?> getSteeringCommitteeMembersBasic() {
        var response = new ResponseEntity<>(
            userService.getSteeringCommitteeMembersUserBasicDto(),
            HttpStatus.OK
        );

        System.out.println("/users/SteeringCommitteeMembersBasic:GET Request response: " + response);

        return response;
    }

    @RequestMapping(value = "/users/SteeringCommitteeMembersComplete", method = RequestMethod.GET)
    public ResponseEntity<?> getSteeringCommitteeMembersComplete() {
        var response = new ResponseEntity<>(
            userService.getSteeringCommitteeMembersUserCompleteDto(),
            HttpStatus.OK
        );

        System.out.println("/users/SteeringCommitteeMembersComplete:GET Request response: " + response);

        return response;
    }

    @RequestMapping(value = "/users/AdministratorsBasic", method = RequestMethod.GET)
    public ResponseEntity<?> getAdministratorsBasic() {
        var response = new ResponseEntity<>(
            userService.getAdministratorsUserBasicDto(),
            HttpStatus.OK
        );

        System.out.println("/users/AdministratorsBasic:GET Request response: " + response);

        return response;
    }

    @RequestMapping(value = "/users/AdministratorsComplete", method = RequestMethod.GET)
    public ResponseEntity<?> getAdministratorsComplete() {
        var response = new ResponseEntity<>(
            userService.getAdministratorsUserCompleteDto(),
            HttpStatus.OK
        );

        System.out.println("/users/AdministratorsComplete:GET Request response: " + response);

        return response;
    }

}
