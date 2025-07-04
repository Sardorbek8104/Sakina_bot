package uz.pdp.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import uz.pdp.model.PrayerTime;
import uz.pdp.utill.FilePath;
import uz.pdp.utill.JsonUtil;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.LocalDate;
import java.util.List;

public class MonthlyPrayerTimesUtil {
    public static ObjectMapper objectMapper = new ObjectMapper();

    public void write() {
        URL url = getUrl();

        try {
            List<PrayerTime> roots = objectMapper.readValue(url, new TypeReference<>() {});
            System.out.println(roots);
            JsonUtil.writeGson(FilePath.PATH_PRAYERTIMES, roots);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private URL getUrl() {
        URL url = null;
        try {
            int currentMonth = LocalDate.now().getMonthValue();
            url = new URL("https://islomapi.uz/api/monthly?region=Toshkent&month=" + currentMonth);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
        return url;
    }

}
