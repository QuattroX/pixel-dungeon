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
package com.dit599.customPD.scenes;

import java.nio.FloatBuffer;

import com.dit599.customPD.Assets;
import com.dit599.customPD.Badges;
import com.dit599.customPD.Dungeon;
import com.dit599.customPD.actors.hero.HeroClass;
import com.dit599.customPD.items.Item;
import com.dit599.customPD.ui.Archs;
import com.dit599.customPD.ui.RedButton;
import com.watabou.gltextures.Gradient;
import com.watabou.gltextures.SmartTexture;
import com.watabou.glwrap.Matrix;
import com.watabou.glwrap.Quad;
import com.watabou.input.Touchscreen.Touch;
import com.watabou.noosa.Camera;
import com.watabou.noosa.ColorBlock;
import com.watabou.noosa.Game;
import com.watabou.noosa.Group;
import com.watabou.noosa.Image;
import com.watabou.noosa.MovieClip;
import com.watabou.noosa.NoosaScript;
import com.watabou.noosa.TextureFilm;
import com.watabou.noosa.TouchArea;
import com.watabou.noosa.Visual;
import com.watabou.noosa.audio.Music;
import com.watabou.utils.Point;
import com.watabou.utils.Random;

public class TutorialEndScene extends PixelScene {
	
	private static final int WIDTH	= 80;
	private static final int HEIGHT	= 112;
	private Image a;
	
	private Camera viewport;
	@Override
	public void create() {
		
		super.create();
		
		Music.INSTANCE.play( Assets.HAPPY, true );
		Music.INSTANCE.volume( 1f );
		
		uiCamera.visible = false;
		
		int w = Camera.main.width;
		int h = Camera.main.height;
		
		Archs archs = new Archs();
		archs.reversed = true;
		archs.setSize( w, h );
		add( archs );
		
		float vx = align( (w - WIDTH) / 2 );
		float vy = align( (h - HEIGHT) / 2 );
		
		Point s = Camera.main.cameraToScreen( vx, vy );
		viewport = new Camera( s.x, s.y, WIDTH, HEIGHT, defaultZoom );
		Camera.add( viewport );
		
		Group window = new Group();
		window.camera = viewport;
		add( window );
		

		a = new Image( Dungeon.hero.heroClass );
		a.frame( HeroClass.ROGUE.ordinal() * 24, 0, 24, 28 );
		a.scale.set( 3 );
		a.x = PixelScene.align( (WIDTH - a.width) / 6 );
		a.y = PixelScene.align(HEIGHT - a.height());

		a.scale.set(3);
		window.add( a );

		Image frame = new Image( Assets.SURFACE );
		frame.frame( 0, 0, 88, 125 );
		frame.x = vx - 4;
		frame.y = vy - 9;
		
		RedButton  proceed = new RedButton( "Tutorial Complete!" ) {
			protected void onClick() {
				Game.switchScene( TitleScene.class );
			}
		};
		proceed.setSize( WIDTH - 10, 20 );
		proceed.setPos( 5 + frame.x + 4, frame.y + frame.height + 4 );
		add( proceed );
		
		fadeIn();
	}
	
	@Override
	public void destroy() {
		Badges.saveGlobal();
		
		Camera.remove( viewport );
		super.destroy();
	}
	
	@Override
	protected void onBackPressed() {
	}
}
