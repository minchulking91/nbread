package kr.co.sleeptimegrt.easydutch.data.db

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import kr.co.sleeptimegrt.easydutch.data.dao.ItemDao
import kr.co.sleeptimegrt.easydutch.data.dao.MemberDao
import kr.co.sleeptimegrt.easydutch.data.dao.PartyDao
import kr.co.sleeptimegrt.easydutch.data.dao.SubItemDao
import kr.co.sleeptimegrt.easydutch.data.model.ItemModel
import kr.co.sleeptimegrt.easydutch.data.model.MemberModel
import kr.co.sleeptimegrt.easydutch.data.model.PartyModel
import kr.co.sleeptimegrt.easydutch.data.model.SubItemModel

/**
 * Created by minchulkim on 2018-03-04.
 */
@Database(entities = [PartyModel::class, MemberModel::class, ItemModel::class, SubItemModel::class], version = 1, exportSchema = false)
abstract class NBreadDatabase : RoomDatabase() {
    abstract fun partyDao(): PartyDao
    abstract fun itemDao(): ItemDao
    abstract fun memberDao(): MemberDao
    abstract fun subItemDao(): SubItemDao
}