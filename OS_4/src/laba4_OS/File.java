package laba4_OS;

import java.util.ArrayList;

public class File {
	private Knot knot;
	private int fileSize;
	private int fileId;

	public File(Knot knot) {
		this.knot = knot;
	}
	
	public Knot getKnot(){
		return knot;
	}
	
	public int getId() {
		return fileId;
	}
	
} 
