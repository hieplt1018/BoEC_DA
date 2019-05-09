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
 * pattern-memento
 */
public class Originator {

    private String name;
    private List<Clothes> list;
    private State<String, List<Clothes>> state;

    public State<String, List<Clothes>> getState() {
        return state;
    }

    public void setState(State<String, List<Clothes>> state) {
        this.state = state;
    }

    public Memento saveStateToMemento() {
        return new Memento(state);
    }

    public void getStateFromMemento(Memento memento) {
        state = memento.getState();
    }

}
