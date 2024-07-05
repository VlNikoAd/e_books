package org.example.e_books.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.UuidGenerator;

import java.util.UUID;

@Data
@NoArgsConstructor
@Entity
@Table(name = "user_book")
public class UserBook {

	@Id
	@UuidGenerator
	@Column(name = "id", nullable = false)
	private UUID id;

	@Column(name = "book_id", nullable = false)
	private UUID bookId;

	@Column(name = "user_id", nullable = false)
	private UUID userId;
}
