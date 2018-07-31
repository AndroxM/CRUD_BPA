package com.androxmartmarz.BPA.BaseProjectActivity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(path="/api")
public class UserController {

    @Autowired
    UserRepository userRepository;

    // Crear Usuario
    @PostMapping(path="/addUser")
    public @ResponseBody String addNewUser (@RequestParam String name
            , @RequestParam String email) {
        // @ResponseBody means the returned String is the response, not a view name
        // @RequestParam means it is a parameter from the GET or POST request

        User n = new User();
        n.setName(name);
        n.setEmail(email);
        userRepository.save(n);
        return "Saved";
    }

    // Obtener un solo usuario
    @GetMapping(path="/getUser/{id}")
    public User getUserById(@PathVariable(value = "id") int userId){
        return userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User", "id", userId));
    }

    // Actualizar Usuario
    @PutMapping(path="/updateUser/{id}")
    public User updateUser(@PathVariable(value = "id") int userId, @Valid @RequestBody User userDetails){

        User User = userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User", "id", userId));
        User.setId(userDetails.getId());
        User.setName(userDetails.getName());
        User.setEmail(userDetails.getEmail());

        User updatedUser = userRepository.save(User);
        return updatedUser;
    }

    // Eliminar Usuario
    @DeleteMapping(path="/deleteUser/{id}")
    public ResponseEntity<?> deleteNote(@PathVariable(value = "id") int userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User", "id", userId));

        userRepository.delete(user);

        return ResponseEntity.ok().build();
    }

    //Obtener Usuarios
    @GetMapping(path="/getAllUsers")
    public @ResponseBody Iterable<User> getAllUsers() {
        // This returns a JSON or XML with the users
        return userRepository.findAll();
    }
}
