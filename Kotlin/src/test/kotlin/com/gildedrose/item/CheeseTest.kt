package com.gildedrose.item

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class CheeseTest {

    @Test
    internal fun `Increases its quality the more time passes`() {
        aCheese(withSellIn = 2, withQuality = 0)
            .afterUpdate()
            .mustBeEqualsTo(aCheese(withSellIn = 1, withQuality = 1))
    }

    @Test
    internal fun `Increases its quality twice when has expired`() {
        aCheese(withSellIn = 0, withQuality = 2)
            .afterUpdate()
            .mustBeEqualsTo(aCheese(withSellIn = -1, withQuality = 4))
    }

    private fun aCheese(withSellIn: Int, withQuality: Int): Cheese =
        Cheese("", withSellIn, withQuality)

    private fun Cheese.afterUpdate() = apply { updateQuality() }

    private fun Cheese.mustBeEqualsTo(expectedCheese: Cheese) =
        assertEquals(expectedCheese, this)
}