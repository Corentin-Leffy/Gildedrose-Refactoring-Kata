package com.gildedrose

class BackstagePasses(name: String, sellIn: Int, quality: Int) : Item(name, sellIn, quality) {
    override fun updateQuality() {
        incrementQuality()
        if (sellIn < 11 && quality < 50) {
            quality++
        }
        if (sellIn < 6 && quality < 50) {
            quality++
        }
        decrementSellIn()

        if (sellIn < 0) {
            quality = 0
        }
    }
}