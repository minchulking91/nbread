package kr.co.sleeptimegrt.easydutch.data.repository

import io.reactivex.Single
import kr.co.sleeptimegrt.easydutch.domain.AppExecutors
import kr.co.sleeptimegrt.easydutch.domain.entity.Item
import kr.co.sleeptimegrt.easydutch.domain.entity.Member
import kr.co.sleeptimegrt.easydutch.domain.entity.Party
import kr.co.sleeptimegrt.easydutch.domain.exception.OverPaidException
import org.joda.time.DateTime
import org.joda.time.LocalDate

/**
 * Created by minchulkim on 2018-03-04.
 */

class PartyRepository {


    private var _appExecutors: AppExecutors

    constructor(appExecutors: AppExecutors) {

        this._appExecutors = appExecutors
    }

    /*
    usecase
     */

    fun createParty(): Single<Party> {
        val party = Party(createdAt = DateTime.now())
        return Single.just(party)
    }

    /**
     * [party]
     * [_name] ignore if null
     * [_partyAt] ignore if null
     */
    fun setParty(party: Party, _name: String? = null, _partyAt: LocalDate? = null): Single<Party> {
        _name?.let {
            party.name = it
        }
        _partyAt?.let {
            party.partyAt = it
        }
        return Single.just(party)
    }

    fun newItem(party: Party): Single<Item> {
        val item = Item()
        party.items.add(item)
        return Single.just(item)
    }

    /**
     * [item]
     * [_name] ignore if null
     * [_members] ignore if null
     * [_charge] ignore if null
     */
    fun setItem(item: Item, _name: String? = null, _members: List<Member>? = null, _charge: Float? = null): Single<Item> {
        _name?.let {
            item.name = it
        }
        _members?.let {
            val newMemberNameSet = it.map { it.name }.toSet()
            item.chargePaid.keys.toSet().forEach {
                if (!newMemberNameSet.contains(it)) {
                    item.chargePaid.remove(it)
                }
            }
            newMemberNameSet.forEach {
                if (!item.chargePaid.containsKey(it)) {
                    item.chargePaid[it] = null
                }
            }
        }
        _charge?.let {
            val assignedPriceList = item.chargePaid.values.filterNotNull()
            val assignedPrice = if (assignedPriceList.isEmpty()) 0f else assignedPriceList.reduce { acc, fl -> acc + fl }
            if (assignedPrice < it) {
                return Single.error(OverPaidException("assignedPrice is $assignedPrice. but new charge is $it. new charge have to bigger then assignedPrice"))
            }
            item.charge = it
        }
        return Single.just(item)
    }

}