package fr.esiea;

import static org.junit.Assert.*;

import org.junit.Test;

public class GildedRoseTest {

    @Test
    public void fixname() {
        Item[] items = new Item[] { new Item("Metal Sword", 0, 0) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("fixme", app.items[0].name);
    }
    public void fixquality() {
        Item[] items = new Item[] { new Item("Metal Sword", 0,10) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(9, app.items[0].quality);
    }

    public void fixprice() {
        Item[] items = new Item[] { new Item("Metal Sword", 10,0) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(9, app.items[0].sellIn);
    }

    public void Sulfuras_name() {
        Item[] items = new Item[] { new Item("Sulfuras, Hand of Ragnaros", 0, 0) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("Sulfuras, Hand of Ragnaros", app.items[0].name);
    }
    
    public void Sulfuras_quality() {
        Item[] items = new Item[] { new Item("Sulfuras, Hand of Ragnaros", 0,10) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(9, app.items[0].quality);
    }
    
    public void Sulfuras_sellIn() {
        Item[] items = new Item[] { new Item("Sulfuras, Hand of Ragnaros", 10,0) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(9, app.items[0].sellIn);
    }
    
}