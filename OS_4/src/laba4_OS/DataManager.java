package laba4_OS;
import java.util.ArrayList;
import java.awt.Graphics;
import javax.swing.JPanel;

public class DataManager extends JPanel{
	private ArrayList<File> files = new ArrayList<File>();
	public  ArrayList<Knot> memory;
	private Block block;
	private boolean startindex;
	private int chsize = 0;
	int knotid = -1;
	int fileId = -1;
	private int freememory = 256;
			
		public void paint(Graphics g) {
			super.paint(g);
			block.Visualmemory(g,this.getWidth(), this.getHeight());
		}
		
		public void startDataManager() {
			memory = new ArrayList<Knot>();
			for (int i = 0; i < 32; i++) {
				memory.add(i, new Knot(i,-1, 0));
			}
		}

	
	public void CreateFile(int size) {
		if (size > freememory) {
			Main.textAreaWindow.append("Невозможно добавить файл, не хватает памяти");
			return;
		}
		for (int i=0;i < memory.size();i++) {
			if(memory.get(i).getId() == -1) {				
					Knot knot = memory.get(i);
					knot.setId(i);
					knot.setSize(size);
					File file = new File(knot);
					files.add(file);
					int countblock = size / block.blocksize;
					while (size != chsize) {
					if(size % block.blocksize !=0)
						countblock +=1;
					}
					for(int j = 0; j < countblock;j++) {
						knot.setBlock();
					}	
		Main.textAreaWindow.append("Добавлен файл №" + fileId + "\n");
				Main.textAreaWindow.append("Свободно памяти:" + freememory + "\n");
				return;
			}
		}
	}
	
	public void DeleteFile(int id) {
		if (files.get(id) == null) {
			Main.textAreaWindow.append("Данного файла не сущетвует! \n");
		} 
		else {
			freememory = freememory + files.get(id).getKnot().getSize();
			files.get(id).getKnot().TableBlocks.clear();
			files.remove(id);			
			Main.textAreaWindow.append("Удалён файл" + Main.textFieldId.getText() + "\n");
		}
		Main.textAreaWindow.append("Свободно памяти:" + freememory + "\n");

	}
	
	public ArrayList<Knot> getList() {
		return memory;
	}
}