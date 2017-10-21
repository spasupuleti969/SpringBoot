package com.controller;

import com.dto.ResponseDTO;
import com.entity.User;
import com.exception.ValidationException;
import com.service.UserService;
import com.util.UserUtil;

@RestController
@RequestMapping(value = "/user")
public class UserController {
	@Autowired
	UserService userService;

	public UserController(UserService userService) {
		this.userService = userService;
	}

	/**
	 * Creating User
	 * 
	 * @param user
	 * @return
	 */
	@POSTMapping(value = "/User")
	public ResponseDTO createUser(@RequestBody User user) {
		try {
			// Mandatory check for User object
			if (UserUtil.isValid(user)) {
				userService.createUser(user);
			} else {
				throw new ValidationException("Mandatory feilds are missing");
			}
		} catch (ValidationException e) {
			throw e;
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * Updating the existing user details
	 * 
	 * @param user
	 * @return
	 */
	@PUTMapping(value = "/User")
	public ResponseEntity<ResponseDTO> updateUser(@RequestBody User user) {
		try {
			// Mandatory check for User object
			if (UserUtil.isValidForUpdate(user)) {
				userService.updateUser(user);
			} else {
				throw new ValidationException("Mandatory feilds are missing");
			}
		} catch (ValidationException e) {
			throw e;
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * Deleting user 
	 * 
	 * @param user
	 * @return
	 */
	@DELETEMapping(value = "/user")
	public ResponseEntity<ResponseDTO> deleteUser(@PathVariable String userId) {
		// Mandatory check for User object
					if (UserUtil.isValidForUpdate(userEntity)) {
		try {
			userService.deleteUser(userId);
		} catch (ValidationException e) {
			throw e;
		} catch (Exception e) {
			throw e;
		}
	}

}
