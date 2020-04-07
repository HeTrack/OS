package laba2_OS;

public class Thread {
	private int id;
	private int WorkTime;

	public Thread(int id, int WorkTime) {
		this.id = id;
		this.WorkTime = WorkTime;
	}
	
	public int getThreadTime(){
		return WorkTime;
	}
	
	public int getId(){
		return id;
	}
	
public void DecreTime(){
	 WorkTime--;
}
}