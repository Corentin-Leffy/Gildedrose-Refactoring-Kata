package com.gildedrose

class BackstagePasses(name: String, sellIn: Int, quality: Int) : Item(name, sellIn, quality) {

    override fun updateQuality() {
        increaseQuality()
        decreaseSellIn()
        if (hasExpired) {
            dropQualityToMinimum()
        }
    }

    override fun increaseQuality() {
        repeat(qualityBonus()) { super.increaseQuality() }
    }

    private fun qualityBonus() = when {
        expireInLessThan(5) -> 3
        expireInLessThan(10) -> 2
        else -> 1
    }

    private fun expireInLessThan(days: Int) = sellIn <= days

    private fun dropQualityToMinimum() {
        quality = Quality.MINIMUM
    }
}