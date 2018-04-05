package com.ds.contactapp.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ds.contactapp.command.LoginCommand;
import com.ds.contactapp.command.UserCommand;
import com.ds.contactapp.domain.User;
import com.ds.contactapp.exception.UserBlockedException;
import com.ds.contactapp.services.UserService;

/**
 * handle all user related operations
 * @author Ankit
 *
 */
@Controller
public class UserController {
@Autowired
	private UserService userservice;
	@RequestMapping(value={"/","/index"})
	
	public String index(Model m) {
		m.addAttribute("command", new LoginCommand());
		return "index"; //jsp page and view is resolved by prefix [/WEB-INF/view/] index suffix[.jsp]
	}
	
@RequestMapping(value= "/login",method=RequestMethod.POST)
	
	public String handleLogin(@ModelAttribute("command") LoginCommand cmd,Model m,HttpSession session) {
		try {
			User loggedInUser=userservice.Login(cmd.getLoginName(), cmd.getPassword());
			if(loggedInUser==null) {
				
				// if user login failed
				// add error message and go back to login form
				m.addAttribute("err", "Login Failed! Please enter valid credentials");
				return "index";// return to Login form jsp page after error
			}
			else {
				//if user login is successful
				//check the user role and redirect to appropriate dashboard
				
				if(loggedInUser.getRole().equals(userservice.ADMIN_ROLE)) {
					
				//add user detail in session (assign user session to logged in user)
					addUserSession(loggedInUser, session);
					return "redirect:admin/dashboard";
				}
				else if(loggedInUser.getRole().equals(userservice.USER_ROLE)) {
					
					//add user detail in session (assign user session to logged in user)
					addUserSession(loggedInUser, session);
					return "redirect:user/dashboard";
				}
				else {
					m.addAttribute("err","Invalid user role!");
					return "index";// return to Login form jsp page after error
				}
			}
		} catch (UserBlockedException e) {
			// add error message and go back to login form
			m.addAttribute("err", e.getMessage());
			return "index";// return to Login form jsp page after error
		}
		//return "index"; //jsp page and view is resolved by prefix [/WEB-INF/view/] index suffix[.jsp]
	}
	

	@RequestMapping(value= "/logout")
	public String logout(HttpSession session) {
		session.invalidate();
	return "redirect:index?act=lo";//redirect to index page.flag{action (act) =logout(lo)} used to display message.
	}
	@RequestMapping(value="/user/dashboard")
		public String userDashBoard() {
			return "dashboard_user";
	}
	
	@RequestMapping(value="/admin/dashboard")
	public String adminDashBoard() {
		return "dashboard_admin";
}
	@RequestMapping(value="/admin/users")
	public String getUserList(Model m) {
		m.addAttribute("userList",userservice.getUserList());
		return "users";
}
	@RequestMapping(value="/reg_form")
	public String registerationForm(Model m) {
		UserCommand cmd=new UserCommand();
		m.addAttribute("command", cmd);
		return "reg_form";//jsp page for registration form reg_form
	}
	
	@RequestMapping(value="/register")
	//to access from details use @ModelAttribute
	public String registerUser(@ModelAttribute("command") UserCommand cmd,Model m) {
		try {
		User user=cmd.getUser();//getting user(all details of reg.form) from command object
		user.setRole(userservice.USER_ROLE);
		user.setLoginstatus(userservice.LOGIN_STATUS_ACTIVE);
		userservice.register(user);
		return "redirect:index?act=reg";//Login page
		}catch(DuplicateKeyException e) {
			e.printStackTrace();
			m.addAttribute("err", "User with this name already exists.Please select another username");
			
			return "reg_form";
			
		}
		
		
	}
	/**
	 * code for session management of user
	 * @param u -->user u will be binded to HttpSession session
	 * @param session
	 */
	private void addUserSession(User u,HttpSession session) {
		session.setAttribute("user", u);//binding entire user(all properties) to the session
		session.setAttribute("userid", u.getUserid());//binding user to userid
		session.setAttribute("role", u.getRole());//binding user to role
	
	}
	@RequestMapping(value="/admin/change_status")
	@ResponseBody
	public String changeLoginStatus(@RequestParam Integer userid,@RequestParam Integer loginstatus ) {
		try {
		userservice.changeLoginStatus(userid, loginstatus);
		return "SUCCESS:Status Changed";
		}catch(Exception e) {
			e.printStackTrace();
			return "ERROR:Unable to change status";
		}
	}
		@RequestMapping(value="/check_avail")
		@ResponseBody
		public String checkAvailability(@RequestParam String username) {
			if(userservice.isUsernameExist(username)){
				return "ERROR:This username is already taken.Choose another name";
			}
			else {
				return "Yes!This user name is available";
			}
}
}