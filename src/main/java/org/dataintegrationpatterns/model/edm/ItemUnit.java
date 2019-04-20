package org.dataintegrationpatterns.model.edm;

import java.util.Arrays;

public enum ItemUnit {
    PIECE("Piece"),
    METER("Meter"),
    HOUR("Hour"),
    DAY("Day"),
    OTHER("Other");

    private final String name;

    private ItemUnit(String name) {
        this.name = name;
    }

    public static ItemUnit fromString(String name) {
        return Arrays.stream(ItemUnit.values())
                .filter(pt -> pt.name.equals(name))
                .findFirst().orElse(OTHER);
    }
}
