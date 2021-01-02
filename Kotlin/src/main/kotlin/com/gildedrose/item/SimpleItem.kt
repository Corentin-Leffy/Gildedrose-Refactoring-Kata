package com.gildedrose.item

import com.gildedrose.Item

data class SimpleItem(
    override var name: String,
    override var sellIn: Int,
    override var quality: Int,
) : Item()
