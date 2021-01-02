package com.gildedrose.item

import org.junit.jupiter.api.Test

class LegendaryTest {

    @Test
    internal fun `Nothing is happening after an update`() {
        aLegendary(withSellIn = 100, withQuality = 100)
            .afterUpdate()
            .mustBeEqualsTo(aLegendary(withSellIn = 100, withQuality = 100))
    }

    private fun aLegendary(withSellIn: Int, withQuality: Int): Legendary =
        Legendary("", withSellIn, withQuality)
}
