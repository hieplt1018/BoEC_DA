/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package search;

import java.util.List;
import entity.Clothes;

/**
 *
 * @author asus
 */
public class Memento {

    private State<String, List<Clothes>> state;

    public Memento(State<String, List<Clothes>> state) {
        this.state = state;
    }

    public State<String, List<Clothes>> getState() {
        return state;
    }
}
