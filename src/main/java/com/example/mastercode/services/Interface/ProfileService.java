package com.example.mastercode.services.Interface;

import com.example.mastercode.dto.ProfileDto;
import com.example.mastercode.entities.Profile;

import java.util.List;

public interface ProfileService{
    List<ProfileDto> findAll();
    ProfileDto findById(Long id);
    Profile create(Profile entity);
    Profile update(Long id, Profile entity);
    boolean delete (Long id);
}
