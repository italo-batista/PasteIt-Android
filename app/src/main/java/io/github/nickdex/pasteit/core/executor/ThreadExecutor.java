package io.github.nickdex.pasteit.core.executor;

import java.util.concurrent.Executor;

/**
 * Executor implementation can be based on different frameworks or techniques of asynchronous
 * execution, but every implementation will execute UseCases out of the UI thread.
 */
public interface ThreadExecutor extends Executor {
}
