package com.gildedrose.item

import org.junit.jupiter.api.Test

class ConjuredTest {

    @Test
    fun `Decrease quality twice as fast`() {
        aConjured(withSellIn = 10, withQuality = 10)
            .afterUpdate()
            .mustBeEqualsTo(aConjured(withSellIn = 9, withQuality = 8))
    }

    private fun aConjured(withSellIn: Int, withQuality: Int) =
        Conjured("", withSellIn, withQuality)
}