package kr.co.sleeptimegrt.nbread.data.mapper

import kr.co.sleeptimegrt.nbread.data.model.SubItemModel
import kr.co.sleeptimegrt.nbread.domain.entity.SubItem

/**
 * Created by minchulkim on 2018-03-04.
 */
object SubItemMapper {
    fun transform(subItemModel: SubItemModel): SubItem {
        return SubItem(subItemModel.seq, subItemModel.itemSeq, subItemModel.charge, subItemModel.memberSeq)
    }

    fun transform(subItemModels: List<SubItemModel>): List<SubItem> {
        return subItemModels.map { transform(it) }
    }
}