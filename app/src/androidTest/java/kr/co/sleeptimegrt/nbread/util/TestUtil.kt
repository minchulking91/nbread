package kr.co.sleeptimegrt.nbread.util

import kr.co.sleeptimegrt.nbread.data.model.MemberModel
import kr.co.sleeptimegrt.nbread.data.model.PartyModel

/**
 * Created by minchulkim on 2018-03-04.
 */
object TestUtil {
    fun createParty(partyName: String): PartyModel {
        return PartyModel(partyName = partyName)
    }

    fun createMembers(partySeq:Int, memberNames: List<String>):List<MemberModel> {
        return memberNames.map { MemberModel(name = it, partySeq = partySeq) }
    }

}