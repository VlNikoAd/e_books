package org.example.e_books.dao.impl;

import lombok.RequiredArgsConstructor;
import org.example.e_books.repository.UserRepository;
import org.example.e_books.dao.UserService;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

	private UserRepository repository;
}