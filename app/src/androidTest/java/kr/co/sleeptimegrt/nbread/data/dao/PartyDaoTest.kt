package kr.co.sleeptimegrt.nbread.data.dao

import android.support.test.runner.AndroidJUnit4
import kr.co.sleeptimegrt.nbread.data.db.DbTest
import kr.co.sleeptimegrt.nbread.util.LiveDataTestUtil
import kr.co.sleeptimegrt.nbread.util.TestUtil
import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.CoreMatchers.notNullValue
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Test
import org.junit.runner.RunWith

/**
 * Created by minchulkim on 2018-03-10.
 */
@RunWith(AndroidJUnit4::class)
class PartyDaoTest : DbTest() {

    @Test
    @Throws(Exception::class)
    internal fun insertAndRead() {
        val partyModel = TestUtil.createParty("TestParty")
        val seq = db.partyDao().insertParty(partyModel)
        val loaded = LiveDataTestUtil.getValue(db.partyDao().loadBySeq(seq))
        assertThat(loaded, notNullValue())
        assertThat(loaded.partyName, `is`("TestParty"))
    }
}
