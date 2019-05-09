/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package statebill;

/**
 *
 * @author asus
 */
public class SendingState implements State{

    @Override
    public String handleRequest() {
        return "Sending!";
    }
    
}
