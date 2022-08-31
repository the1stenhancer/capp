package com.the1stenhancer.capp.utility


/**
 * This class represents each property-value pair in a Country object at a particular time,
 * this makes it easier to display them in the CountryDetailScreen composable under basic information.
 * @param key This represents a particular property of a Country object e.g Name
 * @param value This represents the actual value of a particular property of a Country object e.g The1stEnhancer
 */
class Item<K, out V>(
    val key: K,
    private val value: V
) {

    /**
     * This method returns the value of a particular property for a Country object
     * @param key The property for which you want the value e.g Independent
     * @return value The value of the property e.g true
     */
    fun getValue(key: K): V = value
}