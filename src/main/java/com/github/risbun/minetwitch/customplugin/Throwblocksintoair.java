package com.github.risbun.minetwitch.customplugin;

import com.github.risbun.minetwitch.interfaces.CustomPlugin;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.FallingBlock;
import org.bukkit.entity.Player;
import org.bukkit.util.Vector;

import java.util.Objects;

public class Throwblocksintoair implements CustomPlugin {
    @Override
    public void run() {
        for (Player p : Bukkit.getOnlinePlayers()) {

            Block target = p.getLocation().getBlock().getRelative(BlockFace.DOWN);

            for (int y = 0; y < 5; y++) {
                for (int x = 0; x < 3; x++) {
                    for (int z = 0; z < 3; z++) {
                        Block b = target.getLocation().add(x, (y * -1), z).getBlock();
                        FallingBlock fb = Objects.requireNonNull(b.getLocation().getWorld()).spawnFallingBlock(b.getLocation().subtract(new Vector(-0.5, 0, -0.5)), b.getBlockData());

                        b.setType(Material.AIR);

                        fb.setVelocity(new Vector(0, 2, 0));
                    }
                }
            }
        }
    }

    @Override
    public void revert() {

    }
}
