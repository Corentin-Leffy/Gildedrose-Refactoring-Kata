package com.gildedrose.item

import com.gildedrose.Quality
import org.junit.jupiter.api.Test

class SimpleItemTest {

    @Test
    fun `Decrease quality by one`() {
        aSimpleItem(withSellIn = 10, withQuality = 10)
            .afterUpdate()
            .mustBeEqualsTo(aSimpleItem(withSellIn = 9, withQuality = 9))
    }

    @Test
    fun `Decrease quality twice as fast when has expired`() {
        aSimpleItem(withSellIn = 0, withQuality = 10)
            .afterUpdate()
            .mustBeEqualsTo(aSimpleItem(withSellIn = -1, withQuality = 8))
    }

    @Test
    fun `Quality cannot go below a threshold`() {
        aSimpleItem(withSellIn = 10, withQuality = Quality.MINIMUM)
            .afterUpdate()
            .mustBeEqualsTo(aSimpleItem(withSellIn = 9, withQuality = Quality.MINIMUM))
    }

    private fun aSimpleItem(withSellIn: Int, withQuality: Int) =
        SimpleItem("", withSellIn, withQuality)
}