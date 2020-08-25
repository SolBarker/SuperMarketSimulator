package ulead.ac.cr.queue;

import java.util.LinkedList;
import java.util.Queue;

public class QueueNP extends Casher {

	protected void PriorityQueue(int personas, int i, boolean b) {

		if (personas != 0 && super.QuequeP.isEmpty()) {
			if (super.Casher[0] == 0) {
				VacioPrimeraOpcion(personas, i, Casher);
				return;
			} else {
				VacioSegundoOpcion(i, Casher);
				if (Casher[0] == 0) {
					VacioPrimeraOpcion(personas, i, Casher);
					return;
				} else {
					addQueueP(personas);
					return;
				}
			}
		} else if (personas != 0 && !super.QuequeP.isEmpty()) {
			if (Casher[0] == 0) {
				LlenoPrimeraOpcion(personas, i, Casher);
				return;
			} else if (Casher[0] != 0) {
				VacioSegundoOpcion(i, Casher);
				if (Casher[0] == 0) {
					LlenoPrimeraOpcion(personas, i, Casher);
					return;
				} else {
					HoldTime();
					addQueueP(personas);
					return;
				}
			}
		} else if (b == true && Casher[0] != 0) {
			VacioSegundoOpcion(i, Casher);
			if (Casher[0] == 0 && !QuequeP.isEmpty()) {
				LlenoPrimeraOpcion(personas, i, Casher);
			} else if (Casher[0] != 0 && !QuequeP.isEmpty())
				HoldTime();
		}
	}

	protected void SingleQueue(int personas, int i, boolean b) {
		if (personas != 0 && QuequeN.isEmpty()) {
			if (i < Casher.length) {
				if (super.Casher[i] == 0) {
					COPrimeraOpcion(personas, i, b);
					return;
				} else {
					VacioSegundoOpcion(i, Casher);
					if (Casher[i] == 0) {
						COPrimeraOpcion(personas, i, b);
						return;
					} else {
						SingleQueue(personas, ++i, b);
						return;
					}
				}
			} else if (i >= Casher.length && personas != 0) {
				addQueueN(personas);
				return;
			}
		} else if (personas != 0 && !QuequeN.isEmpty()) {
			if (i < Casher.length) {
				if (Casher[i] == 0) {
					LlenoPrimeraOpcionNormal(personas, i, Casher, b);
					return;
				} else {
					VacioSegundoOpcion(i, Casher);
					if (Casher[i] == 0) {
						LlenoPrimeraOpcionNormal(personas, i, Casher, b);
						return;
					} else {
						SingleQueue(personas, ++i, b);
						return;
					}
				}
			} else if (personas != 0 && i >= Casher.length) {
				CasherTime();
				addQueueN(personas);
				return;
			}
		} else {
			if (i < Casher.length) {

				if (super.Casher[i] == 0) {
					if (!QuequeN.isEmpty()) {
						LlenoPrimeraOpcionNormal(personas, i, Casher, b);
						return;
					} else {
						SingleQueue(personas, ++i, b);
						return;
					}
				} else {
					VacioSegundoOpcion(i, Casher);
					if (super.Casher[i] == 0) {
						if (!QuequeN.isEmpty()) {
							LlenoPrimeraOpcionNormal(personas, i, Casher, b);
							return;
						} else {
							SingleQueue(personas, ++i, b);
							return;
						}
					} else {
						SingleQueue(personas, ++i, b);
						return;
					}
				}
			} else {
				CasherTime();
			}
		}
	}

	// Metodos de cola normal/////////////////////////////////
	private void COPrimeraOpcion(int personas, int i, boolean b) {
		Casher[i] = super.TimeByPerson();
		peopledone++;
		SingleQueue(--personas, ++i, b = personas == 0 ? true : false);

	}

	private void LlenoPrimeraOpcionNormal(int personas, int i, int[] mostrador, boolean b) {
		super.HoldTime += super.QuequeN.poll();
		PeopleInQueue -= 1;
		mostrador[i] = super.TimeByPerson();
		peopledone++;
		SingleQueue(personas, ++i, b);

	}

	private void addQueueN(int personas) {
		if (personas != 0) {
			super.PeopleInQueue++;
			QuequeN.add(0);
			addQueueN(--personas);
		}
	}
	private void CasherTime() {
		Queue<Integer> Quetemp = new LinkedList<Integer>();
		if (!QuequeN.isEmpty()) {
			QuequeN.stream().forEach(S -> Quetemp.add(S + 1));
			QuequeN.clear();
			QuequeN.addAll(Quetemp);
		}
		
	}

	// METODO COLA PRIODAD/////////////////////////////////////////////////
	private void VacioPrimeraOpcion(int personas, int i, int[] mostrador) {
		super.Casher[0] = super.TimeByPerson();
		super.peopledone++;
		addQueueP(--personas);
	}

	private void VacioSegundoOpcion(int i, int[] mostrador) {
		mostrador[i] -= 1;
		super.SellTime++;
	}

	private void LlenoPrimeraOpcion(int personas, int i, int[] mostrador) {
		super.HoldTime += super.QuequeP.poll();
		PeopleInQueue -= 1;
		mostrador[0] = super.TimeByPerson();
		peopledone++;
		if (QuequeP.isEmpty()) {
			addQueueP(personas);
			return;
		} else {
			HoldTime();
			addQueueP(personas);
			return;
		}

	}

	private void HoldTime() {
		Queue<Integer> Quetemp = new LinkedList<Integer>();
		if (!QuequeP.isEmpty()) {
			QuequeP.stream().forEach(S -> Quetemp.add(S + 1));
			QuequeP.clear();
			QuequeP.addAll(Quetemp);
		}
	}

	private void addQueueP(int personas) {
		if (personas != 0) {
			super.PeopleInQueue++;
			QuequeP.add(0);
			addQueueP(--personas);
		}
	}

}