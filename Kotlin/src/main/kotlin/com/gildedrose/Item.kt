package com.gildedrose

abstract class Item {
    abstract var name: String
    abstract var sellIn: Int
    abstract var quality: Int

    protected val hasExpired: Boolean
        get() = sellIn < 0

    open fun updateQuality() {
        decreaseQuality()
        decreaseSellIn()
        if (hasExpired) {
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
}