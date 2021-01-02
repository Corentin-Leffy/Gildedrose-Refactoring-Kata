package com.gildedrose.item

import com.gildedrose.Item

data class Conjured(
    override var name: String,
    override var sellIn: Int,
    override var quality: Int,
) : Item() {

    override fun updateQuality() {
        super.updateQuality()
        decreaseQuality()
    }
}