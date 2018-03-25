package kr.co.sleeptimegrt.easydutch.domain.repository

import io.reactivex.Single
import kr.co.sleeptimegrt.easydutch.domain.Resource
import kr.co.sleeptimegrt.easydutch.domain.entity.Item
import kr.co.sleeptimegrt.easydutch.domain.entity.Member
import kr.co.sleeptimegrt.easydutch.domain.entity.Party
import kr.co.sleeptimegrt.easydutch.domain.entity.SubItem

/**
 * Created by minchulkim on 2018-03-04.
 */
interface PartyRepository {
    fun createParty(partyName:String, members:List<Member> = emptyList()): Single<Resource<Party>>

    fun addItem(itemName:String, charge:Float, description:String? = null) :Single<Resource<Item>>

    fun addMember(memberName:String, contact:String? = null):Single<Resource<Member>>

    fun assignChargeWithEquality(members:List<Member>, item:Item):Single<Resource<List<SubItem>>>

    fun assignCharge(members:List<Member>, item:Item, charge:Float):Single<Resource<List<SubItem>>>

    fun clearAssign(item:Item):Single<Resource<List<SubItem>>>

}