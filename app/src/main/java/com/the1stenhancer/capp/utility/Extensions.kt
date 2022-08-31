package com.the1stenhancer.capp.utility


/**
 * Extension function on the Country class. Gets the given Country and returns a list of Item<Key, value>.
 */
fun Country.createDetailItems(): List<Item<String, Any?>> {
    return listOf(
        Item("Name:", this.name.common),
        Item("Code (cca3):", this.cca3),
        Item("Subregion:", this.subRegion),
        Item("Independent:", this.independent)
    )
}
