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
                    item.quality = item.quality + 1
                }

                item.sellIn = item.sellIn - 1

                if (item.sellIn < 0 && item.quality < 50) {
                    item.quality = item.quality + 1
                }
            }
            "Backstage passes to a TAFKAL80ETC concert" -> {
                if (item.quality < 50) {
                    item.quality = item.quality + 1

                    if (item.sellIn < 11 && item.quality < 50) {
                        item.quality = item.quality + 1
                    }

                    if (item.sellIn < 6 && item.quality < 50) {
                        item.quality = item.quality + 1
                    }
                }

                item.sellIn = item.sellIn - 1

                if (item.sellIn < 0) {
                    item.quality = item.quality - item.quality
                }
            }
            "Sulfuras, Hand of Ragnaros" -> {
            }
            else -> {
                if (item.quality > 0) {
                    item.quality = item.quality - 1
                }
                item.sellIn = item.sellIn - 1

                if (item.sellIn < 0 && item.quality > 0) {
                    item.quality = item.quality - 1
                }
            }
        }
    }
}
