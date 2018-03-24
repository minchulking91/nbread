package kr.co.sleeptimegrt.nbread.data

import android.support.test.runner.AndroidJUnit4
import kr.co.sleeptimegrt.nbread.data.db.DbTest
import kr.co.sleeptimegrt.nbread.data.repository.PartyDataRepository
import kr.co.sleeptimegrt.nbread.domain.AppExecutors
import kr.co.sleeptimegrt.nbread.domain.Status
import org.junit.Test
import org.junit.runner.RunWith
import java.util.concurrent.Executors

/**
 * Created by minchulkim on 2018-03-10.
 */
@RunWith(AndroidJUnit4::class)
class PartyRepositoryTest : DbTest() {

    @Test
    fun createParty() {
        val executors = AppExecutors(Executors.newSingleThreadExecutor(), Executors.newFixedThreadPool(3), AppExecutors.MainThreadExecutor())
        val partyRepository = PartyDataRepository(executors, db, db.partyDao(), db.memberDao(), db.itemDao(), db.subItemDao())
        val newParty = partyRepository.createParty("TestParty", emptyList()).blockingGet()
        val partyData = newParty.data
        assert(newParty.status == Status.SUCCESS)
        assert(partyData != null)
        assert(partyData?.name == "TestParty")
    }
}