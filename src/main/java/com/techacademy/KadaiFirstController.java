package com.techacademy;

import java.util.Calendar;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class KadaiFirstController {

    @GetMapping("/dayofweek/{date}")
    public String dispDayOfWeek(@PathVariable String date) {
        //substringメソッドを使用し、年/月/日の値取得
        String year = date.substring(0, 4);
        String month = date.substring(4, 6);
        String day = date.substring(6, 8);
        //年月日の値をintに変換
        int yyyy = Integer.parseInt(year);
        int mm = Integer.parseInt(month);
        int dd = Integer.parseInt(day);
        //カレンダークラスを使用
        Calendar calendar = Calendar.getInstance();
        // 日付を指定 (mmは0から始まるため「-1」)
        calendar.set(yyyy, mm-1, dd);
        //曜日を取得 (曜日は1~7の数値であらわされるため、次の配列との対応させるため「-1」)
        int day_of_week = calendar.get(Calendar.DAY_OF_WEEK) - 1;
        //曜日の表示を配列で表記
        String[] week_name = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
        //曜日の値と表記を対応させ結果を反映
        return "実行結果:" + week_name[day_of_week];
    }

    @GetMapping("/plus/{val1}/{val2}")
    public String calcPlus(@PathVariable int val1, @PathVariable int val2) {
        int res = val1 + val2;
        return "実行結果:" + res;
    }

    @GetMapping("/minus/{val1}/{val2}")
    public String calcMinus(@PathVariable int val1, @PathVariable int val2) {
        int res = val1 - val2;
        return "実行結果:" + res;
    }

    @GetMapping("/times/{val1}/{val2}")
    public String calcTimes(@PathVariable int val1, @PathVariable int val2) {
        int res = val1 * val2;
        return "実行結果:" + res;
    }

    @GetMapping("/divide/{val1}/{val2}")
    public String calcDivide(@PathVariable int val1, @PathVariable int val2) {
        int res = val1 / val2;
        return "実行結果:" + res;
    }

}
