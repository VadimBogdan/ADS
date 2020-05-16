package Lab2_2;

public abstract class FSMAutomat {
    protected String text;
    protected State state;

    public FSMAutomat(String text) {
        this.text = text;
        state = State.Initial;
    }

    public abstract boolean scanner();
    protected abstract Event recognizeEvent(char ev);
    protected abstract void handleEvent(Event ev);
}

enum State {Success,Error,Q1,Q2,Q3,Q4,Q5,Initial}
enum Event {Plus,Digit,Percent,EOS,ANY}
