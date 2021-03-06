/*
 * Copyright © 2016 Nikhil Warke
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package io.github.nickdex.pasteit.framework.data.store.firebase;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.Query;

import javax.inject.Inject;

import io.github.nickdex.pasteit.framework.data.entity.UserEntity;
import io.github.nickdex.pasteit.framework.data.store.UserEntityStore;
import rx.Observable;

/**
 * A class that contains implementation of {@link UserEntityStore}.
 */
public class FirebaseUserEntityStore extends FirebaseEntityStore implements UserEntityStore {

    private static final String ROOT_USERS = "users";

    @Inject
    public FirebaseUserEntityStore() {
    }

    @Override
    public Observable<String> createUserIfNotExists(UserEntity userEntity) {
        DatabaseReference reference = database.child(ROOT_USERS).child(userEntity.getId());
        return createIfNotExists(reference, userEntity, userEntity.getId()).doOnNext(s -> updatePhone(reference, userEntity));
    }

    @Override
    public Observable<UserEntity> getUser(String userId) {
        Query query = database.child(ROOT_USERS).child(ROOT_USERS).child(userId);
        return get(query, UserEntity.class, true);
    }

    /**
     * Sets the phone property of {@link UserEntity} to true after createIfNotExists runs to create user.
     *
     * @param reference  {@link DatabaseReference} of the path to userEntity.
     * @param userEntity {@link UserEntity} that is to be updated.
     */
    private void updatePhone(DatabaseReference reference, UserEntity userEntity) {
        userEntity.setPhone(true);
        update(reference, userEntity, userEntity.getId()).subscribe();
    }

}
