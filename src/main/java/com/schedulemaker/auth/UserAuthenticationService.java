package com.schedulemaker.auth;

import com.google.common.collect.ImmutableMap;

import com.schedulemaker.auth.date.DateService;
import com.schedulemaker.entities.User;
import com.schedulemaker.services.UserService;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import lombok.experimental.FieldDefaults;
import org.joda.time.DateTime;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;

import static lombok.AccessLevel.PACKAGE;
import static lombok.AccessLevel.PRIVATE;

@Service
@AllArgsConstructor(access = PACKAGE)
@FieldDefaults(level = PRIVATE, makeFinal = true)
public final class UserAuthenticationService {
    @NonNull
    TokenService tokens;
    @NonNull
    UserService userService;
    @NonNull
    DateService dateService;

    /**
     * Logs in with the given {@code username} and {@code password}.
     *
     * @param username
     * @param password
     * @return an {@link Optional} of a user when login succeeds
     */
    public Optional<String> login(final String username, final String password) {
        return userService
                .findByUsername(username)
                .filter(user -> Objects.equals(password, user.getPassword()))
                .map(user -> tokens.expiring(ImmutableMap.of("username", username)));
    }

    /**
     * Finds a user by its dao-key.
     *
     * @param token user dao key
     * @return
     */
    public Optional<User> findByToken(final String token) {
        return Optional
                .of(tokens.verify(token))
                .map(map -> map.get("username"))
                .flatMap(userService::findByUsername);
    }

}