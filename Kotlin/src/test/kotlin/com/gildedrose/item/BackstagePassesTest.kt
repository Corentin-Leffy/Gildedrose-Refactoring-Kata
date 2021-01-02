package com.gildedrose.item

import org.junit.jupiter.api.Test

class BackstagePassesTest {

    @Test
    fun `Increase its quality by 1 when sell in is before 10 days`() {
        aBackstagePasses(withSellIn = 11, withQuality = 0)
            .afterUpdate()
            .mustBeEqualsTo(aBackstagePasses(withSellIn = 10, withQuality = 1))
    }

    @Test
    fun `Increase its quality by 2 when sell in is between 5 and 10 days`() {
        aBackstagePasses(withSellIn = 8, withQuality = 0)
            .afterUpdate()
            .mustBeEqualsTo(aBackstagePasses(withSellIn = 7, withQuality = 2))
    }

    @Test
    fun `Increase its quality by 3 when sell in is between 0 and 5`() {
        aBackstagePasses(withSellIn = 4, withQuality = 0)
            .afterUpdate()
            .mustBeEqualsTo(aBackstagePasses(withSellIn = 3, withQuality = 3))
    }

    @Test
    fun `Drop its quality to minimum when has expired`() {
        aBackstagePasses(withSellIn = 0, withQuality = 10)
            .afterUpdate()
            .mustBeEqualsTo(aBackstagePasses(withSellIn = -1, withQuality = 0))
    }

    private fun aBackstagePasses(withSellIn: Int, withQuality: Int): BackstagePasses =
        BackstagePasses("", withSellIn, withQuality)
}