package com.example.mastercode.controller;

import com.example.mastercode.dto.ProfileDto;
import com.example.mastercode.entities.Profile;
import com.example.mastercode.services.Interface.ProfileService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/rest/profile")
public class ProfileController {

    private final ProfileService instance;

    public ProfileController(ProfileService instance) {
        this.instance = instance;
    }

    @GetMapping()
    public List<ProfileDto> getProfileList() {

        return instance.findAll();
    }

    @PostMapping()
    public Profile createProfile(@RequestBody Profile request) {

        return instance.create(request);
    }

    @GetMapping("/{id}")
    public Optional<ProfileDto> getProfileId(@PathVariable Long id) {
        return Optional.ofNullable(instance.findById(id));
    }

    @PatchMapping("/{id}")
    public Profile modifyProfile(@PathVariable Long id, @RequestBody Profile profile) {
        return instance.update(id, profile);
    }

    @DeleteMapping("/{id}")
    public boolean deleteProfile(@PathVariable Long id) {
        return instance.delete(id);
    }
}

