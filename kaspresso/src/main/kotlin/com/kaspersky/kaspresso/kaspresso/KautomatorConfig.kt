package com.kaspersky.kaspresso.kaspresso

import com.kaspersky.kaspresso.device.Device
import com.kaspersky.kaspresso.device.accessibility.Accessibility
import com.kaspersky.kaspresso.device.activities.Activities
import com.kaspersky.kaspresso.device.apps.Apps
import com.kaspersky.kaspresso.device.exploit.Exploit
import com.kaspersky.kaspresso.device.files.Files
import com.kaspersky.kaspresso.device.keyboard.Keyboard
import com.kaspersky.kaspresso.device.languages.Language
import com.kaspersky.kaspresso.device.location.Location
import com.kaspersky.kaspresso.device.logcat.Logcat
import com.kaspersky.kaspresso.device.network.Network
import com.kaspersky.kaspresso.device.permissions.HackPermissions
import com.kaspersky.kaspresso.device.permissions.Permissions
import com.kaspersky.kaspresso.device.phone.Phone
import com.kaspersky.kaspresso.device.screenshots.Screenshots
import com.kaspersky.kaspresso.device.server.AdbServer
import com.kaspersky.kaspresso.interceptors.behavior.DataBehaviorInterceptor
import com.kaspersky.kaspresso.interceptors.behavior.ViewBehaviorInterceptor
import com.kaspersky.kaspresso.interceptors.behavior.WebBehaviorInterceptor
import com.kaspersky.kaspresso.interceptors.behaviorkautomator.DeviceBehaviorInterceptor
import com.kaspersky.kaspresso.interceptors.behaviorkautomator.ObjectBehaviorInterceptor
import com.kaspersky.kaspresso.logger.UiTestLogger
import com.kaspersky.kaspresso.params.AutoScrollParams
import com.kaspersky.kaspresso.params.FlakySafetyParams

interface KautomatorConfig {

    val canRunOnJvm: Boolean

    fun getDevice(libLogger: UiTestLogger, adbServer: AdbServer, activities: Activities): Device?

    fun getAdbServer(libLogger: UiTestLogger): AdbServer

    fun getPermissions(libLogger: UiTestLogger): Permissions

    fun getNetwork(libLogger: UiTestLogger, adbServer: AdbServer): Network

    fun getApps(libLogger: UiTestLogger, adbServer: AdbServer): Apps

    fun getFiles(adbServer: AdbServer): Files

    fun getActivities(libLogger: UiTestLogger): Activities

    fun getPhone(adbServer: AdbServer): Phone

    fun getLocation(adbServer: AdbServer): Location

    fun getKeyboard(adbServer: AdbServer): Keyboard

    fun getScreenshots(libLogger: UiTestLogger, activities: Activities): Screenshots

    fun getAccessibility(): Accessibility

    fun getHackPermissions(libLogger: UiTestLogger): HackPermissions

    fun getExploit(adbServer: AdbServer, activities: Activities): Exploit

    fun getLanguage(libLogger: UiTestLogger): Language

    fun getLogcat(adbServer: AdbServer): Logcat

    fun getObjectBehaviourInterceptors(
        libLogger: UiTestLogger,
        adbServer: AdbServer,
        autoScrollParams: AutoScrollParams,
        flakySafetyParams: FlakySafetyParams
    ): MutableList<ObjectBehaviorInterceptor>

    fun getDeviceBehaviourInterceptors(
        libLogger: UiTestLogger,
        adbServer: AdbServer,
        flakySafetyParams: FlakySafetyParams
    ): MutableList<DeviceBehaviorInterceptor>

    fun getViewBehaviourInterceptors(
        libLogger: UiTestLogger,
        adbServer: AdbServer,
        autoScrollParams: AutoScrollParams,
        flakySafetyParams: FlakySafetyParams
    ): MutableList<ViewBehaviorInterceptor>

    fun getDataBehaviourInterceptors(
        libLogger: UiTestLogger,
        adbServer: AdbServer,
        autoScrollParams: AutoScrollParams,
        flakySafetyParams: FlakySafetyParams
    ): MutableList<DataBehaviorInterceptor>

    fun getWebBehaviourInterceptors(
        libLogger: UiTestLogger,
        adbServer: AdbServer,
        autoScrollParams: AutoScrollParams,
        flakySafetyParams: FlakySafetyParams
    ): MutableList<WebBehaviorInterceptor>

}