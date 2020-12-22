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
                incrementQuality(item)
                decrementSellIn(item)
                if (item.sellIn < 0) {
                    incrementQuality(item)
                }
            }
            "Backstage passes to a TAFKAL80ETC concert" -> {
                incrementQuality(item)
                if (item.sellIn < 11 && item.quality < 50) {
                    item.quality++
                }
                if (item.sellIn < 6 && item.quality < 50) {
                    item.quality++
                }
                decrementSellIn(item)

                if (item.sellIn < 0) {
                    item.quality = 0
                }
            }
            "Sulfuras, Hand of Ragnaros" -> {
            }
            else -> {
                decrementQuality(item)
                decrementSellIn(item)

                if (item.sellIn < 0) {
                    decrementQuality(item)
                }
            }
        }
    }

    private fun decrementQuality(item: Item) {
        if (item.quality > 0) {
            item.quality--
        }
    }

    private fun decrementSellIn(item: Item) {
        item.sellIn--
    }

    private fun incrementQuality(item: Item) {
        if (item.quality < 50) {
            item.quality++
        }
    }
}
