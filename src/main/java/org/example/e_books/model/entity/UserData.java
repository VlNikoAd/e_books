package org.example.e_books.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.UuidGenerator;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Entity
@NoArgsConstructor
@Table(name = "user_data")
public class UserData {

	@Id
	@UuidGenerator
	@Column(name = "id", nullable = false)
	private UUID id;

	@Column(name = "name")
	private String name;

	@Column(name = "login")
	private String login;

	@Column(name = "password")
	private String password;

	@Column(name = "login_at", nullable = false)
	private LocalDateTime loginAt;

	@Column(name = "last_active_at", nullable = false)
	private LocalDateTime lastActiveAt;

	@Column(name = "is_active")
	private Boolean isActive;
}
