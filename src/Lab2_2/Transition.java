package Lab2_2;

public class Transition {
    TableState startState;
    TableState endState;
    TableEvent trigger;

    public Transition(TableState start, TableState end, TableEvent trig) {
        startState = start;
        endState = end;
        trigger = trig;
    }
}
