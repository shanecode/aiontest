/*
 * This file is part of aion-unique <aion-unique.org>.
 *
 *  aion-unique is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *
 *  aion-unique is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *  along with aion-unique.  If not, see <http://www.gnu.org/licenses/>.
 */
package com.aionemu.gameserver.skillengine.effect;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;

import com.aionemu.commons.utils.Rnd;
import com.aionemu.gameserver.controllers.attack.AttackUtil;
import com.aionemu.gameserver.skillengine.model.Effect;

/**
 * @author ATracer
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SignetBurstEffect")
public class SignetBurstEffect extends DamageEffect {

	@XmlAttribute
	protected int signetlvl;
	@XmlAttribute
	protected String signet;

	@Override
	public void calculate(Effect effect) {
		//TODO
		Effect signetEffect = effect.getEffected().getEffectController().getAnormalEffect(signet);
		if (signetEffect == null)
			return;

		int level = signetEffect.getSkillLevel();
		effect.setSignetBurstedCount(level);
		int valueWithDelta = value + delta * effect.getSkillLevel();
		
		switch (level) {
			case 1:
				valueWithDelta *= 0.2f;
				break;
			case 2:
				valueWithDelta *= 0.5f;
				break;
			case 3:
				valueWithDelta *= 1.0f;
				break;
			case 4:
				valueWithDelta *= 1.2f;
				break;
			case 5:
				valueWithDelta *= 1.5f;
				break;
		}
		
		AttackUtil.calculateMagicalSkillResult(effect, valueWithDelta, 0, getElement());

		//TODO do something about it
		if (level >= 3)
			effect.addSucessEffect(this);
		else {
			if (Rnd.get(100) <= 3)
				effect.addSucessEffect(this);
		}
		signetEffect.endEffect();
	}

}
