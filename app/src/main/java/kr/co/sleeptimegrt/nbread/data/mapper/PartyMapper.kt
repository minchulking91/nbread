package kr.co.sleeptimegrt.nbread.data.mapper

import kr.co.sleeptimegrt.nbread.data.model.PartyModel
import kr.co.sleeptimegrt.nbread.domain.entity.Party

/**
 * Created by minchulkim on 2018-03-04.
 */
object PartyMapper {
    fun transform(partyModel: PartyModel): Party {
        return Party(partyModel.seq, partyModel.partyName)
    }

    fun transform(partyModels: List<PartyModel>): List<Party> {
        return partyModels.map { transform(it) }
    }
}