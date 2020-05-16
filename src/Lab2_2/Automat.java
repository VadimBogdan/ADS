package Lab2_2;

public class Automat extends FSMAutomat {
    private Event event;
    public Automat(String text) {
        super(text);
    }

    public State getState() {
        return state;
    }

    @Override
    public boolean scanner() {
        int count = 0;
        do {
            if (count < this.text.length())
                event = recognizeEvent(text.charAt(count));
            else
                event = Event.EOS;
            handleEvent(event);
            count++;
        }
        while (state != State.Success && state != State.Error);
        return state == State.Success;
    }

    @Override
    protected Event recognizeEvent(char ch) {
        Event temp;
        switch (ch) {
            case '+':
                temp = Event.Plus;
                break;
            case '%':
                temp = Event.Percent;
                break;
            case '0': case'1': case'2': case'3': case'4': case'5': case'6': case'7': case'8': case'9':
                temp = Event.Digit;
                break;
            default:
                temp = Event.ANY;
                break;
        }
        return temp;
    }

    @Override
    protected void handleEvent(Event ev) {
        switch (state) {
            case Initial:
                switch (event) {
                    case Plus:
                        state = State.Q1;
                        break;
                    default:
                        state = State.Error;
                        break;
                }
                break;
            case Q1:
                switch (event) {
                    case Digit:
                        state = State.Q2;
                        break;
                    default:
                        state = State.Error;
                }
                break;
            case Q2:
                switch (event) {
                    case Digit:
                        state = State.Q2;
                        break;
                    case Plus:
                        state = State.Q3;
                        break;
                    default:
                        state = State.Error;
                        break;
                }
                break;
            case Q3:
                switch (event) {
                    case Percent:
                        state = State.Q4;
                        break;
                    default:
                        state = State.Error;
                        break;
                }
                break;
            case Q4:
                switch (event) {
                    case Plus:
                        state = State.Q5;
                        break;
                    default:
                        state = State.Error;
                        break;
                }
                break;
            case Q5:
                switch (event) {
                    case Digit:
                        state = State.Q5;
                        break;
                    case EOS:
                        state = State.Success;
                        break;
                    default:
                        state = State.Error;
                        break;
                }
                break;
        }
    }
}
