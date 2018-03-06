package fr.esiea;

import static org.junit.Assert.*;

import org.junit.Test;

public class GildedRoseTest {

    @Test
    public void fixSpecialItem() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 11,51), new Item("Sulfuras, Hand of Ragnaros", 11,51),new Item("Aged Brie", 11,51), new Item("Metal Sword", 11,51) };
        GildedRose app = new GildedRose(items);
        
        // UPDATE QUALITY
        app.updateQuality();
            
        // NAME TEST
        assertEquals("Backstage passes to a TAFKAL80ETC concert", app.items[0].name);
        assertEquals("Sulfuras, Hand of Ragnaros", app.items[1].name);
        assertEquals("Aged Brie", app.items[2].name);
        assertEquals("Metal Sword", app.items[3].name);
        
        // QUALITY TEST    quality > 50 ; sellIn >=11
        assertEquals(51, app.items[0].quality);
        assertEquals(51, app.items[1].quality);
        assertEquals(51, app.items[2].quality);
        assertEquals(50, app.items[3].quality);
        
      
        
        // SELLIN TEST     quality > 50 ; sellIn >=11
        assertEquals(10, app.items[0].sellIn);
        assertEquals(11, app.items[1].sellIn);
        assertEquals(10, app.items[2].sellIn);
        assertEquals(10, app.items[3].sellIn);
        
        
        app.items[0].quality=30;
        app.items[1].quality=30;
        app.items[2].quality=30;
        app.items[3].quality=30;
        app.items[1].sellIn=9;
        
        
        // UPDATE QUALITY
        app.updateQuality();
        
        // QUALITY TEST   quality < 50 ; sellIn <11
        assertEquals(32, app.items[0].quality);
        assertEquals(30, app.items[1].quality);
        assertEquals(31, app.items[2].quality);
        assertEquals(29, app.items[3].quality);
        
        // SELLIN TEST    quality < 50 ; sellIn <11   
        assertEquals(9, app.items[0].sellIn);
        assertEquals(9, app.items[1].sellIn);
        assertEquals(9, app.items[2].sellIn);
        assertEquals(9, app.items[3].sellIn);
        
        
        
        
        // sellIn < 6 + not negative quality
        app.items[0].quality=0;
        app.items[1].quality=0;
        app.items[2].quality=0;
        app.items[3].quality=0;
        app.items[0].sellIn=5;
        app.items[1].sellIn=5;
        app.items[2].sellIn=5;
        app.items[3].sellIn=5;
        
        app.updateQuality();
        
        assertEquals(3, app.items[0].quality);
        assertEquals(0, app.items[1].quality);
        assertEquals(1, app.items[2].quality);
        assertEquals(0, app.items[3].quality);
        
        assertEquals(4, app.items[0].sellIn);
        assertEquals(5, app.items[1].sellIn);
        assertEquals(4, app.items[2].sellIn);
        assertEquals(4, app.items[3].sellIn);
        
        // negative sellIn
        app.items[0].quality=5;
        app.items[1].quality=5;
        app.items[2].quality=5;
        app.items[3].quality=5;
        app.items[0].sellIn=-1;
        app.items[1].sellIn=-1;
        app.items[2].sellIn=-1;
        app.items[3].sellIn=-1;
        
        app.updateQuality();
        
        assertEquals(0, app.items[0].quality);
        assertEquals(5, app.items[1].quality);
        assertEquals(7, app.items[2].quality);
        assertEquals(3, app.items[3].quality);
        
        assertEquals(-2, app.items[0].sellIn);
        assertEquals(-1, app.items[1].sellIn);
        assertEquals(-2, app.items[2].sellIn);
        assertEquals(-2, app.items[3].sellIn);

    }

}