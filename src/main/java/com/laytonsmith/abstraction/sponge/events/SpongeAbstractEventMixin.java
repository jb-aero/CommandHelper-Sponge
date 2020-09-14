package com.laytonsmith.abstraction.sponge.events;

import com.laytonsmith.core.constructs.CString;
import com.laytonsmith.core.constructs.Target;
import com.laytonsmith.core.events.AbstractEvent;
import com.laytonsmith.core.events.BindableEvent;
import com.laytonsmith.core.events.EventMixinInterface;
import com.laytonsmith.core.exceptions.EventException;
import com.laytonsmith.core.natives.interfaces.Mixed;
import org.spongepowered.api.event.Cancellable;

import java.util.HashMap;
import java.util.Map;

public class SpongeAbstractEventMixin implements EventMixinInterface {

	AbstractEvent mySuper;

	public SpongeAbstractEventMixin(AbstractEvent mySuper) {
		this.mySuper = mySuper;
	}

	@Override
	public void cancel(BindableEvent bindableEvent, boolean state) {
		if (bindableEvent._GetObject() instanceof Cancellable) {
			((Cancellable) bindableEvent._GetObject()).setCancelled(state);
		}
	}

	@Override
	public boolean isCancellable(BindableEvent bindableEvent) {
		return bindableEvent._GetObject() instanceof Cancellable;
	}

	@Override
	public Map<String, Mixed> evaluate_helper(BindableEvent bindableEvent) throws EventException {
		Map<String, Mixed> map = new HashMap<>();
		map.put("event_type", new CString(mySuper.getName(), Target.UNKNOWN));
		return map;
	}

	@Override
	public void manualTrigger(BindableEvent bindableEvent) {

	}

	@Override
	public boolean isCancelled(BindableEvent bindableEvent) {
		if (bindableEvent._GetObject() instanceof Cancellable) {
			return ((Cancellable) bindableEvent._GetObject()).isCancelled();
		} else {
			return false;
		}
	}
}
