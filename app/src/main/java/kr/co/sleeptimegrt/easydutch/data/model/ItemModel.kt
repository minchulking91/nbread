package kr.co.sleeptimegrt.easydutch.data.model

import android.arch.persistence.room.Entity
import android.arch.persistence.room.ForeignKey
import android.arch.persistence.room.Index
import android.arch.persistence.room.PrimaryKey
import com.google.gson.annotations.SerializedName

/**
 * Created by minchulkim on 2018-03-04.
 */
@Entity(tableName = "items", foreignKeys = [(ForeignKey(entity = PartyModel::class, parentColumns = ["seq"], childColumns = ["partySeq"], onDelete = ForeignKey.CASCADE))],
        indices = [(Index("partySeq"))])
data class ItemModel(

        @SerializedName("seq")
        @PrimaryKey(autoGenerate = true)
        var seq: Int,

        @SerializedName("party_seq")
        val partySeq: Int,

        @SerializedName("name")
        val name: String,
        @SerializedName("receipt")
        val receipt: String? = null,
        @SerializedName("charge")
        val charge: Float)