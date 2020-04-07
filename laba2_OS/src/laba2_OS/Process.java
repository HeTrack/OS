package laba2_OS;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Process {
	protected int id;
	private int QUANT;
	private int WorkTime;
	private int priory;
	private List<Thread> threads;

	public Process(int priory, int id, int QUANT) {
		this.id = id;
		this.QUANT = QUANT;
		this.priory = priory;
		Random rnd = new Random();
		threads = new ArrayList<>();
		System.out.println("��������: ������� � " + id + " ����� �������: "
				+ QUANT + ". �������� ���������: " + priory);

		for (int i = 0; i < rnd.nextInt(3) + 1; i++) {
			threads.add(new Thread(i, 4 * i + 5));
			System.out.println("����� " + threads.get(i).id
					+ " ��� ������. ����� ����� ������: "
					+ threads.get(i).WorkTime);
			this.WorkTime += threads.get(i).WorkTime;
		}
		System.out.println();
	}

	public int getProcTime() {
		return WorkTime;
	}

	public int getPriority() {
		return priory;
	}

	public void setPriority(int priory) {
		this.priory = priory;
	}

	//�������������� ������
	public void Quant(int quant) {
		this.QUANT = quant;
	}

	public void IfEndTime(int i, int QUANT) {
		// ���� ����� ���������
		if (QUANT == 0 && WorkTime > 0) {
			System.out.println("������� � " + id + " �����: "
					+ threads.get(i).id + " �������. ������� ��������: "
					+ threads.get(i).WorkTime);
			System.out.println("����� �������� = " + PlanningProcess.Waiting);
			System.out.println();
			Thread thread = threads.get(i);
			threads.remove(threads.get(i));
			threads.add(thread);
		} // ���� ����� �������� ������
		else if (threads.get(i).WorkTime == 0) {
			System.out.println("�����: " + threads.get(i).id + " ��������.");
		}
		// ���� ��������� ����� �������� ������
		if (threads.get(i).id == threads.size() - 1
				&& threads.get(i).WorkTime == 0) {
			System.out.println("������� � " + id + " �������� ������ ");
			System.out.println("����� �������� = " + PlanningProcess.Waiting);
			System.out.println("\n");
		}
	}

	public void runProcess() {
		for (int i = 0; i < threads.size(); i++) {
			while (threads.get(i).WorkTime > 0 && QUANT > 0) {
				System.out.println("������� � " + id + " �����: "
						+ threads.get(i).id + " - " + threads.get(i).WorkTime);
				QUANT--;
				threads.get(i).WorkTime--;
				WorkTime--;
				PlanningProcess.Waiting++;
				IfEndTime(i, QUANT);
			}
		}
	}
}
