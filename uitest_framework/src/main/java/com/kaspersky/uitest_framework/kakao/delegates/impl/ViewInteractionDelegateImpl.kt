package com.kaspersky.uitest_framework.kakao.delegates.impl

import android.support.test.espresso.*
import android.view.View
import com.kaspersky.uitest_framework.kakao.delegates.ViewInteractionDelegate
import org.hamcrest.Matcher

class ViewInteractionDelegateImpl internal constructor(
        override val viewInteraction: ViewInteraction
): ViewInteractionDelegate {

    override fun perform(viewAction: ViewAction): ViewInteractionDelegate {
        viewInteraction.perform(viewAction)
        return this
    }

    override fun check(viewAssertion: ViewAssertion): ViewInteractionDelegate {
        viewInteraction.check(viewAssertion)
        return this
    }

    override fun check(
            function: (View, NoMatchingViewException) -> Unit
    ): ViewInteractionDelegate {
        viewInteraction.check(function)
        return this
    }

    override fun withFailureHandler(
            function: (Throwable, Matcher<View>) -> Unit
    ): ViewInteractionDelegate {
        viewInteraction.withFailureHandler(function)
        return this
    }

    override fun inRoot(rootMatcher: Matcher<Root>): ViewInteractionDelegate {
        viewInteraction.inRoot(rootMatcher)
        return this
    }
}