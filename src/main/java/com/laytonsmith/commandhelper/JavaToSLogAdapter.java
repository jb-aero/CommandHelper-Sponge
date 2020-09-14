package com.laytonsmith.commandhelper;

import org.slf4j.Logger;

import java.util.function.Supplier;
import java.util.logging.Level;

public class JavaToSLogAdapter extends java.util.logging.Logger {

	protected JavaToSLogAdapter(Logger logger) {
		super(logger.getName(), null);
		this.logger = logger;
	}

	private Logger logger;

	@Override
	public void severe(Supplier<String> msgSupplier) {
		logger.error(msgSupplier.get());
	}

	@Override
	public void warning(Supplier<String> msgSupplier) {
		logger.warn(msgSupplier.get());
	}

	@Override
	public void info(Supplier<String> msgSupplier) {
		logger.info(msgSupplier.get());
	}

	@Override
	public void fine(Supplier<String> msgSupplier) {
		logger.debug(msgSupplier.get());
	}

	@Override
	public void finest(Supplier<String> msgSupplier) {
		logger.trace(msgSupplier.get());
	}

	@Override
	public void log(Level level, Supplier<String> msgSupplier) {
		log(level, msgSupplier.get());
	}

	@Override
	public void log(Level level, String msg) {
		if (level != null) {
			if (Level.FINEST.equals(level)) {
				logger.trace(msg);
			} else if (Level.FINE.equals(level)) {
				logger.debug(msg);
			} else if (Level.INFO.equals(level)) {
				logger.info(msg);
			} else if (Level.WARNING.equals(level)) {
				logger.warn(msg);
			} else if (Level.SEVERE.equals(level)) {
				logger.error(msg);
			} else {
				logger.warn("Missing logger level {}. Message: {}", level.getName(), msg);
			}
		}
	}

	@Override
	public void log(Level level, String msg, Object[] params) {
		if (level != null) {
			if (Level.FINEST.equals(level)) {
				logger.trace(msg, params);
			} else if (Level.FINE.equals(level)) {
				logger.debug(msg, params);
			} else if (Level.INFO.equals(level)) {
				logger.info(msg, params);
			} else if (Level.WARNING.equals(level)) {
				logger.warn(msg, params);
			} else if (Level.SEVERE.equals(level)) {
				logger.error(msg, params);
			} else {
				logger.warn("Missing logger level {}. Message: {}", level.getName(), msg);
			}
		}
	}

	@Override
	public void log(Level level, String msg, Throwable thrown) {
		if (level != null) {
			if (Level.FINEST.equals(level)) {
				logger.trace(msg, thrown);
			} else if (Level.FINE.equals(level)) {
				logger.debug(msg, thrown);
			} else if (Level.INFO.equals(level)) {
				logger.info(msg, thrown);
			} else if (Level.WARNING.equals(level)) {
				logger.warn(msg, thrown);
			} else if (Level.SEVERE.equals(level)) {
				logger.error(msg, thrown);
			} else {
				logger.warn("Missing logger level {}. Message: {}", level.getName(), msg);
			}
		}
	}
}
