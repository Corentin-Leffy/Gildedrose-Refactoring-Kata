package com.gildedrose

open class Item(var name: String, var sellIn: Int, var quality: Int) {
    override fun toString(): String = "$name, $sellIn, $quality"

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Item

        if (name != other.name) return false
        if (sellIn != other.sellIn) return false
        if (quality != other.quality) return false

        return true
    }

    override fun hashCode(): Int {
        var result = name.hashCode()
        result = 31 * result + sellIn
        result = 31 * result + quality
        return result
    }

    open fun updateQuality() {
        decrementQuality()
        decrementSellIn()

        if (sellIn < QUALITY_MIN_THRESHOLD) {
            decrementQuality()
        }
    }

    protected fun incrementQuality() {
        if (quality < QUALITY_MAX_THRESHOLD) {
            quality++
        }
    }

    protected fun decrementQuality() {
        if (quality > QUALITY_MIN_THRESHOLD) {
            quality--
        }
    }

    protected fun decrementSellIn() {
        sellIn--
    }

    companion object {
        private const val QUALITY_MAX_THRESHOLD = 50
        private const val QUALITY_MIN_THRESHOLD = 0
    }
}

