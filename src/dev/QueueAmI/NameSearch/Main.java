package dev.QueueAmI.NameSearch;

import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin
{
    @Override
    public void onEnable()
    {
    }
   
    @Override
    public void onDisable()
    {
    }

    @Override
    public boolean onCommand(CommandSender sender,
                             Command command,
                             String label,
                             String[] args)
    {
        if (command.getName().equalsIgnoreCase("NameSearch"))
        {
        	if (sender instanceof Player)
        	{
            	Player player = (Player)sender;
            	if (!player.hasPermission("namesearch.namesearch"))
            	{
            		player.sendMessage("You don't have the namesearch.namesearch permission.");
            		return false;
            	}
        	}
        	if (args.length != 1)
        	{
        		sender.sendMessage("You must specify a single string to search for.");
        		return false;
        	}
            sender.sendMessage("Looking Up Names...");
            OfflinePlayer[] allPlayers = Bukkit.getServer().getOfflinePlayers();
            int count = 0;
            for (OfflinePlayer curPlayer : allPlayers)
            {
            	if (curPlayer.getName().toUpperCase().contains(args[0].toUpperCase()))
            	{
            	    sender.sendMessage(curPlayer.getName());
            	    count++;
            	}
            }
            sender.sendMessage("There were " + count + " matches.");
            return true;
        }
        return false;
    }
}
