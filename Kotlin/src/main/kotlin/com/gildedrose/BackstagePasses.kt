package com.gildedrose

class BackstagePasses(name: String, sellIn: Int, quality: Int) : Item(name, sellIn, quality) {
    override fun updateQuality() {
        incrementQuality()
        if (sellIn < 11) {
            incrementQuality()
        }
        if (sellIn < 6) {
            incrementQuality()
        }
        decrementSellIn()

        if (sellIn < 0) {
            quality = 0
        }
    }
}