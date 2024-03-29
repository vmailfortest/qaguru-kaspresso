package qa.guru.kaspresso

import android.Manifest
import androidx.test.ext.junit.rules.activityScenarioRule
import androidx.test.rule.GrantPermissionRule
import com.kaspersky.components.alluresupport.withForcedAllureSupport
import com.kaspersky.kaspresso.kaspresso.Kaspresso
import com.kaspersky.kaspresso.testcases.api.testcase.TestCase
import org.junit.Rule
import org.junit.Test

class DecrementButtonTest : TestCase(
    kaspressoBuilder = Kaspresso.Builder.withForcedAllureSupport()
) {

    @get:Rule
    val activityRule = activityScenarioRule<MainActivity>()

    @get:Rule
    val runtimePermission: GrantPermissionRule = GrantPermissionRule.grant(
        Manifest.permission.READ_EXTERNAL_STORAGE,
        Manifest.permission.WRITE_EXTERNAL_STORAGE
    )

    @Test
    fun incrementButtonShouldIncreaseCounterValue() = run {

        step("Decrease counter value to 2"){
            MainScreen {
                decrementButton.click()
                decrementButton.click()
            }
        }

        step("Counter value should be -2"){
            MainScreen {
                counterText.hasText("Count: -2")
            }
        }

    }
}