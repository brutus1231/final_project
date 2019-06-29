package pl.sda.bussiness;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.sda.repository.UserRepository;

@Service
public class UserBoImpl {

    @Autowired
    private UserRepository userRepository;

    public void saveUser(){
        System.out.println("save user");
    }
}
