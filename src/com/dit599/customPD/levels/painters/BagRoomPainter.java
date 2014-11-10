/*
 * CustomPD
 * Copyright (C) 2014 CustomPD team
 * This is a modification of source code from: 
 * Pixel Dungeon
 * Copyright (C) 2012-2014 Oleg Dolya
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program. If not, see <http://www.gnu.org/licenses/>
*/
package com.dit599.customPD.levels.painters;

import com.dit599.customPD.items.Generator;
import com.dit599.customPD.items.Item;
import com.dit599.customPD.items.bags.ScrollHolder;
import com.dit599.customPD.items.bags.SeedPouch;
import com.dit599.customPD.items.potions.PotionOfLiquidFlame;
import com.dit599.customPD.levels.Level;
import com.dit599.customPD.levels.Room;
import com.dit599.customPD.levels.Terrain;
import com.watabou.utils.Random;

public class BagRoomPainter extends Painter {

	public static void paint( Level level, Room room ) {
		
		final int floor = Terrain.EMPTY_SP;
		Item [] bags = {
				new SeedPouch(),
				new ScrollHolder()
		};
		
		fill( level, room, Terrain.WALL );
		fill( level, room, 1, floor );
		set( level, room.center(), Terrain.SIGN );
		
		for (int i=0; i < 2; i++) { 
			int pos;
			do {
				pos = room.random();
			} while (level.map[pos] != floor);
			level.drop(bags[i], pos );
		}
		
		room.entrance().set( Room.Door.Type.BARRICADE );
		level.addItemToSpawn( new PotionOfLiquidFlame() );
	}
	public static String tip() {
		return "This room contains bags for your scrolls and seeds! These bags extend your inventory with " +
				"additional tabs, where items of the specific type will be automatically placed. This also " +
				"increases the amount of items you can carry.";
	}
	public static String prompt() {
		return "Bag Storage";
	}
}