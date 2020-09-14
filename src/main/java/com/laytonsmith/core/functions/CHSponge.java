package com.laytonsmith.core.functions;

import com.laytonsmith.PureUtilities.SimpleVersion;
import com.laytonsmith.PureUtilities.Version;
import com.laytonsmith.annotations.api;
import com.laytonsmith.core.constructs.CDouble;
import com.laytonsmith.core.constructs.Construct;
import com.laytonsmith.core.constructs.Target;
import com.laytonsmith.core.environments.Environment;
import com.laytonsmith.core.exceptions.CRE.CREThrowable;
import com.laytonsmith.core.exceptions.ConfigRuntimeException;
import com.laytonsmith.core.natives.interfaces.Mixed;
import org.spongepowered.api.Sponge;

public class CHSponge {

	@api
	public static class get_tps extends AbstractFunction {

		@Override
		public Class<? extends CREThrowable>[] thrown() {
			return new Class[0];
		}

		@Override
		public boolean isRestricted() {
			return false;
		}

		@Override
		public Boolean runAsync() {
			return false;
		}

		@Override
		public Construct exec(Target t, Environment env, Mixed... args) throws ConfigRuntimeException {
			return new CDouble(Sponge.getServer().getTicksPerSecond(), t);
		}

		@Override
		public String getName() {
			return this.getClass().getSimpleName();
		}

		@Override
		public Integer[] numArgs() {
			return new Integer[0];
		}

		@Override
		public String docs() {
			return "double {} Returns the current ticks per second.";
		}

		@Override
		public Version since() {
			return new SimpleVersion(0, 1, 0);
		}
	}
}
