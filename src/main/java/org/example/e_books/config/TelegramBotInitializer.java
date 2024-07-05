package org.example.e_books.config;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.example.e_books.service.telegramapi.TelegramBotService;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

@Component
@RequiredArgsConstructor
public class TelegramBotInitializer {

	private final TelegramBotService telegramBotService;

	@EventListener({ContextRefreshedEvent.class})
	public void init() throws TelegramApiException {
		TelegramBotsApi telegramBotsApi = new TelegramBotsApi(DefaultBotSession.class);
		try {
			telegramBotsApi.registerBot(telegramBotService);
		} catch (TelegramApiException ex) {
			ex.printStackTrace();

		}
	}
}
