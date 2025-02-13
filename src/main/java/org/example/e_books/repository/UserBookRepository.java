package org.example.e_books.repository;

import org.example.e_books.model.entity.UserBook;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UserBookRepository extends JpaRepository<UserBook, UUID> {
}
