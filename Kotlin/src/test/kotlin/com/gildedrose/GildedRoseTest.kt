package com.gildedrose

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class GildedRoseTest {

    private val items = arrayOf(
        Item("+5 Dexterity Vest", 10, 20), //
        Cheese("Aged Brie", 2, 0), //
        Item("Elixir of the Mongoose", 5, 7), //
        Legendary("Sulfuras, Hand of Ragnaros", 0, 80), //
        Legendary("Sulfuras, Hand of Ragnaros", -1, 80),
        BackstagePasses("Backstage passes to a TAFKAL80ETC concert", 15, 20),
        BackstagePasses("Backstage passes to a TAFKAL80ETC concert", 10, 49),
        BackstagePasses("Backstage passes to a TAFKAL80ETC concert", 5, 49),
        // this conjured item does not work properly yet
        Item("Conjured Mana Cake", 3, 6)
    )

    private val legacyItems = arrayOf(
        Item("+5 Dexterity Vest", 10, 20), //
        Cheese("Aged Brie", 2, 0), //
        Item("Elixir of the Mongoose", 5, 7), //
        Legendary("Sulfuras, Hand of Ragnaros", 0, 80), //
        Legendary("Sulfuras, Hand of Ragnaros", -1, 80),
        BackstagePasses("Backstage passes to a TAFKAL80ETC concert", 15, 20),
        BackstagePasses("Backstage passes to a TAFKAL80ETC concert", 10, 49),
        BackstagePasses("Backstage passes to a TAFKAL80ETC concert", 5, 49),
        // this conjured item does not work properly yet
        Item("Conjured Mana Cake", 3, 6)
    )

    @Test
    internal fun `Legacy Gilded Rose must have the same behaviour then the new Gilded Rose`() {
        val gildedRose = GildedRose(items)
        val legacyGildedRose = LegacyGildedRose(legacyItems)

        for (i in 0..100) {
            gildedRose.incrementQuality()
            legacyGildedRose.updateQuality()

            assertArrayEquals(legacyItems, items)
        }
    }

    @Test
    internal fun `Conjured item should decrement quality two times faster`() {
        val conjured = Conjured("", 3, 6)
        val gildedRose = GildedRose(arrayOf(conjured))

        gildedRose.incrementQuality()

        val expectedConjured = Conjured("", 2, 4)
        assertEquals(expectedConjured, conjured)
    }
}
