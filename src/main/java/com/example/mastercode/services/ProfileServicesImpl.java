package com.example.mastercode.services;

import com.example.mastercode.dto.ProfileDto;
import com.example.mastercode.entities.Profile;
import com.example.mastercode.repositories.ProfileRepository;
import com.example.mastercode.services.Interface.ProfileService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProfileServicesImpl implements ProfileService {

    private final ProfileRepository profileRepository;

    public ProfileServicesImpl(ProfileRepository profileRepository) {
        this.profileRepository = profileRepository;
    }

    private ProfileDto convertEntityDto(Profile profile) {
        ProfileDto profileDto = new ProfileDto();

        profileDto.setIdProfile(profile.getIdProfile());
        profileDto.setFullName(profile.getName().concat(" ").concat(profile.getLastName()));
        profileDto.setAge(profile.getAge());
        profileDto.setPhone(profile.getPhone());
        profileDto.setCreated_at(profile.getCreated_at());
        profileDto.setUpdated_at(profile.getUpdated_at());
        return profileDto;
    }

    @Override
    public List<ProfileDto> findAll() {

        return profileRepository.findAll()
                .stream()
                .map(this::convertEntityDto)
                .collect(Collectors.toList());
    }

    @Override
    public ProfileDto findById(Long idProfile) {

        return convertEntityDto(profileRepository.findById(idProfile).get());
    }

    @Override
    public Profile create(Profile entity) {

        return profileRepository.save(entity);
    }

    @Override
    public Profile update(Long id, Profile entity) {

        Optional<Profile> profileUpdate = profileRepository.findById(id);

        Profile profile = profileUpdate.get();

        if (entity.getName() != null) {
            profile.setName(entity.getName());
        }
        if (entity.getLastName() != null) {
            profile.setLastName(entity.getLastName());
        }
        if (entity.getAge() != null) {
            profile.setAge(entity.getAge());
        }
        if (entity.getPhone() != null) {
            profile.setPhone(entity.getPhone());
        }
        if (entity.getCreated_at() != null) {
            profile.setCreated_at(entity.getCreated_at());
        }
        if (entity.getUpdated_at() != null) {
            profile.setUpdated_at(entity.getUpdated_at());
        }

        return profileRepository.save(profile);
    }

    @Override
    public boolean delete(Long id) {

        profileRepository.deleteById(id);
        return true;
    }
}
