package laba4_OS;
import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

public class Block {

	public int blockId;
	public int blocksize = 4;
	public boolean used = false;
	public static int n = 256;


	public int getBlockId() {
		return blockId;
	}
	 
	
	public void setBlockId(int id) {
		blockId = id;
	}

	
	int cellHeight = 20;
	 int cellWidth = 20;
    int chsize = 0;
    int left = 0;
	 int top = 0;
	public void Visualmemory(Graphics g, int width, int height) {
		paintStartBlock(g, width, height);
		DataManager manager = new DataManager();
		 chsize = 0;
		 left = 0;
		 top = 0;
		for (int i = 0; i < 32; i++) {
			for(int j = 0; j < manager.getList().get(i).getTableBlocks().size();j++) {
				if(manager.getList().get(i).getTableBlocks().get(j).used == true) {
					left = chsize * cellWidth;
					chsize++;
					g.setColor(Color.BLUE);					
		    g.fillRect(left, top, cellWidth, cellHeight);
			g.setColor(Color.WHITE);
			g.drawRect(left, top, cellWidth, cellHeight);
			g.drawString(manager.getList().get(i).getId() + "", left + 5, top + 20);
			if (chsize == 16) {
				top += cellHeight;
				chsize = 0;
				left = 0;
					}
				}
			}
		}
	}
	
	public void paintStartBlock(Graphics g, int width, int height) {
		for (int i = 0; i < 256; i++) {
			left = chsize * cellWidth;
			g.setColor(Color.GRAY);
			chsize++;
		    g.fillRect(left, top, cellWidth, cellHeight);
					g.setColor(Color.WHITE);
					g.drawRect(left, top, cellWidth, cellHeight);
					g.drawString(0 + "", left + 5, top + 20);
					if (chsize == 16) {
						top += cellHeight;
						chsize = 0;
						left = 0;
}
		}
	}
}