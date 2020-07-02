package laba4_OS;

import java.util.ArrayList;

public class File {
	private int fileSize;
	private int fileId;
	private String Name;
	
	private Knot knot;
	
	public File(int fileId, int fileSize, String Name) {
		this.fileId = fileId;
		this.fileSize = fileSize;
		this.Name = Name;
	}
	public Knot getKnot() {
		return knot.nextKnot();
	}
	public int getId() {
		return fileId;
	}

	public int fileSize() {
		return fileSize;
	}
	public String fileName() {
		return Name;
	}
}