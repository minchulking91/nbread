package kr.co.sleeptimegrt.easydutch.domain.entity

/**
 * Created by minchulkim on 2018-03-04.
 */
data class Item(val partySeq:Int,
                val seq:Int,
                val subject:String,
                val receipt:String? = null,
                val charge:Float) {
}