package org.example.e_books.dao;

import org.example.e_books.model.entity.UserData;

public interface UserDataService {

	UserData save(UserData userData);

	UserData fetchByUserLoginAndUserName(String login, String targetName);

	void updateUserLoginAtAndSaveUserIfNotExit(String targetName, String userLogin);

	UserData updateUser(UserData user);
}
