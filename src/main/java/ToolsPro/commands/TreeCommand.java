package ToolsPro.commands;

import ToolsPro.ToolsPro;
import ToolsPro.util.Message;
import cn.nukkit.Player;
import cn.nukkit.block.Block;
import cn.nukkit.block.BlockSapling;
import cn.nukkit.command.CommandSender;
import cn.nukkit.level.generator.object.tree.ObjectTree;
import cn.nukkit.math.NukkitRandom;

/**
 * Created by Pub4Game on 03.02.2016.
 */

public class TreeCommand extends ToolsProCommand {

    private ToolsPro plugin;

    public TreeCommand(ToolsPro plugin) {
        super("tree", Message.CMD_TOP_DESCRIPTION, "/tree");
        this.setPermission("toolspro.commands.tree");
        this.plugin = plugin;
    }

    public boolean execute(CommandSender sender, String commandLabel, String[] args) {
        if (!sender.hasPermission(this.getPermission())) {
            sender.sendMessage(Message.YOU_DONT_HAVE_PERMISSION.getText('c'));
        } else {
             /*
            if (sender instanceof Player) {
                Block block = ((Player) sender).getTargetBlock(100, this.plugin.NON_SOLID_BLOCKS);
                if (block == null) {
                    Message.IS_NOT_A_REACHABLE_BLOCK.print(sender, "prefix:&7[&aTree&7]", 'c');
                    return false;
                }
                int type;
                switch(args[0]){
                    case "oak":
                    default:
                        type = BlockSapling.OAK;
                        break;
                    case "spruce":
                        type = BlockSapling.SPRUCE;
                        break;
                    case "birch":
                        type = BlockSapling.BIRCH;
                        break;
                    case "jungle":
                        type = BlockSapling.JUNGLE;
                        break;
                    case "acacia":
                        type = BlockSapling.ACACIA;
                        break;
                    case "darkoak":
                        type = BlockSapling.DARK_OAK;
                        break;
                }
                ObjectTree.growTree(block.getLevel(), block.getFloorX(), block.getFloorY() + 1, block.getFloorZ(), new NukkitRandom(), type & 0x07);
                return true;
            } else {
                return Message.NEED_PLAYER.print(sender, "prefix:&7[&aTree&7]", 'c');
            }
            */
        }
        return true;
    }
}