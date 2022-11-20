package growup.growup;

import org.bukkit.*;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.block.data.Ageable;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerToggleSneakEvent;
import org.bukkit.material.Crops;

public class EventListner implements Listener {
    @EventHandler
    public void onSneaking(PlayerToggleSneakEvent e){
        Player p = e.getPlayer();
        Location l = p.getLocation();
        World w = p.getWorld();
        Block b = p.getLocation().getBlock().getRelative(BlockFace.UP);
        Location pl = l.add(0,2,0);

        if(b.getBlockData() instanceof Ageable){
            Ageable age = (Ageable)b.getBlockData();
            if(age.getAge() < age.getMaximumAge()){
                age.setAge(age.getAge() + 1);
                b.setBlockData(age);
                w.spawnParticle(Particle.COMPOSTER,pl,10,1,1,1);
                w.playSound(l,Sound.BLOCK_COMPOSTER_FILL_SUCCESS,1,1);
                /*
                Bukkit.broadcastMessage("名前"+p.getName() + "l座標："+l);
                Bukkit.broadcastMessage("名前"+p.getName() + "pl座標："+pl);

                 */
            }

        }
    }

    /*
    @EventHandler
    public void onClickEvent(PlayerInteractEvent e){
        Player p = e.getPlayer();
        if(p.getInventory().getItemInMainHand().getType() == Material.STICK){
            ConsoleCommandSender console = Bukkit.getServer().getConsoleSender();
            String command = "tp " + p.getName() + " az_aka";
            Bukkit.dispatchCommand(console, command);
        }
    }

     */

}
