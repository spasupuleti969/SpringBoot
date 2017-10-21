package com.service;

import com.constant.RestConstants;
import com.dto.ResponseDTO;
import com.entity.User;
import com.entity.UserEntity;
import com.exception.ValidationException;
import com.repository.UserRepository;
import com.util.UserUtil;

@Service
public class UserService {
	@Autowired
	UserRepository userRepository;
	@Autowired
	UserUtil userUtil;

	public UserService(UserRepository userRepository, UserUtil userUtil) {
		this.userRepository = userRepository;
		this.userUtil = userUtil;
	}

	/**
	 * Creating user
	 * 
	 * @param user
	 * @return
	 */
	public ResponseDTO createUser(User user) {
		String userId = null;
		// Checking the email id is already existing in DB
		String  addedUserId = userRepository.addUser(user);
		ResponseDTO dto = new ResponseDTO();
		dto.setResMsg(RestConstants.CREATE_MESSAGE);
		dto.setUserId(addedUserId);
		return dto;

	}

	/**
	 * Updating user details
	 * 
	 * @param user
	 * @return
	 */
	public ResponseDTO updateUser(User user) {
		Integer userId = null;
		String  updatedUserId = userRepository.updateUser(user.getId(), user.getPinCode(), user.getBirthDate());

		ResponseDTO dto = new ResponseDTO();
		dto.setResMsg(RestConstants.UPDATE_MESSAGE);
		dto.setUserId(updatedUserId);
		return dto;

	}

	/**
	 * Deactivating the existing user
	 * 
	 * @param userId
	 * @return
	 */
	public ResponseDTO deleteUser(String userId) {
		String deactivatedUserId = userRepository.deleteUser(userId);
		ResponseDTO dto = new ResponseDTO();
		dto.setResMsg(RestConstants.DELETE_MESSAGE);
		dto.setUserId(deactivatedUserId);
		return dto;

	}
}
