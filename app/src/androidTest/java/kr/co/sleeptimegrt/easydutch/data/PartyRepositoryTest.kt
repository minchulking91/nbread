package kr.co.sleeptimegrt.easydutch.data

import android.support.test.runner.AndroidJUnit4
import kr.co.sleeptimegrt.easydutch.data.db.DbTest
import kr.co.sleeptimegrt.easydutch.data.repository.PartyRepository
import kr.co.sleeptimegrt.easydutch.domain.AppExecutors
import kr.co.sleeptimegrt.easydutch.domain.Status
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
        val partyRepository = PartyRepository(executors)
        val newParty = partyRepository.createParty("TestParty", emptyList()).blockingGet()
        val partyData = newParty.data
        assert(newParty.status == Status.SUCCESS)
        assert(partyData != null)
        assert(partyData?.name == "TestParty")
    }
}