package com.gildedrose

data class SimpleItem(
    override var name: String,
    override var sellIn: Int,
    override var quality: Int,
) : Item()
