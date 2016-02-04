package ToolsPro.commands;

import ToolsPro.ToolsPro;
import ToolsPro.util.Message;
import cn.nukkit.Player;
import cn.nukkit.command.CommandSender;

/**
 * Created by Pub4Game on 19.12.2015.
 */
public class HealthCommand extends ToolsProCommand {

    private ToolsPro plugin;

    public HealthCommand(ToolsPro plugin) {
        super("health", Message.CMD_HEALTH_DESCRIPTION, Message.CMD_HEALTH_DESCRIPTION2.toString());
        this.setPermission("toolspro.commands.health");
        this.plugin = plugin;
    }

    public boolean execute(CommandSender sender, String commandLabel, String[] args) {
        if (!sender.hasPermission(this.getPermission())) {
            sender.sendMessage(Message.YOU_DONT_HAVE_PERMISSION.getText('c'));
        } else {
            if (args.length != 0) {
                if (sender.hasPermission("toolspro.health.other")) {
                    Player p = this.plugin.getServer().getPlayer(args[0]);
                    if (p != null) {
                        if (p.getGamemode() != 0) {
                            Message.PLAYER_NOT_SURVIVAL.print(sender, "prefix:&7[&aHealth&7]", 'c', 'b', p.getName());
                        } else {
                            if (p.getHealth() != 20) {
                                p.setHealth(20);
                                Message.CMD_HEALTH_PLAYER.print(sender, "prefix:&7[&aHealth&7]", 'a', 'b', p.getName());
                                Message.CMD_HEALTH_PLAYER_MESSAGE.print(p, "prefix:&7[&aHealth&7]", 'a');
                                this.plugin.info(sender, Message.CMD_HEALTH_PLAYER_INFO.getText("prefix:&7[Health]", '7', '7', sender.getName(), p.getName()));
                            } else {
                                Message.CMD_HEALTH_PLAYER_MAX.print(sender, "prefix:&7[&aHealth&7]", 'a', 'b', p.getName());
                            }
                        }
                    } else {
                       Message.UNKNOWN_PLAYER.print(sender, "prefix:&7[&aHealth&7]", 'c');
                    }
                } else {
                    sender.sendMessage(Message.YOU_DONT_HAVE_PERMISSION.getText('c'));
                }
            } else {
                if (sender instanceof Player) {
                    if (((Player) sender).getGamemode() != 0) {
                        Message.YOU_NOT_SURVIVAL.print(sender, "prefix:&7[&aHealth&7]", 'c');
                    } else if (((Player) sender).getHealth() != 20) {
                        ((Player) sender).setHealth(20);
                        Message.CMD_HEALTH_SENDER.print(sender, "prefix:&7[&aHealth&7]", 'a');
                        this.plugin.info(sender, Message.CMD_HEALTH_SENDER_INFO.getText("prefix:&7[Health]", '7', '7', sender.getName()));
                    } else {
                        Message.CMD_HEALTH_SENDER_MAX.print(sender, "prefix:&7[&aHealth&7]", 'a');
                    }
                } else {
                    return Message.NEED_PLAYER.print(sender, "prefix:&7[&aHealth&7]", 'c');
                }
            }
        }
        return true;
    }
}