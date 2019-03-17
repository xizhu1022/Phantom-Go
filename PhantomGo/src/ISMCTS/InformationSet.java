package ISMCTS;


import Game.ChessBoard;

import java.util.ArrayList;

public class InformationSet {
	

	private Game.ChessBoard forbiddenList;
	private Game.ChessBoard knownList;
	private char player;

	InformationSet(Game.ChessBoard forbiddenList,Game.ChessBoard  knownList){
		this.forbiddenList = forbiddenList;
		this.knownList = knownList;

	}

	public boolean equals(InformationSet other){
		if (other.forbiddenList.equals(this.forbiddenList)&&other.knownList.equals(this.knownList))
			return true;
		else
			return false;

	}

	public ChessBoard getBoard(){
		ChessBoard board = new ChessBoard();
		return board;
	}

	public State SampleState(){
		State state = new State(this.getBoard(),player);
           return state;
	}

}
