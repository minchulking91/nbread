package kr.co.sleeptimegrt.easydutch.data.repository

import io.reactivex.Single
import kr.co.sleeptimegrt.easydutch.data.dao.ItemDao
import kr.co.sleeptimegrt.easydutch.data.dao.MemberDao
import kr.co.sleeptimegrt.easydutch.data.dao.PartyDao
import kr.co.sleeptimegrt.easydutch.data.dao.SubItemDao
import kr.co.sleeptimegrt.easydutch.data.db.NBreadDatabase
import kr.co.sleeptimegrt.easydutch.data.model.PartyModel
import kr.co.sleeptimegrt.easydutch.domain.AppExecutors
import kr.co.sleeptimegrt.easydutch.domain.Resource
import kr.co.sleeptimegrt.easydutch.domain.entity.Item
import kr.co.sleeptimegrt.easydutch.domain.entity.Member
import kr.co.sleeptimegrt.easydutch.domain.entity.Party
import kr.co.sleeptimegrt.easydutch.domain.entity.SubItem
import kr.co.sleeptimegrt.easydutch.domain.repository.PartyRepository
import javax.inject.Singleton

/**
 * Created by minchulkim on 2018-03-04.
 */
@Singleton
class PartyDataRepository : PartyRepository {

    private var _db: NBreadDatabase

    private var _appExecutors: AppExecutors

    private var _partyDao: PartyDao

    private var _memberDao: MemberDao

    private var _itemDao: ItemDao

    private var _subItemDao: SubItemDao

    constructor(appExecutors: AppExecutors, db: NBreadDatabase, partyDao: PartyDao, memberDao: MemberDao, itemDao: ItemDao, subItemDao: SubItemDao) {
        this._db = db
        this._partyDao = partyDao
        this._memberDao = memberDao
        this._itemDao = itemDao
        this._subItemDao = subItemDao
        this._appExecutors = appExecutors
    }

    override fun createParty(partyName: String, members: List<Member>): Single<Resource<Party>> {
        try {
            checkNotNull(partyName)
        } catch (e: IllegalStateException) {
            return Single.error(e)
        }
        val partyModel = PartyModel(partyName = partyName)
        val saveRunnable = Runnable { _partyDao.insertParty(partyModel) }
        _appExecutors.diskIO().execute(saveRunnable)
        val seq = _partyDao.insertParty(partyModel)
        _partyDao.loadBySeq(seq)
        return Single.error(NotImplementedError())
    }

    override fun addItem(itemName: String, charge: Float, description: String?): Single<Resource<Item>> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun addMember(memberName: String, contact: String?): Single<Resource<Member>> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun assignChargeWithEquality(members: List<Member>, item: Item): Single<Resource<List<SubItem>>> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templa
        // tes.
    }

    override fun assignCharge(members: List<Member>, item: Item, charge: Float): Single<Resource<List<SubItem>>> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun clearAssign(item: Item): Single<Resource<List<SubItem>>> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}