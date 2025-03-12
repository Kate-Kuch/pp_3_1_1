package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import web.model.User;
import web.repository.UserRepository;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping({"", "/"}) // <-- теперь обрабатывает и /user
    public String home() {
        return "redirect:/user/list"; // Редирект на список пользователей
    }

    @GetMapping("/list")
    public String listUsers(Model model) {
        List<User> users = userRepository.findAll();
        model.addAttribute("users", users);
        return "users";
    }

    @GetMapping("/add")
    public String showAddUserForm(Model model) {  // Убрал /user/add -> /add
        model.addAttribute("user", new User());
        return "addUser";
    }

    @PostMapping("/add")
    public String addUser(@ModelAttribute User user) {  // Убрал /user/add -> /add
        userRepository.save(user);
        return "redirect:/user/list";
    }

    @GetMapping("/edit/{id}")
    public String showEditUserForm(@PathVariable Long id, Model model) {
        User user = userRepository.findById(id).orElse(null);
        model.addAttribute("user", user);
        return "editUser";
    }

    @PostMapping("/edit")
    public String editUser(@ModelAttribute User user) {
        userRepository.save(user);
        return "redirect:/user/list";
    }

    @PostMapping("/delete")
    public String deleteUser(@RequestParam Long id) {
        userRepository.deleteById(id);
        return "redirect:/user/list";
    }
}

