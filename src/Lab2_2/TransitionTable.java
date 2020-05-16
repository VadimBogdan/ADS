package Lab2_2;

import java.util.ArrayList;

public class TransitionTable extends FSMTransitionTable
{
    ArrayList<Transition> transitions;
    TableEvent event;

    public TransitionTable(String word)
    {
        super(word);
        transitions = new ArrayList<>();
    }

    @Override
    public boolean scanner()
    {
        buildTransitionTable();
        char[] wArr = word.toCharArray();
        int count = 0;

        do
        {
            if(count < wArr.length)
                event = recognizeEvent(wArr[count]);
            else
                event = TableEvent.EOS;
            handleEvent(wArr,count,event);
            count++;
        }
        while ((currentState != Lab2_2.TableState.Success) && (currentState != Lab2_2.TableState.Error));
        if(currentState == Lab2_2.TableState.Success)
            return Boolean.TRUE;
        else
            return Boolean.FALSE;
    }

    @Override
    protected TableEvent recognizeEvent(char sym)
    {
        event = TableEvent.ANY;
        switch(sym)
        {
            case '0': case '1': case '2': case '3': case '4':
            case '5': case '6': case '7': case '8': case '9':
            event = TableEvent.Digit;
            break;
            case '+':
                event = TableEvent.Plus;
                break;
            case '%':
                event = TableEvent.Percent;
                break;
        }
        return event;
    }

    @Override
    protected void handleEvent(char[] arr, int index, TableEvent curEvent)
    {
        int length = transitions.size();

        for (int i = 0; i < length; i++)
        {
            Transition transition = transitions.get(i);
            if((currentState == transition.startState) && (curEvent == transition.trigger))
            {
                currentState = transition.endState;
                return;
            }
        }
    }

    private void buildTransitionTable()    {
        Transition transit = new Transition(TableState.Initial, TableState.Plus1, TableEvent.Plus); //OK
        transitions.add(transit);
        transit = new Transition(TableState.Initial, TableState.Error,TableEvent.Digit);
        transitions.add(transit);
        transit = new Transition(TableState.Initial, TableState.Error,TableEvent.Percent);
        transitions.add(transit);
        transit = new Transition(TableState.Initial, TableState.Error,TableEvent.ANY);
        transitions.add(transit);
        transit = new Transition(TableState.Initial, TableState.Error,TableEvent.EOS);
        transitions.add(transit);
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        transit = new Transition(TableState.Plus1, TableState.Digit1,TableEvent.Digit);
        transitions.add(transit);
        transit = new Transition(TableState.Plus1, TableState.Error,TableEvent.Plus);
        transitions.add(transit);
        transit = new Transition(TableState.Plus1, TableState.Error,TableEvent.Percent);
        transitions.add(transit);
        transit = new Transition(TableState.Plus1, TableState.Error,TableEvent.ANY);
        transitions.add(transit);
        transit = new Transition(TableState.Plus1, TableState.Error,TableEvent.EOS);
        transitions.add(transit);
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        transit = new Transition(TableState.Digit1, TableState.Plus2,TableEvent.Plus);
        transitions.add(transit);
        transit = new Transition(TableState.Digit1, TableState.Digit1,TableEvent.Digit);
        transitions.add(transit);
        transit = new Transition(TableState.Digit1, TableState.Error,TableEvent.Percent);
        transitions.add(transit);
        transit = new Transition(TableState.Digit1, TableState.Error,TableEvent.ANY);
        transitions.add(transit);
        transit = new Transition(TableState.Digit1, TableState.Error,TableEvent.EOS);
        transitions.add(transit);
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        transit = new Transition(TableState.Plus2, TableState.Percent,TableEvent.Percent);
        transitions.add(transit);
        transit = new Transition(TableState.Plus2, TableState.Error,TableEvent.Plus);
        transitions.add(transit);
        transit = new Transition(TableState.Plus2, TableState.Error,TableEvent.Digit);
        transitions.add(transit);
        transit = new Transition(TableState.Plus2, TableState.Error,TableEvent.ANY);
        transitions.add(transit);
        transit = new Transition(TableState.Plus2, TableState.Error,TableEvent.EOS);
        transitions.add(transit);
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        transit = new Transition(TableState.Percent, TableState.Plus3,TableEvent.Plus);
        transitions.add(transit);
        transit = new Transition(TableState.Percent, TableState.Error,TableEvent.Percent);
        transitions.add(transit);
        transit = new Transition(TableState.Percent, TableState.Error,TableEvent.Digit);
        transitions.add(transit);
        transit = new Transition(TableState.Percent, TableState.Error,TableEvent.ANY);
        transitions.add(transit);
        transit = new Transition(TableState.Percent, TableState.Error,TableEvent.EOS);
        transitions.add(transit);
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        transit = new Transition(TableState.Plus3, TableState.Digit2,TableEvent.Digit);
        transitions.add(transit);
        transit = new Transition(TableState.Plus3, TableState.Error,TableEvent.Plus);
        transitions.add(transit);
        transit = new Transition(TableState.Plus3, TableState.Error,TableEvent.Percent);
        transitions.add(transit);
        transit = new Transition(TableState.Plus3, TableState.Error,TableEvent.ANY);
        transitions.add(transit);
        transit = new Transition(TableState.Plus3, TableState.Error,TableEvent.EOS);
        transitions.add(transit);
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        transit = new Transition(TableState.Digit2, TableState.Success,TableEvent.EOS);
        transitions.add(transit);
        transit = new Transition(TableState.Digit2, TableState.Digit2,TableEvent.Digit);
        transitions.add(transit);
        transit = new Transition(TableState.Digit2, TableState.Error,TableEvent.Plus);
        transitions.add(transit);
        transit = new Transition(TableState.Digit2, TableState.Error,TableEvent.Percent);
        transitions.add(transit);
        transit = new Transition(TableState.Digit2, TableState.Error,TableEvent.ANY);
        transitions.add(transit);
    }
}



