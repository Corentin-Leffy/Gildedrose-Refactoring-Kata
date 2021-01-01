package com.gildedrose

class Cheese(name: String, sellIn: Int, quality: Int) : Item(name, sellIn, quality) {

    override fun updateQuality() {
        increaseQuality()
        decreaseSellIn()
        if (hasExpired) {
            increaseQuality()
        }
    }
}