package kr.co.sleeptimegrt.nbread.data.model

import android.arch.persistence.room.*
import android.arch.persistence.room.ForeignKey.CASCADE
import com.google.gson.annotations.SerializedName

/**
 * Created by minchulkim on 2018-03-04.
 */
@Entity(tableName = "members", foreignKeys = [ForeignKey(entity = PartyModel::class, parentColumns = ["seq"], childColumns = ["partySeq"], onDelete = CASCADE)],
        indices = [Index("partySeq")])
data class MemberModel(
        @SerializedName("seq")
        @PrimaryKey(autoGenerate = true)
        var seq: Int = 0,
        @SerializedName("name")
        val name: String,
        @SerializedName("contact")
        val contact: String? = null,
        @SerializedName("party_seq")
        val partySeq: Int
)