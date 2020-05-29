package laba2_OS;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Random;

public class MemoryManagerUnit {
	 private TableBlock physicalMemory;
	    private TablePages virtualMemory;

	    public final int sizeAddress;

	    public MemoryManagerUnit(int sizeAddress) {
	        physicalMemory = new TableBlock();
	        virtualMemory = new TablePages();

	        this.sizeAddress = sizeAddress;
	        CreatePages();
	    }

	    public void RequestPage(int virtualAddress) {
	        Page page = physicalMemory.getPageWithAddress(virtualAddress);
	        if (page == null) {
	            Page lowPage = physicalMemory.removePage();
	            lowPage.dropNumberCalls();
	            virtualMemory.setPage(lowPage);

	            Page pageWithAddress = virtualMemory.removePageWithAddress(virtualAddress);
	            if (pageWithAddress == null) {
	                System.out.println("Нет такого адреса");
	                return;
	            }

	            physicalMemory.setPage(pageWithAddress);
	            RequestPage(virtualAddress);
	        } else {
	            page.callAddress(virtualAddress);
	        }
	    }

	    private void CreatePages() {
	        for (int i = 0; i <= 1024 - sizeAddress; i += sizeAddress) {
	            virtualMemory.setPage(new Page(i / sizeAddress + 1, i, sizeAddress));
	            System.out.println(MessageFormat.format("{0} {1} {2}",i / sizeAddress + 1, i, i + sizeAddress));
	        }

	        for (int i = 0; i < physicalMemory.getSize(); i++) {
	            physicalMemory.setPage(virtualMemory.getPage());
	        }
	    }
	}
