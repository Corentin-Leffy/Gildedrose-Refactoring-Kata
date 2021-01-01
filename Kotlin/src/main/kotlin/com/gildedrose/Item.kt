package com.gildedrose

open class Item(var name: String, var sellIn: Int, var quality: Int) {

    protected val hasExpired: Boolean
        get() = sellIn < 0

    open fun updateQuality() {
        decreaseQuality()
        decreaseSellIn()

        if (sellIn < Quality.MINIMUM) {
            decreaseQuality()
        }
    }

    protected open fun increaseQuality() {
        if (quality < Quality.MAXIMUM) {
            quality++
        }
    }

    protected fun decreaseQuality() {
        if (quality > Quality.MINIMUM) {
            quality--
        }
    }

    protected fun decreaseSellIn() {
        sellIn--
    }

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
}
