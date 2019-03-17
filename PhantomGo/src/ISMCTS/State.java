package ISMCTS;

import java.util.ArrayList;

import Game.ChessBoard;
import Game.Coord;
import ISMCTS.Action;

public class State{
	private ChessBoard board;
	public char player;
	private InformationSet set;
	State(ChessBoard board,char player){
		this.board = board;
		this.player = player;
	}

	public ArrayList<Action> getActions(){
		//	System.out.println("get possible moves");
		ArrayList<Action> result = new ArrayList<Action>();
		// Get possible moves
			for (int x = 0; x < 9; x++) {
				for (int y = 0; x < 9; x++) {
					if (board.isLegal(x, y))
						result.add(new Action(x, y)); //?
				}
			}
		return result;
	}

//计划修改本函数
	public State CloneAndRandomize(){
		State state = null;
		return state;
	}

	public void DoAction(Action action){
		Coord coord = new Coord(action.x,action.y);
		board.SetChess(coord,player);
		if(player =='b')
			player = 'w';
		else
			player = 'b';
	}

	//得到结果
	public int GetResult(char player){
		return 0;
	}


}
