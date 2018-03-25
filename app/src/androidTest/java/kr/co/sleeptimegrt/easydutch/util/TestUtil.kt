package kr.co.sleeptimegrt.easydutch.util

import kr.co.sleeptimegrt.easydutch.domain.entity.Party
import org.joda.time.DateTime

/**
 * Created by minchulkim on 2018-03-04.
 */
object TestUtil {
    fun newParty(): Party {
        return Party(createdAt = DateTime.now())
    }
//
//    fun createMembers(partySeq:Int, memberNames: List<String>):List<MemberModel> {
//        return memberNames.map { MemberModel(name = it, partySeq = partySeq) }
//    }

}