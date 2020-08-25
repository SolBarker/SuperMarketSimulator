package ulead.ac.cr.queue;

import java.util.LinkedList;
import java.util.Queue;

import ulead.ac.cr.clients.Clients;

public class Casher extends Clients {
	protected int Casher[];
	protected int peopledone;
	protected int PeopleInQueue;
	protected Queue<Integer> QuequeN;
	protected Queue<Integer> QuequeP;
	protected double TimeAcum;

	public Casher() {

		QuequeN = new LinkedList<Integer>();
		QuequeP = new LinkedList<Integer>();
	}

}
