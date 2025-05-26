package uz.pdp.service;

import com.fasterxml.jackson.core.type.TypeReference;
import uz.pdp.model.User;
import uz.pdp.utill.FilePath;
import uz.pdp.utill.JsonUtil;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class UserService {

    public static boolean saveUserIfNotExists(Long chatId, User user) {
        File file = new File(FilePath.PATH_USERS);
        List<User> userList = new ArrayList<>();

        if (file.exists()) {
            userList = JsonUtil.readGson(FilePath.PATH_USERS, new TypeReference<List<User>>() {});
            if (userList == null) userList = new ArrayList<>();
        }

        boolean exists = userList.stream().anyMatch(u -> u.getChatId().equals(chatId));

        if (!exists) {
            userList.add(user);
            JsonUtil.writeGson(FilePath.PATH_USERS, userList);
            return true;
        }
        return false;
    }
}
