package com.surubedai.extrememetals;

import com.surubedai.extrememetals.regi.ExtremeMetalsAddItems;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.RegistryObject;

public enum MaterialColors {
    SILVER("silver", 0x78CDE6),
    COPPER("copper", 0xED7748),
    TIN("tin", 0xF78EA7),
    BRONZE("bronze", 0xF28378),
    ZINC("zinc", 0xAB5477),
    BRASS("brass", 0xCC6660),
    IRON("iron", 0xC9C9C9),
    PIG_IRON("pig_iron", 0xB7B7B7),
    STEEL("steel", 0xA4A4A4);

    public final String name;
    public final int color;
    public final RegistryObject<Item> ingot;
    public final RegistryObject<Item> plate;

    MaterialColors(String name, int color) {
        this.name = name;
        this.color = color;
        // コンストラクタ内で自動登録してフィールドに保持
        this.ingot = ExtremeMetalsAddItems.registerSimple(name + "_ingot");
        this.plate = ExtremeMetalsAddItems.registerSimple(name + "_plate");
    }
}
