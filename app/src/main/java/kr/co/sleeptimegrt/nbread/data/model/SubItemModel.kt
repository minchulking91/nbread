package kr.co.sleeptimegrt.nbread.data.model

import android.arch.persistence.room.Entity
import android.arch.persistence.room.ForeignKey
import android.arch.persistence.room.ForeignKey.CASCADE
import android.arch.persistence.room.Index
import android.arch.persistence.room.PrimaryKey
import com.google.gson.annotations.SerializedName

/**
 * Created by minchulkim on 2018-03-04.
 */
@Entity(tableName = "subitems",
        foreignKeys = [ForeignKey(entity = ItemModel::class, parentColumns = ["seq"], childColumns = ["itemSeq"], onDelete = CASCADE),
            ForeignKey(entity = MemberModel::class, parentColumns = ["seq"], childColumns = ["memberSeq"], onDelete = CASCADE)],
        indices = [Index("itemSeq", "memberSeq"), Index("memberSeq")])
data class SubItemModel(
        @PrimaryKey(autoGenerate = true)
        @SerializedName("seq")
        val seq: Int,
        @SerializedName("item_seq")
        val itemSeq: Int,
        @SerializedName("charge")
        val charge: Float,
        @SerializedName("member_seq")
        val memberSeq: Int)