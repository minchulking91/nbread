package kr.co.sleeptimegrt.nbread.data.mapper

import kr.co.sleeptimegrt.nbread.data.model.MemberModel
import kr.co.sleeptimegrt.nbread.domain.entity.Member

/**
 * Created by minchulkim on 2018-03-04.
 */
object MemberMapper {
    fun transform(memberModel: MemberModel): Member {
        return Member(memberModel.seq, memberModel.name, memberModel.contact)
    }
    fun transform(memberModels: List<MemberModel>):List<Member>{
        return memberModels.map { transform(it) }
    }
}