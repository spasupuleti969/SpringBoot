package com.repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.constant.RestConstants;
import com.entity.User;
import com.exception.ValidationException;

public class UserRepository {

	public List<User> userData() {

		return new ArrayList<>();

	}

	/**
	 * Add user
	 * 
	 * @param user
	 * @return
	 */
	public String addUser(User user) {
		for (User finduser : userData()) {
			// to avoid null pointer exception
			if (finduser != null) {

				// condition to check already Acitve user present with the email
				// Id
				if (finduser.getEmail().equalsIgnoreCase(user.getEmail()) && finduser.isActive()) {
					throw new ValidationException(RestConstants.DUPLICATE_EMAIL);
				} else {
					userData().add(user);
				}
			}

		}
		return user.getId();

	}

	/**
	 * update User
	 * 
	 * @param userId
	 * @param pincode
	 * @param dob
	 * @return
	 */
	public String updateUser(String userId, Integer pincode, LocalDate dob) {

		for (User finduser : userData()) {
			// to avoid null pointer exception
			if (finduser != null) {
				// If user present
				if (finduser.getId().equals(userId) && finduser.isActive()) {
					// since updatable values are Pincode and DOB
					finduser.setPinCode(pincode);
					finduser.setBirthDate(dob);
					userData().add(finduser);
				}
			}
			// no active record found then throw exception
			else {
				throw new ValidationException(RestConstants.NO_ACTIVE_USER);
			}

		}
		return userId;

	}

	public String deleteUser(String userId) {

		for (User finduser : userData()) {

			// to avoid null pointer exception
			if (finduser != null) {
				// If user present
				if (finduser.getId().equals(userId) && finduser.isActive()) {
					// setting active flag as false
					finduser.setActive(false);
					userData().add(finduser);
				}
			}
			// no active record found then throw exception
			else {
				throw new ValidationException(RestConstants.NO_ACTIVE_USER);
			}

		}
		return userId;

	}

}
