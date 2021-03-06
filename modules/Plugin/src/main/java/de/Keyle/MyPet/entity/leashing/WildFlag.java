/*
 * This file is part of MyPet
 *
 * Copyright © 2011-2019 Keyle
 * MyPet is licensed under the GNU Lesser General Public License.
 *
 * MyPet is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * MyPet is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program. If not, see <http://www.gnu.org/licenses/>.
 */

package de.Keyle.MyPet.entity.leashing;

import de.Keyle.MyPet.api.entity.leashing.LeashFlag;
import de.Keyle.MyPet.api.entity.leashing.LeashFlagName;
import de.Keyle.MyPet.api.util.configuration.settings.Settings;
import de.Keyle.MyPet.api.util.locale.Translation;
import org.bukkit.entity.*;

@LeashFlagName("Wild")
public class WildFlag implements LeashFlag {
    @Override
    public boolean check(Player player, LivingEntity entity, double damage, Settings settings) {
        if (entity instanceof IronGolem) {
            return !((IronGolem) entity).isPlayerCreated();
        } else if (entity instanceof Horse) {
            return !((Horse) entity).isTamed();
        } else if (entity instanceof Tameable) {
            return !((Tameable) entity).isTamed();
        }
        return true;
    }

    @Override
    public String getMissingMessage(Player player, LivingEntity entity, double damage, Settings settings) {
        return Translation.getString("Message.Command.CaptureHelper.Wild", player);
    }
}
