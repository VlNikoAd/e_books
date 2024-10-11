package org.example.e_books.service.telegramapi;

import lombok.RequiredArgsConstructor;
import org.example.e_books.config.TelegramBotConfig;
import org.example.e_books.dao.UserDataService;
import org.example.e_books.model.enums.TelegramCommandEnum;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.ArrayList;

@Service
@RequiredArgsConstructor
public class TelegramBotService extends TelegramLongPollingBot {

	private final TelegramBotConfig telegramBotConfig;
	private final ReplyKeyboardMarkup replyKeyboardMarkup = this.initKeyboard();

	private final UserDataService userDataService;

	@Override
	public String getBotUsername() {
		return telegramBotConfig.getBotName();
	}

	@Override
	public String getBotToken() {
		return telegramBotConfig.getBotToken();
	}

	@Override
	public void onUpdateReceived(Update update) {

		if (update.hasMessage() && update.getMessage().hasText()) {

			String messageTest = update.getMessage().getText();
			long chatId = update.getMessage().getChatId();
			String targetName = update.getMessage().getChat().getFirstName();
			String userLogin = update.getMessage().getChat().getUserName();

			userDataService.updateUserLoginAtAndSaveUserIfNotExit(targetName, userLogin);

			TelegramCommandEnum commandEnum = TelegramCommandEnum.findByCommand(messageTest);

			switch (commandEnum) {
				case TelegramCommandEnum.START, START_BUTTON -> this.startCommandReceived(chatId, targetName);
				case TelegramCommandEnum.HELP, HELP_BUTTON -> this.helpCommandReceived(chatId);

				default -> this.sendMessage(chatId, "Prepare operation...");
			}

		}
	}

	private void startCommandReceived(long chatId, String targetName) {

		var answer = "Привет, " + targetName + ", рад видеть тебя! " +
		             "Нажми кнопку 'Помощь' для получения справки, как пользоваться ботом";
		this.sendMessage(chatId, answer);

	}

	private void helpCommandReceived(long chatId) {
		var answer = """
				Справка по использованию бота...
				""";

		this.sendMessage(chatId, answer);
	}

	private void sendMessage(long chatId, String answer) {
		SendMessage outMessage = new SendMessage();
		outMessage.setChatId(String.valueOf(chatId));
		outMessage.setText(answer);

		outMessage.setReplyMarkup(replyKeyboardMarkup);

		try {
			execute(outMessage);
		} catch (TelegramApiException telegramApiException) {
			telegramApiException.printStackTrace();
		}

	}

	private ReplyKeyboardMarkup initKeyboard() {
		ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
		replyKeyboardMarkup.setResizeKeyboard(true);
		replyKeyboardMarkup.setOneTimeKeyboard(false);

		ArrayList<KeyboardRow> keyboardRows = new ArrayList<>();
		KeyboardRow generatePassword = new KeyboardRow();
		generatePassword.add(new KeyboardButton("Старт"));
		generatePassword.add(new KeyboardButton("Помощь"));

		generatePassword.add(new KeyboardButton("Мои книги"));
		generatePassword.add(new KeyboardButton("Добавить книгу"));

		keyboardRows.add(generatePassword);

		replyKeyboardMarkup.setKeyboard(keyboardRows);
		return replyKeyboardMarkup;
	}
}
