package com.natamus.noanimaltemptdelay.neoforge.mixin;

import net.minecraft.world.entity.ai.goal.TemptGoal;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value = TemptGoal.class, priority = 1001)
public class TemptGoalMixin {
	@Shadow private int calmDown;

	@Inject(method = "stop()V", at = @At(value = "TAIL"))
	public void stop(CallbackInfo ci) {
		this.calmDown = 0;
	}
}
