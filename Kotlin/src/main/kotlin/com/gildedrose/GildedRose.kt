package com.gildedrose

class GildedRose(private val items: Array<Item>) {

    fun incrementQuality() {
        for (item in items) {
            update(item)
        }
    }

    private fun update(item: Item) {
        when (item.name) {
            "Aged Brie" -> item.updateQuality()
            "Backstage passes to a TAFKAL80ETC concert" -> item.updateQuality()
            "Sulfuras, Hand of Ragnaros" -> item.updateQuality()
            else -> item.updateQuality()
        }
    }
}
