package uz.pdp.service;

import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.updatingmessages.EditMessageText;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import uz.pdp.utill.BotUtil;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TasbexBotService {
    private static final Map<Long, Integer> tasbexMap = new HashMap<>();

    public SendMessage getTasbex(long chatId, String data) {
        tasbexMap.put(chatId, tasbexMap.getOrDefault(chatId, 0));
        SendMessage sendMessage = new SendMessage();
        InlineKeyboardMarkup inlineKeyboardMarkup = createInlineKeyboardMarkup(String.valueOf(tasbexMap.get(chatId)) + "\uD83D\uDCFF", "tasbex");
        sendMessage.setChatId(chatId);
        sendMessage.setReplyMarkup(inlineKeyboardMarkup);

        return sendMessage;
    }


    public EditMessageText getUpdateTasbex(long chatId, Integer messageId) {
        EditMessageText editMessageText = new EditMessageText();
        int countTasbex = tasbexMap.getOrDefault(chatId,0);
        countTasbex++;
        if (countTasbex == 33) {
            countTasbex = 0;
        }
        tasbexMap.put(chatId,countTasbex);
        InlineKeyboardMarkup inlineKeyboardMarkup = createInlineKeyboardMarkup(countTasbex + "\uD83D\uDCFF", "tasbex");
        editMessageText.setChatId(chatId);
        editMessageText.setMessageId(messageId);
        editMessageText.setText(countTasbex + "/33");
        editMessageText.setReplyMarkup(inlineKeyboardMarkup);
        return editMessageText;
    }

    private InlineKeyboardMarkup createInlineKeyboardMarkup(String buttonText, String callbackData) {
        return BotUtil.inlineKeyboardMarkup(List.of(buttonText), List.of(callbackData), 1);
    }
}
