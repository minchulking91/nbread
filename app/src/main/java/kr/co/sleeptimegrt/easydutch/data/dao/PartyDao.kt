package kr.co.sleeptimegrt.easydutch.data.dao

import android.arch.lifecycle.LiveData
import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Query
import kr.co.sleeptimegrt.easydutch.data.model.PartyModel

/**
 * Created by minchulkim on 2018-03-04.
 */
@Dao
interface PartyDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertParty(party: PartyModel): Long

    @Query("SELECT * FROM parties")
    fun loadAll(): LiveData<List<PartyModel>>

    @Query("SELECT * FROM parties WHERE seq = :seq LIMIT 1")
    fun loadBySeq(seq: Long): LiveData<PartyModel>

}