package bananaplan.controller;

import bananaplan.service.AttendanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by paulou on 10/20/15.
 * All rights are reserved by BPT
 */
@RestController
public class AttendanceController {

    @Autowired
    private AttendanceService attendanceService;

    @RequestMapping(value = "/attendance/checkIn/{userId}", method = RequestMethod.PUT)
    public void checkIn(@PathVariable Long userId){
        attendanceService.checkIn(userId);
    }

    @RequestMapping(value = "/attendance/checkOut/{userId}", method = RequestMethod.PUT)
    public void checkOut(@PathVariable Long userId){
        attendanceService.checkOut(userId);
    }

}
