package kr.co.sleeptimegrt.nbread.data.mapper

import kr.co.sleeptimegrt.nbread.data.model.ItemModel
import kr.co.sleeptimegrt.nbread.domain.entity.Item

/**
 * Created by minchulkim on 2018-03-04.
 */
object ItemMapper {
    fun transform(itemModel: ItemModel): Item {
        return Item(itemModel.partySeq, itemModel.seq, itemModel.name, itemModel.receipt, itemModel.charge)
    }

    fun transform(itemModels: List<ItemModel>): List<Item> {
        return itemModels.map { transform(it) }
    }
}