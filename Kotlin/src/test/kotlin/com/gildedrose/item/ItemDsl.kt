package com.gildedrose.item

import com.gildedrose.Item
import org.junit.jupiter.api.Assertions

fun Item.afterUpdate() = apply { updateQuality() }

fun Item.mustBeEqualsTo(expectedItem: Item) =
    Assertions.assertEquals(expectedItem, this)
