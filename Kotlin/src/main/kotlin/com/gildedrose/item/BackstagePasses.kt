package com.gildedrose.item

import com.gildedrose.Item
import com.gildedrose.Quality
import com.gildedrose.bonus.QualityBonus
import com.gildedrose.bonus.QualityBonuses

data class BackstagePasses(
    override var name: String,
    override var sellIn: Int,
    override var quality: Int,
) : Item() {

    private val qualityBonuses = QualityBonuses(
        QualityBonus(bonus = 3, days = 5),
        QualityBonus(bonus = 2, days = 10),
    )

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

    private fun qualityBonus() = qualityBonuses.findBonus { days -> sellIn <= days }

    private fun dropQualityToMinimum() {
        quality = Quality.MINIMUM
    }
}
