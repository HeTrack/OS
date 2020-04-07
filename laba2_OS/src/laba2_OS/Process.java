package laba2_OS;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Process {
	private int id;
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
		System.out.println("Создание: Процесс № " + id + " Квант времени: "
				+ QUANT + ". Штрафное отношение: " + priory);

		for (int i = 0; i < rnd.nextInt(3) + 1; i++) {
			threads.add(new Thread(i, 4 * i + 5));
			System.out.println("Поток " + threads.get(i).getThreadTime()
					+ " был создан. Время жизни потока: "
					+ threads.get(i).getThreadTime());
			this.WorkTime += threads.get(i).getThreadTime();
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

	//переназначение кванта
	public void Quant(int quant) {
		this.QUANT = quant;
	}

	public void IfEndTime(int i, int QUANT) {
		PlanningProcess plan = new PlanningProcess();
		// если поток прервался
		if (QUANT == 0 && WorkTime > 0) {
			priory--;
			System.out.println("Процесс № " + id + " Поток: "
					+ threads.get(i).getId() + " прерван. Времени осталось: "
					+ threads.get(i).getThreadTime());
			System.out.println("Время ожидания = " + plan.getWait());
			System.out.println();
			Thread thread = threads.get(i);
			threads.remove(threads.get(i));
			threads.add(thread);
		} // если поток завершил работу
		else if (threads.get(i).getThreadTime() == 0) {
			System.out.println("Поток: " + threads.get(i).getId() + " завершен.");
		}
		// Если последний поток завершил работу
		if (threads.get(i).getId() == threads.size() - 1
				&& threads.get(i).getThreadTime() == 0) {
			System.out.println("Процесс № " + id + " завершил работу ");			
			System.out.println("Время ожидания = " + plan.getWait());
			System.out.println("\n");
		}
	}

	public void runProcess() {
		for (int i = 0; i < threads.size(); i++) {
			while (threads.get(i).getThreadTime() > 0 && QUANT > 0) {
				System.out.println("Процесс № " + id + " Поток: "
						+ threads.get(i).getId() + " - " + threads.get(i).getThreadTime());
				QUANT--;
				threads.get(i).DecreTime();
				WorkTime--;
				PlanningProcess plan = new PlanningProcess();
				plan.IncreaseWait();
				IfEndTime(i, QUANT);
			}
		}
	}
}
