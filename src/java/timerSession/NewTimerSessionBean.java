/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package timerSession;

import java.util.Date;
import javax.ejb.Schedule;
import javax.ejb.Stateless;

/**
 *
 * @author marlo0212
 */
@Stateless
public class NewTimerSessionBean implements NewTimerSessionBeanLocal {

    /**
     * timer for - not sure - create/recreate global chat/s after start/restart?
     * add/change maybe commercials? 
     * chats actualize?  (i know my english suxx ;) )
     */
    @Schedule(dayOfWeek = "Mon-Fri", month = "*", hour = "0-17", dayOfMonth = "*", year = "*", minute = "*", second = "0")
    @Override
    public void myTimer() {
        System.out.println("Timer event: " + new Date());
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
