package com.ojbk.portalfix;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.*;
import org.bukkit.event.*;
import org.bukkit.block.*;
import org.bukkit.Material;

public class Mylist implements Listener {
	public void onJoin(org.bukkit.event.player.PlayerJoinEvent cp)  {
		Player jpl = cp.getPlayer() ;
		String PlayerName = jpl.getDisplayName() ;
		System.out.println( PlayerName + "joined the game, start to see his or her block." );
		Location k = jpl.getLocation() ; //������a����m
		double x = k.getX() ;
		double y = k.getY() ;
		double z = k.getZ() ;
		World w = k.getWorld() ;
		Block block = w.getBlockAt(k) ;
		if (block.getType().equals(Material.PORTAL)) {
			System.out.println( PlayerName + "'s block is conform to portal start to judge." );
		}
		else
		{
			return;
		}
		//�}�l�P�_
		//�P�_X��V
		int xx = (int)x; int yy = (int)y; int zz = (int)z ;
		System.out.println( xx + " " + yy + " " + zz);
		while (1 == 1) {
			Block b = w.getBlockAt(xx, yy, zz);
			System.out.println( xx + " " + yy + " " + zz);
			if ( b.getType().equals(Material.OBSIDIAN)) {
				//�ҧP�_����������`��
				break;
			}
			if ( yy >= 127 ) {
				//����X��
				System.out.println( "�j��h�X�`��" );
				return;
			}
			yy++;
		}
		Block setb = w.getBlockAt(xx, yy + 1, zz);
		Block jdb2 = w.getBlockAt(xx, yy + 2, zz);
		if( jdb2.getType().equals(Material.AIR) != true ) {
			//�Y���W��������O�Ů�
			jdb2.setType(Material.AIR);
			//�]�m���Ů�
		}
		Location toooo = new Location( w , xx , yy+1 , zz );
		jpl.teleport(toooo);
	}

}
