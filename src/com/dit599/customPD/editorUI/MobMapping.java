package com.dit599.customPD.editorUI;

import java.util.ArrayList;
import java.util.List;

import com.dit599.customPD.actors.mobs.*;

public abstract class MobMapping {
	private static List<Class<? extends Mob>> mobsclasslist = null;
	private static List<String> mobsnamelist = null;

	public static void mobMappingInit() {
		mobsclasslist = new ArrayList<Class<? extends Mob>>();
		mobsclasslist.add(Rat.class);
		mobsclasslist.add(Albino.class);
		mobsclasslist.add(Gnoll.class);
		mobsclasslist.add(Crab.class);
		mobsclasslist.add(Swarm.class);
		mobsclasslist.add(Skeleton.class);
		mobsclasslist.add(Thief.class);
		mobsclasslist.add(Bandit.class);
		mobsclasslist.add(Shaman.class);
		mobsclasslist.add(Bat.class);
		mobsclasslist.add(Brute.class);
		mobsclasslist.add(Shielded.class);
		mobsclasslist.add(Spinner.class);
		mobsclasslist.add(Elemental.class);
		mobsclasslist.add(Monk.class);
		mobsclasslist.add(Senior.class);
		mobsclasslist.add(Warlock.class);
		mobsclasslist.add(Golem.class);
		mobsclasslist.add(Succubus.class);
		mobsclasslist.add(Eye.class);
		mobsclasslist.add(Scorpio.class);
		mobsclasslist.add(Acidic.class);
		//mobsclasslist.add(DM300.class);
		//mobsclasslist.add(Goo.class);
		//mobsclasslist.add(King.class);
		//mobsclasslist.add(Piranha.class);
		//mobsclasslist.add(Statue.class);
		//mobsclasslist.add(Tengu.class);
		//mobsclasslist.add(Wraith.class);
		//mobsclasslist.add(Yog.class);

		mobsnamelist = new ArrayList<String>();
		mobsnamelist.add("Rat");
		mobsnamelist.add("Albino");
		mobsnamelist.add("Gnoll");
		mobsnamelist.add("Crab");
		mobsnamelist.add("Swarm");
		mobsnamelist.add("Skeleton");
		mobsnamelist.add("Thief");
		mobsnamelist.add("Bandit");
		mobsnamelist.add("Shaman");
		mobsnamelist.add("Bat");
		mobsnamelist.add("Brute");
		mobsnamelist.add("Shielded");
		mobsnamelist.add("Spinner");
		mobsnamelist.add("Elemental");
		mobsnamelist.add("Monk");
		mobsnamelist.add("Senior");
		mobsnamelist.add("Warlock");
		mobsnamelist.add("Golem");
		mobsnamelist.add("Succubus");
		mobsnamelist.add("Eye");
		mobsnamelist.add("Scorpio");
		mobsnamelist.add("Acidic");
		//mobsnamelist.add("DM300");
		//mobsnamelist.add("Goo");
		//mobsnamelist.add("King");
		//mobsnamelist.add("Piranha");
		//mobsnamelist.add("Statue");
		//mobsnamelist.add("Tengu");
		//mobsnamelist.add("Wraith");
		//mobsnamelist.add("Yog");
		
		

	}

	public static String getMobName(Class<? extends Mob> mob) {
		for(int i=0;i<mobsclasslist.size();i++)
		 {
			if(mobsclasslist.get(i).getName().equals(mob.getName()))
			{
				return mobsnamelist.get(i);
			}
		 }
		return null;
	}
	public static Class<? extends Mob> getMobClass(String mobname) {
		for(int i=0;i<mobsnamelist.size();i++)
		 {
			if(mobsnamelist.get(i).equals(mobname))
			{
				return mobsclasslist.get(i);
			}
		 }
		return null;
	}
}