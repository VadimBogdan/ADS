package Lab2_2;

public abstract class FSMTransitionTable {
    protected String word;
    protected TableState currentState;

    public FSMTransitionTable(String word) {
        this.word = word;
        currentState = TableState.Initial;
    }

    public abstract boolean scanner();
    protected abstract TableEvent recognizeEvent(char sym);
    protected abstract void handleEvent(char[] arr, int index, TableEvent curEvent);
}
enum TableState {Success,Error,Initial,Plus1,Digit1,Plus2,Percent,Plus3,Digit2}
enum TableEvent {Plus,Digit,Percent,EOS,ANY}
