package com.example.demo.service;

import com.example.demo.dto.user.AddUserDto;
import com.example.demo.dto.user.GetUserDto;
import com.example.demo.entity.User;
import com.example.demo.enums.StatusEnum;
import com.example.demo.exception.ResponseStatusNotFoundException;
import com.example.demo.repository.PrenotationRepository;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    private PrenotationRepository prenotationRepository;

    public UserService(UserRepository userRepository, PrenotationRepository prenotationRepository) {
        this.userRepository = userRepository;
        this.prenotationRepository = prenotationRepository;
    }

    /**
     * method to add new user account into database
     * @param addUserDto
     * @return
     */
    public AddUserDto addUser( AddUserDto addUserDto) {
        User user = new User();
        user.setId(addUserDto.getId());
        user.setName(addUserDto.getName());
        user.setSurname(addUserDto.getSurname());
        user.setEmail(addUserDto.getEmail());
        userRepository.save(user);
        addUserDto.setId(user.getId());
        addUserDto.setName(user.getName());
        addUserDto.setSurname(user.getSurname());
        addUserDto.setEmail(user.getEmail());
        return addUserDto;
    }

    /**
     * method to find all user accont, for exemple police need to know all user
     * @return
     */
    public List<GetUserDto> findAll() {
        List<User>users=userRepository.findAll();
List<GetUserDto>getUserDtoList=users.stream().map(user->new GetUserDto(user.getId(),user.getName()
,user.getSurname(),user.getPrenotation())).toList();
return getUserDtoList;
    }

    /**
     * method to find sigle  user account
     * @param id
     * @return
     * @throws ResponseStatusNotFoundException
     */
    public GetUserDto findById(Long id) throws ResponseStatusNotFoundException {
        Optional<User> optionalUser = userRepository.findById(id);

        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
          GetUserDto getUserDto = new GetUserDto(user.getId(),user.getName(), user.getSurname(),user.getPrenotation());
            if (user.getStatus() == StatusEnum.ACTIVE) {
                return getUserDto;
            } else {
                throw new ResponseStatusNotFoundException("User is off!");
            }
        } else {
            throw new ResponseStatusNotFoundException("user unfinded!");
        }
    }

    /**
     * method to modify a user accont
     * @param id
     * @param addUserDto
     * @return
     */
    public AddUserDto updateUser(Long id, AddUserDto addUserDto) {
       userRepository.deleteById(id);
        User user = new User();
        user.setId(addUserDto.getId());
        user.setName(addUserDto.getName());
        user.setSurname(addUserDto.getSurname());
        user.setEmail(addUserDto.getEmail());
        userRepository.save(user);
        addUserDto.setId(user.getId());
        addUserDto.setName(user.getName());
        addUserDto.setSurname(user.getSurname());
        addUserDto.setEmail(user.getEmail());
        return addUserDto;
    }

    /**
     * method to remove accont from database
     * @param id
     */
    public void physicalDeliteById(Long id){
      userRepository.deleteById(id);

}

    /**
     * logical delited by id, the account will not delite from database, but it's can't call by get all or getId
     * @param id
     * @return
     */
    public GetUserDto logicalDeleteSecretaryById(Long id) {
        Optional<User> user = userRepository.findById(id);
        User user1;
            if (user.isPresent()) {
                user1 = user.get();
                user1.setStatus(StatusEnum.DELETED);
                userRepository.save(user1);
                return new GetUserDto(user1.getId(),user1.getName(), user1.getSurname(), user1.getPrenotation());
            } else {
                try {
                    throw new ResponseStatusNotFoundException("user not found!");
                } catch (ResponseStatusNotFoundException e) {
                    throw new RuntimeException(e);
                }
            }

        }
    }

