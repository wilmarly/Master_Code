package com.example.mastercode.controller;

import com.example.mastercode.dto.ProfileDto;
import com.example.mastercode.entities.Profile;
import com.example.mastercode.services.ProfileServicesImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("profile")
public class ProfileController {

    private final ProfileServicesImpl profileServicesImpl;

    public ProfileController(ProfileServicesImpl profileServicesImpl) {
        this.profileServicesImpl = profileServicesImpl;
    }

    @GetMapping()
    public List<ProfileDto> getProfileList() {

        return profileServicesImpl.findAll();
    }

    @PostMapping()
    public Profile createProfile(@RequestBody Profile request) {

        return profileServicesImpl.create(request);
    }

    @GetMapping("/{id}")
    public Optional<ProfileDto> getProfileId(@PathVariable Long id) {
        return Optional.ofNullable(profileServicesImpl.findById(id));
    }

    @PatchMapping("/{id}")
    public Profile modifyProfile(@PathVariable Long id, @RequestBody Profile profile) {
        return profileServicesImpl.update(id, profile);
    }

    @DeleteMapping("/{id}")
    public boolean deleteProfile(@PathVariable Long id) {
        return profileServicesImpl.delete(id);
    }
}

