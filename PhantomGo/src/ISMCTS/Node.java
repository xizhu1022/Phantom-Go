package ISMCTS;

import Game.ChessBoard;

import java.util.ArrayList;

public class Node{
	public Action action;  //到这个节点的action

	public Node parent;
	public ArrayList<Node> children;
	private int wins;
	public int visits;
	private int avails;
	private char PlayerJustMove;

	public Node(Action action,Node parent,char PlayerJustMoved){
		this.action = action;
		this.parent = parent;
		this.PlayerJustMove = PlayerJustMoved;
		this.wins = 0;
		this.visits = 0;
		this.avails = 1;

	}

	public Node(){
		this.action = null;
		this.parent = null;
		this.PlayerJustMove = 'e';
		this.wins = 0;
		this.visits = 0;
		this.avails = 1;

	}

	public ArrayList<Action> GetUntriedMoves(ArrayList<Action> legalAction){
		ArrayList<Action> TriedMove = new ArrayList<Action>();
		ArrayList<Action> result = new ArrayList<Action>();
		for(Node child : children){
			TriedMove.add(child.action);
		}
		for(Action action_1 : legalAction){
			for(Action action_2 : TriedMove )
			{
				if(action_2.equals(action_1))
					continue;
			}
				result.add(action_1);
		}
		return result;
	}

	public Node UCBSelectChild(ArrayList<Action> legalAction){
		ArrayList<Node> legalChildren = new ArrayList<Node>();
		for(Node child:children){
			for(Action action :legalAction){
				if(action.equals(child.action))
					legalChildren.add(child);
			}
		}
		double sum = 0;
		double temp = 0;
		Node bestchild = null;
		for(Node child : children) {
			temp = (double) child.wins / (double) child.visits + 0.7 * Math.sqrt(2.0 * Math.log((double) child.avails / (double) child.visits));
			if(temp>sum){
				sum=temp;
				bestchild = child;
			}
			child.avails++;
		}
		return bestchild;
	}

	public Node Addchild(Action action,char PlayerJustMove){
		Node new_Child = new Node(action,this ,PlayerJustMove);
		children.add(new_Child);
		return new_Child;
	}

	//我佛了
	public int Update(State terminalState){
		this.visits++;
		if (this.PlayerJustMove == 'b'){
			return 1;

		}
		else
			return 0;
	}

}

