package laba2_OS;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Random;

public class PlanningProcess {
	private ArrayList<Process> processes = new ArrayList<>();
	private Random rnd = new Random();
	private  static int Waiting = 0;
	private  final int QUANT = 5;

	public void IncreaseWait() {
		 this.Waiting++;
	}
	public int getWait(){
		return Waiting;
	}

	public void Plan() {
		for (int i = 0; i < rnd.nextInt(4) + 2; i++) {
			processes.add(new Process(1, i, QUANT,1));
		}		
		for (int i = 0; i < processes.size(); i++) {
			processes.get(i).runProcess();
			if (processes.get(i).getProcTime() > 0) {
				processes.get(i).Quant(QUANT);
				Process proc = processes.get(i);		
				processes.remove(i);
				for (int j = 0; j < processes.size()-1; j++) {
					processes.get(i).setPriority(
							(Waiting + processes.get(i).getProcTime())
									/ processes.get(i).getProcTime());
				}
				
				processes.sort(new Comparator<Process>() {
					public int compare(Process o1, Process o2) {
						if (o1.getvrPriority() == o2.getvrPriority())
							return 0;
						else if (o1.getvrPriority() > o2.getvrPriority())
							return 1;
						else
							return -1;
					}
				});
				processes.add(proc);
				
				proc.setPriority(proc.getPriority());				
				i--;
			}

			else if (processes.get(i).getProcTime() == 0) {
				// System.out.println("i=" + processes.get(i).id);
				processes.remove(processes.get(i));
				for (int j = 0; j < processes.size(); j++) {
					processes.get(i).setPriority(
							(Waiting + processes.get(i).getProcTime())
									/ processes.get(i).getProcTime());
				}
				i--;
				processes.sort(new Comparator<Process>() {
					public int compare(Process o1, Process o2) {
						if (o1.getPriority() == o2.getPriority())
							return 0;
						else if (o1.getPriority() > o2.getPriority())
							return 1;
						else
							return -1;
					}
				});
			}
		}
		processes.clear();
	}
}
