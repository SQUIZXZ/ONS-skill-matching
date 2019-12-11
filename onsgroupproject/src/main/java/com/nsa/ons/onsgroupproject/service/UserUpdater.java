package com.nsa.ons.onsgroupproject.service;

import com.nsa.ons.onsgroupproject.service.events.UserUpdated;

public interface UserUpdater {
    public void updateUser (UserUpdated userUpdated);
}
