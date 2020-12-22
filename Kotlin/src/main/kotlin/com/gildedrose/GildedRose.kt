package com.gildedrose

class GildedRose(private val items: Array<Item>) {

    fun incrementQuality() {
        for (item in items) {
            item.updateQuality()
        }
    }
}
