package org.example.e_books.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.e_books.repository.BookRepository;
import org.example.e_books.service.BookService;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {

	private BookRepository repository;
}
