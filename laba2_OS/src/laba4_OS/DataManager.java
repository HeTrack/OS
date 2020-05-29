package laba4_OS;
import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JPanel;

public class DataManager extends JPanel {
	public ArrayList<File> Files = new ArrayList<File>();
	//Block block = new Block();
	Block Memory;
	private boolean startindex;
	private int chsize = 0;
	int fileId = -1;
	private int freememory = 256;
	private ArrayList<Knot> knots = new ArrayList<Knot>();
	
	public DataManager(Block memory) {
		Memory = memory;
	}
	
	public void paint(Graphics g) {
		super.paint(g);
		Memory.Visualmemory(g, this.getWidth(), this.getHeight());
	}
	
	public void CreateFile(int size) {
		startindex = true;
		chsize = 0;
		fileId = Files.size();
		if (size > freememory) {
			Main.textAreaWindow.append("Невозможно добавить файл! \n");
			startindex = false;
			return;
		}
		File file = new File(fileId, size);
		for (int i = 0; i <= 256; i++) {
			if (size > chsize) {
				if (Memory.memory.get(i).getId() != -1) {
					while (Memory.memory.get(i).getId() != -1) {
						i++;
					}
				}
				int fileid = file.getId();
				addKnot(Memory.memory.get(i), fileid);
				freememory--;
				chsize++;
			}
			if (size == chsize) {
				Files.add(fileId, file);
				Main.textAreaWindow.append("Добавлен файл №" + fileId + "\n");
				Main.textAreaWindow.append("Свободно памяти:" + freememory + "\n");
				return;
			}
		}
	}
	
	public void DeleteFile(int id) {
		if (Files.get(id) == null) {
			Main.textAreaWindow.append("Данного файла не сущетвует! \n");
		} else {
			freememory = freememory + Files.get(id).fileSize();
			removeKnots(id);
			Main.textAreaWindow.append("Удалён файл" + Main.textFieldId.getText() + "\n");
		}
		Main.textAreaWindow.append("Свободно памяти:" + freememory + "\n");

	}
	
	public void addKnot(Knot knot, int fileid) {
		knots.add(knot);
		knot.setFile(fileid);
	}

	public void removeKnots(int fileid) {
		for (Knot knot : knots) {
			if (knot.getId() == fileid) {
				knot.setFile(-1);
			}
		}
		knots.clear();
	}
} 