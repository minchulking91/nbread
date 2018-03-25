package kr.co.sleeptimegrt.easydutch.domain.entity

import org.joda.time.DateTime
import org.joda.time.LocalDate

/**
 * Created by minchulkim on 2018-03-04.
 */
data class Party(
        var name: String = "",
        val createdAt: DateTime,
        var partyAt: LocalDate? = null,
        val items: MutableList<Item> = mutableListOf()
)