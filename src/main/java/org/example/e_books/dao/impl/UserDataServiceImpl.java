package org.example.e_books.dao.impl;

import lombok.RequiredArgsConstructor;
import org.example.e_books.model.entity.UserData;
import org.example.e_books.repository.UserDataRepository;
import org.example.e_books.dao.UserDataService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class UserDataServiceImpl implements UserDataService {

	private final UserDataRepository repository;

	@Override
	public UserData save(UserData userData) {
		return repository.save(userData);
	}

	@Override
	public UserData fetchByUserLoginAndUserName(String targetName, String login) {
		return repository.findByNameAndLogin(targetName, login).orElse(null);
	}



	@Override
	public void updateUserLoginAtAndSaveUserIfNotExit(String targetName, String userLogin) {
		UserData user = this.fetchByUserLoginAndUserName(targetName, userLogin);

		if (Objects.nonNull(user)) {
			user.setLastActiveAt(LocalDateTime.now());
			this.save(user);

		} else {
			UserData userData = new UserData();

			userData.setName(targetName);
			userData.setLogin("@"+userLogin);
			userData.setLoginAt(LocalDateTime.now());
			userData.setLastActiveAt(LocalDateTime.now());
			userData.setIsActive(true);

			this.save(userData);
		}
	}

	@Override
	public UserData updateUser(UserData user) {
		return null;
	}
}
