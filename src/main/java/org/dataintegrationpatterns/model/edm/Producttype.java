package org.dataintegrationpatterns.model.edm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum Producttype {
    PHONE("Phone"),
    BOOK("Book"),
    FASHION("Fashion"),
    OTHER("Other");

    private final String name;

    public String getName() {
        return  name;
    }


    public static String[] getAllProductTypeNames() {
        return Arrays.stream(Producttype.values()).map(p -> p.getName()).collect(Collectors.toList()).toArray(new String[0]);
    }

    private Producttype(String name) {
        this.name = name;
    }

    public static Producttype fromString(String name) {
        return Arrays.stream(Producttype.values())
                .filter(pt -> pt.name.equals(name))
                .findFirst().orElse(OTHER);
    }
}
