package com.gildedrose.item

import com.gildedrose.Item

data class Cheese(
    override var name: String,
    override var sellIn: Int,
    override var quality: Int,
) : Item() {

    override fun updateQuality() {
        increaseQuality()
        decreaseSellIn()
        if (hasExpired) {
            increaseQuality()
        }
    }
}