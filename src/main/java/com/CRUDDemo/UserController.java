package com.CRUDDemo;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;



@Controller
public class UserController {

	@Autowired
    private UserService userService;
	
	@RequestMapping("/list-users")
    public String viewUserList(Model model) {
        List<User> userList = userService.getAllUsers();
        model.addAttribute("userList", userList);
        return "list-users";
    }
	
	@RequestMapping("/add-user")
    public String viewAddUserPage(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "add-user";
    }
	
	
	@RequestMapping(value = "/save-user", method = RequestMethod.POST)
    public String saveRole(@Valid User user, BindingResult bindingResult, Model model) {
        //check for errors
        if (bindingResult.hasErrors()) {
            return "add-user";
        }
        userService.saveUser(user);
        return "redirect:/list-users";
    }
	
	@RequestMapping(value = "/update-user", method = RequestMethod.POST)
    public String updateUser(@ModelAttribute("user") User user) {
        userService.updateUser(user);
        return "redirect:/list-users";
    }
	
	@RequestMapping("/edit-user/{id}")
    public ModelAndView viewEditUserPage(@PathVariable(name = "id") int id) {
        ModelAndView mav = new ModelAndView("/edit-user");
        User user = userService.getUser(id);
        mav.addObject("user", user);
        List<User> agents = userService.getAllUsers();
        mav.addObject("agents", agents);
        return mav;
    }
	
	@RequestMapping("/delete-user/{id}")
    public String deleteUser(@PathVariable(name = "id") int id) {
        userService.deleteUser(id);
        return "redirect:/list-users";
    }
}
