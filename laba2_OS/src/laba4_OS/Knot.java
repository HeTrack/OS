package laba4_OS;

import java.util.ArrayList;

public class Knot {	
	public ArrayList<Block> TableBlocks = new ArrayList<Block>();
	private int fileSize;
	private int fileId;
	private int knotId;
	private Knot knot;
	private Block block;
	
	public Knot(int knotId, int fileId, int fileSize) {
	    this.knotId = knotId;
		this.fileId = fileId;
		this.fileSize = fileSize;

	} 
	public ArrayList<Block> getTableBlocks() {
		return TableBlocks;
	}
	
	public int getId() {
		return fileId;
	}
	
	public void setId(int id) {
		this.fileId = id;
	}
	
	public void setSize(int size) {
		this.fileSize = size;
	}
	
	public int getSize() {
		return fileSize;
	}
	
	public Knot nextKnot() {
		return knot;
	}
	
	public void setBlock() {
		TableBlocks.add(block);
	}
}