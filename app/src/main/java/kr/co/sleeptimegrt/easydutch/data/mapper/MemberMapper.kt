package kr.co.sleeptimegrt.easydutch.data.mapper

import kr.co.sleeptimegrt.easydutch.data.model.MemberModel
import kr.co.sleeptimegrt.easydutch.domain.entity.Member

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