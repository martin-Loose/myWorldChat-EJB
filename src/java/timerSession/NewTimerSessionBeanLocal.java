/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package timerSession;

import javax.ejb.Local;

/**
 *
 * @author marlo0212
 */
@Local
public interface NewTimerSessionBeanLocal {
    
    public void myTimer();
}
