package com.gildedrose.bonus

class QualityBonuses(
    vararg bonus: QualityBonus,
) : List<QualityBonus> by bonus.toList() {

    fun findBonus(predicate: (Int) -> Boolean): Int =
        firstOrNull { (_, days) -> predicate(days) }?.bonus
            ?: DEFAULT_BONUS

    companion object {
        private const val DEFAULT_BONUS = 1
    }
}

data class QualityBonus(val bonus: Int, val days: Int)
