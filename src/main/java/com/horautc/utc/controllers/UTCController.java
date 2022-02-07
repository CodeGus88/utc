package com.horautc.utc.controllers;

import com.horautc.utc.service.Clock;
import com.horautc.utc.models.UTCTime;
import com.horautc.utc.service.Tools;
import org.springframework.web.bind.annotation.*;

import java.util.Hashtable;

@RestController
public class UTCController {

    @RequestMapping(value = "api/utctime", method = RequestMethod.POST)
    public UTCTime time(@RequestParam String time, @RequestParam String timezone){ // @RequestBody UTCTime utcTime
        Hashtable<String, Integer> datatime = Tools.getDataTime(time, ':');
        UTCTime utcTime = new UTCTime();
        if(Tools.isDataValid(datatime, timezone)){
            Clock clock = new Clock(datatime);
            clock.incrementsSeconds(Tools.getSecondsIncremented(timezone)* Tools.FLAG_VALUE);
            utcTime.setTime(clock.getTime());
            if(!Tools.RETURN_WORLD_TIME) utcTime.setTimezone(timezone);
            return utcTime;
        }else{
            return utcTime;
        }
    }

}
