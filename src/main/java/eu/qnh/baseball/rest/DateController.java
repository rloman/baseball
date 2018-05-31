package eu.qnh.baseball.rest;

import eu.qnh.baseball.model.DateResult;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/date")
public class DateController {

    @GetMapping("{d}/{m}/{y}")
    public ResponseEntity<DateResult> getByDayMonthYear(@PathVariable int d,
                                                        @PathVariable int m,
                                                        @PathVariable int y) {

        y = (m == 1 || m == 2) ? y - 1 : y;

        int c = y / 100; // century
        y = y % 100; // year in 2 digits

        if (m == 1) m = 13; //since Roman times month were from March .. Feb (March was the first Month) 1..12
        if (m == 2) m = 14;
        m -= 2;

        // Zeller's formula
        int weekday = (d + (13 * m - 1) / 5 + y + y / 4 + c / 4 + 5 * c) % 7;

        return ResponseEntity.ok(new DateResult(weekday));
    }
}
