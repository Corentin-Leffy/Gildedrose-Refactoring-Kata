package com.gildedrose

class Conjured(name: String, sellIn: Int, quality: Int) : Item(name, sellIn, quality) {
    override fun updateQuality() {
        super.updateQuality()
        decreaseQuality()
    }
}