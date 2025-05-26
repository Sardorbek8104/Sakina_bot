package uz.pdp.service;

import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Location;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;
import uz.pdp.utill.BotUtil;

import java.util.ArrayList;
import java.util.List;

public class MosqueBotService {

    public SendMessage requestUserLocation(long chatId) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(chatId);
        sendMessage.setText("Iltimos, eng yaqin masjidni topish uchun joylashuvingizni ulashing 📍");

        // Share Location tugmasi
        KeyboardButton locationButton = new KeyboardButton("📍 Lokatsiyani ulashish");
        locationButton.setRequestLocation(true); // <<<< bu juda muhim

        // Orqaga tugmasi
        KeyboardButton backButton = new KeyboardButton("Back");

        // Klaviatura yaratish
        KeyboardRow row = new KeyboardRow();
        row.add(locationButton);

        KeyboardRow row2 = new KeyboardRow();
        row2.add(backButton);

        List<KeyboardRow> keyboard = new ArrayList<>();
        keyboard.add(row);
        keyboard.add(row2);

        ReplyKeyboardMarkup markup = new ReplyKeyboardMarkup();
        markup.setKeyboard(keyboard);
        markup.setResizeKeyboard(true);
        markup.setOneTimeKeyboard(true);

        sendMessage.setReplyMarkup(markup);

        return sendMessage;
    }


    public String getMapLink(Location userLocation) {
        double latitude = userLocation.getLatitude();
        double longitude = userLocation.getLongitude();

        // Google Maps URL for nearby mosques
        return String.format(
                "https://www.google.com/maps/search/?api=1&query=mosque&location=%f,%f",
                latitude, longitude);
    }
}
