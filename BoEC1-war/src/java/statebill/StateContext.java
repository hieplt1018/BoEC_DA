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
public class StateContext {
    private State state;
 
    public void setState(State state) {
        this.state = state;
    }
 
    public String applyState() {
        return this.state.handleRequest();
    }
}
