package hvl.dat_250.assignment_2.service;

import hvl.dat_250.assignment_2.domain.User;
import org.springframework.stereotype.Service;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;

@Service
public class UserService {

    private final Map<String, User> users = new HashMap<>();

    public User createUser(User user) {
        users.put(user.getUsername(), user);
        return user;
    }

    public List<User> getAllUsers() {
        return new ArrayList<>(users.values());
    }

    public User getUserByUsername(String username) {
        return users.get(username);
    }
}
