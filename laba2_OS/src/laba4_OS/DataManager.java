package laba4_OS;
import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class DataManager extends JPanel {
	public ArrayList<File> Files = new ArrayList<File>();
	private int chsize;
	int fileId;
	private int freeMemory = 256;
	Block Memory;
	private ArrayList<Knot> knots = new ArrayList<Knot>();
	
	public DataManager(Block memory) {
		Memory = memory;
	}
	public void paint(Graphics g) {
		super.paint(g);
		Memory.Visualmemory(g, this.getWidth(), this.getHeight());
	}
	public void CreateFile(int size, String name) {
		chsize = 0;
		fileId = Files.size();
		if (size > freeMemory) {
			Main.textAreaWindow.append("Невозможно добавить файл! \n");
			JOptionPane.showMessageDialog(null, "Недостаточно памяти!");
			return;
		}
		else {
		File file = new File(fileId, size, name);
		
		for (int i = 0; i <= 256; i++) {
			if (size > chsize) {
				if (Memory.memory.get(i).getId() != -1) {
					while (Memory.memory.get(i).getId() != -1) {
						i++;
					}
				}
				int fileId = file.getId();
				addKnot(Memory.memory.get(i), fileId);
				freeMemory--;
				chsize++;
			}
			if (size == chsize) {
				Files.add(fileId, file);
				Main.textAreaWindow.append("Добавлtн файл с именем " + name+" с id" + fileId + "\n");
				Main.textAreaWindow.append("Свободно памяти:" + freeMemory + "\n");
				return;
			}
		}
		}
	}

	public void DeleteFile(int id) {
		if (Files.get(id) == null) {
			Main.textAreaWindow.append("Данного файла не сущетвует! \n");
			JOptionPane.showMessageDialog(null, "Данного файла не сущетвует!");
			return;
		} else {
			freeMemory = freeMemory + Files.get(id).fileSize();
			removeKnots(id);
			Main.textAreaWindow.append("Удалён файл с именем" + Main.textId.getName()+" с № " + Main.textId.getText() + "\n");
		}
		Main.textAreaWindow.append("Свободно памяти:" + freeMemory + "\n");

	}

	public void SelectFile(int id) {
		if (Files.get(id) == null) {
			Main.textAreaWindow.append("Данного файла не сущетвует! \n");
			JOptionPane.showMessageDialog(null, "Данного файла не сущетвует!");
			return;
		} else {
			for (int i=0; i<knots.size(); i++) {
				Knot knot= knots.get(i);
				knot.setSelect(true);
			}
		}
	}
	public void CancelFile() {
		for(int j=0; j<knots.size(); j++) {
			knots.get(j).setSelect(false);
			}
	}
	public void addKnot(Knot knot, int fileid) {
		knots.add(knot);
		knot.setFile(fileid);
	}

	public void removeKnots(int fileId) {
		for(int i=0; i<knots.size(); i++) {
			if (knots.get(i).getId() == fileId) {
				knots.get(i).setFile(-1);
			}
		}
		knots.clear();
	}
}