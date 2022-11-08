package net.larsmans.infinitybuttons.block.custom.emergencybutton;

import net.minecraft.util.IStringSerializable;

public enum SEBStateEnum implements IStringSerializable {
    OPEN("open"),
    CLOSED("closed"),
    PRESSED("pressed");

    private final String name;

    SEBStateEnum(String name) {
        this.name = name;
    }

    @Override
    public String getString() {
        return this.name;
    }
}
