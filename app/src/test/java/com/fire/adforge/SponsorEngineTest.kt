package com.fire.adforge

import com.fire.adforge.engine.SponsorEngine
import org.junit.Test
import kotlin.test.assertTrue

class SponsorEngineTest {
    @Test
    fun testRegisterAllHandlers() {
        try {
            SponsorEngine.registerAll()
            assertTrue(true, "SponsorEngine.registerAll() executed successfully")
        } catch (e: Exception) {
            assertTrue(false, "SponsorEngine.registerAll() failed with exception: \")
        }
    }
}
