package kr.co.sleeptimegrt.easydutch.data.repository

import io.reactivex.Single
import kr.co.sleeptimegrt.easydutch.domain.AppExecutors
import kr.co.sleeptimegrt.easydutch.domain.entity.Party

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

        return Single.error(NotImplementedError())
    }


}