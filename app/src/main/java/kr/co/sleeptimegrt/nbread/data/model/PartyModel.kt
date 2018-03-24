package kr.co.sleeptimegrt.nbread.data.model

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import com.google.gson.annotations.SerializedName

/**
 * Created by minchulkim on 2018-03-04.
 */
@Entity(tableName = "parties")
data class PartyModel(
        @PrimaryKey(autoGenerate = true)
        @SerializedName("seq")
        var seq:Int = 0,
        @SerializedName("name")
        val partyName:String)