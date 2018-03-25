package kr.co.sleeptimegrt.easydutch.domain.entity

import android.net.Uri

/**
 * Created by minchulkim on 2018-03-04.
 */
data class Item(
        var name: String = "",
        var receipt: Uri? = null,
        var charge: Float? = null,
        val chargePaid: MutableMap<String, Float?> = mutableMapOf()
) {
}