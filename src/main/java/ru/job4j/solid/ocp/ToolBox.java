package ru.job4j.solid.ocp;

import java.util.ArrayList;
import java.util.List;

public class ToolBox {

    public void kit(Hammer hammer) {
        List<Instrument> list = new ArrayList<>();
        list.add(hammer);
    }
}
