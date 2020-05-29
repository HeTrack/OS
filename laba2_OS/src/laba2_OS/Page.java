package laba2_OS;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Page {
    private int index;

    private final int Address;
    private final int size;

    private int numberCalls;

    public Page(int indexPage, int Address, int size) {
        index = indexPage;

        this.Address = Address;
        this.size = size;

        numberCalls = 0;
    }

    public boolean isHasAddress(int address) {
        return (Address <= address && address <= Address + size);
    }

    public void callAddress(int address) {
        System.out.println(MessageFormat.format("Обращение к адресу {0} страницы {1}", address, index));
        numberCalls++;
    }

    public void dropNumberCalls() {
        numberCalls = 0;
    }

    public int getNumberCalls() {
        return  numberCalls;
    }
}
