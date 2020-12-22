package com.gildedrose

class BackstagePasses(name: String, sellIn: Int, quality: Int) : Item(name, sellIn, quality) {
    override fun updateQuality() {
        repeat(timesToIncrementQuality()) {
            incrementQuality()
        }

        decrementSellIn()

        if (sellIn < 0) {
            quality = 0
        }
    }

    private fun timesToIncrementQuality() = when {
        sellIn <= 5 -> 3
        sellIn <= 10 -> 2
        else -> 1
    }
}