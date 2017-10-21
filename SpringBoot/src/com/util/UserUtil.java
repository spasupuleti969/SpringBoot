package com.util;

import java.time.LocalDate;

import com.entity.User;

public class UserUtil {

	public static boolean isBirthDateBeforeToday(LocalDate birthDate) {
		boolean result = false;
		if (birthDate != null && birthDate.isBefore(LocalDate.now())) {
			result = true;
		}
		return result;
	}

	public static boolean isValid(User user) {
		boolean result = false;
		if (user != null && isBirthDateBeforeToday(user.getBirthDate()) && user.getEmail() != null
				&& !user.getEmail().isEmpty()) {
			return true;

		}
		return result;
	}

	public static boolean isValidForUpdate(User user) {
		boolean result = false;
		if (user != null && user.getId() != null && isBirthDateBeforeToday(user.getBirthDate())
				&& user.getPinCode() != null) {
			return true;
		}
		return result;
	}

}
