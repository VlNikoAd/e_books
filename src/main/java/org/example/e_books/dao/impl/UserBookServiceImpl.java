package org.example.e_books.dao.impl;

import lombok.RequiredArgsConstructor;
import org.example.e_books.repository.UserBookRepository;
import org.example.e_books.dao.UserBookService;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserBookServiceImpl implements UserBookService {

	private UserBookRepository repository;
}
