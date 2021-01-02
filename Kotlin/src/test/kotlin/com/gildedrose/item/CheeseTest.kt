package com.gildedrose.item

import com.gildedrose.Quality
import org.junit.jupiter.api.Test

class CheeseTest {

    @Test
    fun `Increases its quality the more time passes`() {
        aCheese(withSellIn = 2, withQuality = 0)
            .afterUpdate()
            .mustBeEqualsTo(aCheese(withSellIn = 1, withQuality = 1))
    }

    @Test
    fun `Increases its quality twice when has expired`() {
        aCheese(withSellIn = 0, withQuality = 2)
            .afterUpdate()
            .mustBeEqualsTo(aCheese(withSellIn = -1, withQuality = 4))
    }

    @Test
    fun `Quality cannot exceed a ceiling`() {
        aCheese(withSellIn = 1, withQuality = Quality.MAXIMUM)
            .afterUpdate()
            .mustBeEqualsTo(aCheese(withSellIn = 0, withQuality = Quality.MAXIMUM))
    }

    private fun aCheese(withSellIn: Int, withQuality: Int): Cheese =
        Cheese("", withSellIn, withQuality)

}
