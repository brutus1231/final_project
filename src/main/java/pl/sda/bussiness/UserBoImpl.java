package pl.sda.bussiness;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.sda.dto.UserDto;
import pl.sda.repository.UserRepository;

@Service
public class UserBoImpl {

    @Autowired
    private UserRepository userRepository;

    public void saveUser(UserDto user) {
        System.out.println("save user");
    }
}
