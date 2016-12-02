package io.github.nickdex.pasteit.interactor.message;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import io.github.nickdex.pasteit.domain.Messenger;
import io.github.nickdex.pasteit.domain.model.ClipItem;
import io.github.nickdex.pasteit.domain.repository.MessageRepository;
import io.github.nickdex.pasteit.interactor.UseCase;
import rx.Observable;
import rx.Scheduler;

/**
 * Fetches message for requested devices from repository
 *
 * @author Nikhil Warke
 *         Created on 2/12/16.
 */

public class GetMessages extends UseCase<String, List<ClipItem>, MessageRepository> {

    @Inject
    public GetMessages(MessageRepository repository,
                       Messenger messenger,
                       @Named("Thread") Scheduler threadScheduler,
                       @Named("PostExecution") Scheduler postExecutionScheduler) {
        super(repository, messenger, threadScheduler, postExecutionScheduler);
    }

    @Override
    public Observable<List<ClipItem>> buildObservable(String device) {
        return repository.getMessages(device, messenger);
    }
}
