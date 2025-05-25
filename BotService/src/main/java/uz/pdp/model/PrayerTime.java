package uz.pdp.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class PrayerTime {
    public String region;
    public int regionNumber;
    public int month;
    public int day;
    public Date date;
    public String weekday;
    public Times times;

    @Data
    @Getter
    @Setter
    @JsonIgnoreProperties(ignoreUnknown = true)
    public class Times {
        private String tong_saharlik;
        private String quyosh;
        private String peshin;
        private String asr;
        private String shom_iftor;
        private String hufton;

        public String getTong_saharlik() {
            return tong_saharlik;
        }

        public void setTong_saharlik(String tong_saharlik) {
            this.tong_saharlik = tong_saharlik;
        }

        public String getQuyosh() {
            return quyosh;
        }

        public void setQuyosh(String quyosh) {
            this.quyosh = quyosh;
        }

        public String getPeshin() {
            return peshin;
        }

        public void setPeshin(String peshin) {
            this.peshin = peshin;
        }

        public String getAsr() {
            return asr;
        }

        public void setAsr(String asr) {
            this.asr = asr;
        }

        public String getShom_iftor() {
            return shom_iftor;
        }

        public void setShom_iftor(String shom_iftor) {
            this.shom_iftor = shom_iftor;
        }

        public String getHufton() {
            return hufton;
        }

        public void setHufton(String hufton) {
            this.hufton = hufton;
        }
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public int getRegionNumber() {
        return regionNumber;
    }

    public void setRegionNumber(int regionNumber) {
        this.regionNumber = regionNumber;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getWeekday() {
        return weekday;
    }

    public void setWeekday(String weekday) {
        this.weekday = weekday;
    }

    public Times getTimes() {
        return times;
    }

    public void setTimes(Times times) {
        this.times = times;
    }
}