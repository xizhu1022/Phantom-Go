package Bot;
import ISMCTS.ISMCTS;
import ISMCTS.InformationSet;
import ISMCTS.State;
import ISMCTS.Node;
import ISMCTS.Action;
public class ISMCTbot {
    public InformationSet set;
    public ISMCTS ismct;
    private char player;

    ISMCTbot(InformationSet set, char player) {
        this.set = set;
        this.player = player;
    }

    public void bot_run() {
        Node rootnode = new Node();
        State state = set.SampleState();
        while (state.getActions().size() > 0) {
            ismct = new ISMCTS(rootnode, 1000, state);
            Action action = ismct.Run();
            state.DoAction(action);
        }


    }
}
