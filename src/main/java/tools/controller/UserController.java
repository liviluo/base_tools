package tools.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import tools.model.BaseResponse;
import tools.model.DataResponse;
import tools.model.user.User;
import tools.service.UserService;

@RestController
@RequestMapping(value = "/user")
public class UserController {

	@Autowired
	UserService userService;

	@RequestMapping(method = RequestMethod.GET)
	public DataResponse<User> get(Integer id) throws Exception {
		return userService.get(id);
	}

	@RequestMapping(method = RequestMethod.POST)
	public DataResponse<Integer> add(@RequestBody User user) throws Exception {
		return userService.add(user);
	}

	@RequestMapping(method = RequestMethod.PUT)
	public BaseResponse update(@RequestBody User user) throws Exception {
		return userService.update(user);
	}

	@RequestMapping(method = RequestMethod.DELETE)
	public BaseResponse delete(Integer id) throws Exception {
		return userService.delete(id != null ? id : 1);
	}

}
