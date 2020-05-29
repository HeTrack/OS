package laba2_OS;

public class TableBlock {
    private final int size = 4;
    private Page[] Block = new Page[size];

    public Page removePage() {
        int index = 0;
        for (int i = 1; i < size; i++) {
            if (Block[i].getNumberCalls() < Block[index].getNumberCalls()) {
                index = i;
            }
        }

        Page page = Block[index];
        Block[index] = null;
        return page;
    }

    public Page getPageWithAddress(int address) {
        for (int i = 0; i < size; i++) {
            if (Block[i].isHasAddress(address)) 
            	return Block[i];
        }

        return null;
    }

    public void setPage(Page page) {
        for (int i = 0; i < size; i++) {
            if (Block[i] == null) {
            	Block[i] = page;
                return;
            }
        }
    }

    public int getSize() {
        return size;
    }
}