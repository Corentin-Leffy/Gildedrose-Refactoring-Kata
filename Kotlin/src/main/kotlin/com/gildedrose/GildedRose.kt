package com.gildedrose

class GildedRose(private val items: Array<Item>) {

    fun incrementQuality() {
        for (item in items) {
            update(item)
        }
    }

    private fun update(item: Item) {
        when (item.name) {
            "Aged Brie" -> {
                item.incrementQuality()
                item.decrementSellIn()
                if (item.sellIn < 0) {
                    item.incrementQuality()
                }
            }
            "Backstage passes to a TAFKAL80ETC concert" -> {
                item.incrementQuality()
                if (item.sellIn < 11 && item.quality < 50) {
                    item.quality++
                }
                if (item.sellIn < 6 && item.quality < 50) {
                    item.quality++
                }
                item.decrementSellIn()

                if (item.sellIn < 0) {
                    item.quality = 0
                }
            }
            "Sulfuras, Hand of Ragnaros" -> {
            }
            else -> item.updateQuality()
        }
    }
}
