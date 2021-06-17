package me.waqe.plugin.events

import me.waqe.plugin.App
import net.md_5.bungee.api.ChatColor
import org.bukkit.Material
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.block.BlockPlaceEvent

class EventsClass : Listener {
    private val plugin = App.instance
    private var count = 0

    @EventHandler
    fun onPlace(event: BlockPlaceEvent) {
        val block = event.block
        val player = event.player
        val bLoc = block.location
        player.sendMessage(ChatColor.RED.toString() + "Placing TNT has added you to out logs!")
        if (block.type == Material.TNT) {
            plugin.config.set(
                "Users." + player.uniqueId + ".Block_" + count + ".World",
                bLoc.world!!.name
            )
            plugin.config.set("Users." + player.uniqueId + ".Block_" + count + ".X", bLoc.blockX)
            plugin.config.set("Users." + player.uniqueId + ".Block_" + count + ".Y", bLoc.blockY)
            plugin.config.set("Users." + player.uniqueId + ".Block_" + count + ".Z", bLoc.blockZ)
            plugin.saveConfig()
            count++
        }
    }
}
