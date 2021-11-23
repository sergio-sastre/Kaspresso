package com.kaspersky.kaspresso.autoscroll

import androidx.test.espresso.ViewInteraction
import com.kaspersky.kaspresso.internal.extensions.other.isAllowed
import com.kaspersky.kaspresso.logger.UiTestLogger
import com.kaspersky.kaspresso.params.AutoScrollParams
import com.kaspersky.kaspresso.interceptors.behavior.impl.autoscroll.FallbackAutoScrollToAction


class AutoScrollFallbackProviderImpl(
    private val params: AutoScrollParams,
    private val logger: UiTestLogger
) : AutoScrollProvider<ViewInteraction> {

    /**
     * Invokes the given [action] and calls [scroll] if it fails. Helps in cases when autoscroll has already failed because of
     * the scrollable container having paddings that autoscroll cannot successfully solve
     *
     * @param interaction the instance of [ViewInteraction] interface to perform actions and assertions.
     * @param action the actual action on the interacted view.
     *
     * @throws Throwable if the exception caught while invoking [action] is not allowed via [params].
     * @return the result of [action] invocation.
     */
    @Throws(Throwable::class)
    override fun <T> withAutoScroll(interaction: ViewInteraction, action: () -> T): T {
        return try {
            action.invoke()
        } catch (error: Throwable) {
            if (error.isAllowed(params.allowedExceptions)) {
                return scroll(interaction, action, error)
            }
            throw error
        }
    }

    /**
     * Performs the autoscrolling functionality. Performs scroll and re-invokes the given [action].
     *
     * @param interaction the instance of [ViewInteraction] interface to perform actions and assertions.
     * @param action the actual action on the interacted view.
     * @param cachedError the error to be thrown if autoscroll would not help.
     *
     * @throws cachedError if autoscroll action did not help.
     * @return the result of [action] invocation.
     */
    @Throws(Throwable::class)
    override fun <T> scroll(interaction: ViewInteraction, action: () -> T, cachedError: Throwable): T {
        return try {
            interaction.perform(FallbackAutoScrollToAction())
            logger.i("View fallback autoScroll successfully performed.")
            action.invoke()
        } catch (error: Throwable) {
            throw cachedError
        }
    }
}


