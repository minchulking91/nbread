package kr.co.sleeptimegrt.easydutch.data

import android.support.test.runner.AndroidJUnit4
import kr.co.sleeptimegrt.easydutch.data.db.DbTest
import kr.co.sleeptimegrt.easydutch.data.repository.PartyRepository
import kr.co.sleeptimegrt.easydutch.domain.AppExecutors
import kr.co.sleeptimegrt.easydutch.util.TestUtil
import org.joda.time.LocalDate
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import java.util.concurrent.Executors

/**
 * Created by minchulkim on 2018-03-10.
 */
@RunWith(AndroidJUnit4::class)
class PartyRepositoryTest : DbTest() {

    private lateinit var partyRepository: PartyRepository
    @Before
    fun init() {
        val executors = AppExecutors(Executors.newSingleThreadExecutor(), Executors.newFixedThreadPool(3), AppExecutors.MainThreadExecutor())
        partyRepository = PartyRepository(executors)
    }

    @Test
    fun createParty() {
        val newParty = partyRepository.createParty().blockingGet()
        assert(newParty.createdAt.toLocalDate() === LocalDate.now())
    }

    @Test
    fun setParty() {
        val partyName = "testParty"
        val party = partyRepository.createParty().blockingGet()
        val today = LocalDate.now()
        val resultParty = partyRepository.setParty(party, partyName, today).blockingGet()

        assert(resultParty.createdAt.toLocalDate() === today)
        assert(resultParty.name === partyName)
        assert(resultParty.partyAt === today)
    }

    @Test
    fun newItem() {
        val party = TestUtil.newParty()
        val item = partyRepository.newItem(party).blockingGet()
        assert(party.items.last() === item)
    }

    @Test
    fun setItem() {
        val itemName = "testItem"
        val charge = 1000f
        val party = TestUtil.newParty()
        val item = partyRepository.newItem(party).blockingGet()
        val resultItem = partyRepository.setItem(item, _name = itemName, _members = emptyList(), _charge = charge).blockingGet()
        assert(resultItem.name === itemName)
        assert(resultItem.charge == charge)
    }
}