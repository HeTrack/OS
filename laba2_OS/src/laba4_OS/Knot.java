package laba4_OS;

import java.util.ArrayList;

public class Knot {
	private int knotId;
	private int fileId;
	private boolean select;
	
	private Knot knot;

	public Knot(int fileId, int knotId) {
		this.fileId = fileId;
		this.knotId = knotId;
	}

	public void setFile(int fileId) {
		this.fileId = fileId;
	}

	public void setUzel(int fileId, int knotId) {
		knot = new Knot(fileId, knotId);
	}

	public Knot nextKnot() {
		return knot;
	}

	public int getKnotId() {
		return knotId;
	}

	public boolean getSelect() {
		return select;
	}

	public void setSelect(boolean select) {
		this.select = select;
	}

	public int getId() {
		return fileId;
	}
}
