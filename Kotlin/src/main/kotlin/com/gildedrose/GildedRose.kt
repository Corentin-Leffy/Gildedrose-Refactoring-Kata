package com.gildedrose

class GildedRose(private val items: Array<Item>) {

    fun updateQuality() {
        for (item in items) {
            update(item)
        }
    }

    private fun update(item: Item) {
        when (item.name) {
            "Aged Brie" -> {
                if (item.quality < 50) {
                    item.quality++
                }

                item.sellIn--

                if (item.sellIn < 0 && item.quality < 50) {
                    item.quality++
                }
            }
            "Backstage passes to a TAFKAL80ETC concert" -> {
                if (item.quality < 50) {
                    item.quality++

                    if (item.sellIn < 11 && item.quality < 50) {
                        item.quality++
                    }

                    if (item.sellIn < 6 && item.quality < 50) {
                        item.quality++
                    }
                }

                item.sellIn--

                if (item.sellIn < 0) {
                    item.quality = 0
                }
            }
            "Sulfuras, Hand of Ragnaros" -> {
            }
            else -> {
                if (item.quality > 0) {
                    item.quality--
                }
                item.sellIn--

                if (item.sellIn < 0 && item.quality > 0) {
                    item.quality--
                }
            }
        }
    }
}
