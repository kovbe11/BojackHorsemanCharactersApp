package hu.bme.aut.android.bojackhorseman.placeholder

import hu.bme.aut.android.bojackhorseman.model.Character

/**
 * Helper class for providing sample content for user interfaces created by
 * Android template wizards.
 *
 * TODO: Replace all uses of this class before publishing your app.
 */
object PlaceholderContent {

    /**
     * An array of sample (placeholder) items.
     */
    val ITEMS: MutableList<Character> = ArrayList()


    private const val COUNT = 25

    init {
        // Add some sample items.
        for (i in 1..COUNT) {
            addItem(createPlaceholderItem(i))
        }
    }

    private fun addItem(item: Character) {
        ITEMS.add(item)
    }

    private fun createPlaceholderItem(position: Int): Character {
        return Character(position, "Name $position", "Voice actor $position", "Some species")
    }


}