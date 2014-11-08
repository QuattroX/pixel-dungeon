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
package com.dit599.customPD.items.potions;

import com.dit599.customPD.Assets;
import com.dit599.customPD.Dungeon;
import com.dit599.customPD.actors.blobs.Blob;
import com.dit599.customPD.actors.blobs.Fire;
import com.dit599.customPD.actors.hero.Hero;
import com.dit599.customPD.scenes.GameScene;
import com.dit599.customPD.windows.WndStory;
import com.watabou.noosa.audio.Sample;

public class PotionOfLiquidFlame extends Potion {

	{
		name = "Potion of Liquid Flame";
	}
	
	@Override
	protected void shatter( int cell ) {
		
		setKnown();
		
		splash( cell );
		Sample.INSTANCE.play( Assets.SND_SHATTER );
		
		Fire fire = Blob.seed( cell, 2, Fire.class );
		GameScene.add( fire );
	}
	
	@Override
	public String desc() {
		return
			"This flask contains an unstable compound which will burst " +
			"violently into flame upon exposure to open air.";
	}
	
	@Override
	public int price() {
		return isKnown() ? 40 * quantity : super.price();
	}
	@Override
	public boolean doPickUp(Hero hero){
		boolean b = super.doPickUp(hero);
		if(b && Dungeon.isTutorial && !Dungeon.firePrompt){
			Dungeon.firePrompt = true;
			WndStory.showChapter("You have found an item that creates fire! Now look for a pile of wood or a " +
					"lone bookcase to burn down.");
		}
		return b;
	}
}
