package org.example.e_books.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Data
@Configuration
@PropertySource("application.yml")
public class TelegramBotConfig {

	@Value("${telegrambot.name}")
	private String botName;

	@Value("${telegrambot.token}")
	private String botToken;
}
