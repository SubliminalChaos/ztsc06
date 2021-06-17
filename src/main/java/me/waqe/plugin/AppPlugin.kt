package me.waqe.plugin

import me.waqe.plugin.events.EventsClass
import org.bukkit.ChatColor
import org.bukkit.event.Listener
import org.bukkit.plugin.java.JavaPlugin
import java.util.*


class App : JavaPlugin(), Listener {
    companion object {
        lateinit var instance: App
    }

    override fun onEnable() {
        server.consoleSender.sendMessage("${ChatColor.GREEN}Tutorial has been Enabled")
        server.pluginManager.registerEvents(EventsClass(), this)
        loadConfig()
    }

    override fun onDisable() {
        server.consoleSender.sendMessage("${ChatColor.RED}Tutorial has been Disabled")
    }

    fun loadConfig() {
        config.options().copyDefaults(true)
        saveConfig()
    }
}
