package laba4_OS;
import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

public class Block {
	public ArrayList<Knot> memory;
	public int n = 256;

	public Block() {
		memory = new ArrayList<Knot>();
		for (int i = 0; i < n; i++) {
			memory.add(i, new Knot(-1, i));
		}
	}
	public void Visualmemory(Graphics g, int width, int height) {
		int cellHeight = 20;
		int cellWidth = 20;
		int chsize = 0;
		int left = 0;
		int top = 0;
		for (int i = 0; i < n; i++) {
			left = chsize * cellWidth;
			chsize++;
			if (memory.get(i).getId() == -1) {
				g.setColor(Color.GRAY);
			} else {
				g.setColor(Color.BLUE);
			}
			if (memory.get(i).getSelect()) {
				g.setColor(Color.RED);
			}
		    g.fillRect(left, top, cellWidth, cellHeight);
			g.setColor(Color.WHITE);
			g.drawRect(left, top, cellWidth, cellHeight);
			g.drawString(memory.get(i).getId() + "", left + 5, top + 20);
			if (chsize == 24) {
				top += cellHeight;
				chsize = 0;
				left = 0;
			}
		}
	}
} 