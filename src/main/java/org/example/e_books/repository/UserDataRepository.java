package org.example.e_books.repository;

import org.example.e_books.model.entity.UserData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface UserDataRepository extends JpaRepository<UserData, UUID> {

	Optional<UserData> findByNameAndLogin(String targetName, String login);
}
