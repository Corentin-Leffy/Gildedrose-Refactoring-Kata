package com.gildedrose

class GildedRose(private val items: Array<Item>) {

    fun incrementQuality() {
        items.forEach(Item::updateQuality)
    }
}
