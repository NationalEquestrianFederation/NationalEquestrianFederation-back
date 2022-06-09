package com.example.NationalEquestrianFederation.controller;

import com.example.NationalEquestrianFederation.dto.HorseClubDto;
import com.example.NationalEquestrianFederation.exceptions.ResourceConflictException;
import com.example.NationalEquestrianFederation.iservice.IHorseClubService;
import com.example.NationalEquestrianFederation.iservice.IRoleService;
import com.example.NationalEquestrianFederation.iservice.IUserService;
import com.example.NationalEquestrianFederation.mapper.HorseClubMapper;
import com.example.NationalEquestrianFederation.model.HorseClub;
import com.example.NationalEquestrianFederation.model.Role;
import com.example.NationalEquestrianFederation.model.User;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Locale;
import java.util.Optional;

@RestController
@RequestMapping(value = "/horseClubs", produces = MediaType.APPLICATION_JSON_VALUE)
@CrossOrigin
@AllArgsConstructor
public class HorseClubController {

    private final IHorseClubService horseClubService;

    private final IUserService userService;

    private final IRoleService roleService;

    @GetMapping
    public ResponseEntity<List<HorseClub>> getHorseClubs(@RequestParam String name) {
        return new ResponseEntity<>(horseClubService.findAll(name), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<HorseClub>> getHorseClubById(@PathVariable Integer id) {
        return new ResponseEntity<>(horseClubService.findById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<HorseClub> addHorseClub(@RequestBody HorseClubDto horseClubDto) {
        HorseClub horseClub = HorseClubMapper.convertToHorseClub(horseClubDto);
        horseClub.setOwner(registerOwner(horseClub.getName()));
        return new ResponseEntity<>(horseClubService.addHorseClub(horseClub), HttpStatus.CREATED);
    }

    private User registerOwner(String name) {

        String[] words = name.split(" ");
        StringBuilder username = new StringBuilder(words[0].toLowerCase());
        if(words.length > 1) {
            for(int i = 1; i <= words.length; i++){
                username.append(words[i].substring(0, 1).toUpperCase()).append(words[i].substring(1));
            }
        }

        if(!doesUsernameExist(String.valueOf(username))) {
            Role role = roleService.getByName("ROLE_HORSE_CLUB");
            User user = new User(String.valueOf(username), String.valueOf(username), role);
            return userService.register(user);
        } else {
            return null;
        }
    }

    private boolean doesUsernameExist(String username) {
        User existUser = this.userService.findByUsername(username);
        return existUser != null;
    }

    @PutMapping
    public ResponseEntity<String> editHorseClub(@RequestBody HorseClub horseClub) {
        horseClubService.editHorseClub(horseClub);
        return new ResponseEntity<>("Successfully edited", HttpStatus.OK);
    }

}
