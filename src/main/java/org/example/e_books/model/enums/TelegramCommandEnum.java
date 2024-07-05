package org.example.e_books.model.enums;

import lombok.Getter;

import java.util.stream.Stream;

@Getter
public enum TelegramCommandEnum {

	START(1, "/start"),
	HELP(2, "/help"),

	START_BUTTON(3, "Старт"),
	HELP_BUTTON(4, "Помощь"),

	;

	private final int id;
	private final String command;

	TelegramCommandEnum(int id, String command) {
		this.id = id;
		this.command = command;
	}

	public static TelegramCommandEnum findByCommand(String command) {
		return Stream.of(values())
		             .filter(v -> v.getCommand().equals(command))
		             .findFirst()
		             .orElseThrow(() -> new IllegalArgumentException(
				             "TelegramCommandEnum not found by command: " + command));
	}
}
