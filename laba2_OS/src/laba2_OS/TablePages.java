package laba2_OS;

import java.util.ArrayList;
import java.util.Random;

public class TablePages {
	private ArrayList<Page> pages = new ArrayList<Page>();

    public Page removePageWithAddress(int address) {
        for (Page page : pages) {
            if (page.isExist(address)) {
                 return pages.remove(pages.indexOf(page));
            }
        }

        return null;
    }

    public void setPage(Page page) {
        pages.add(page);
    }

    public Page getPage() {
        Random random = new Random();
        return pages.remove(random.nextInt(pages.size()));
    }
}

