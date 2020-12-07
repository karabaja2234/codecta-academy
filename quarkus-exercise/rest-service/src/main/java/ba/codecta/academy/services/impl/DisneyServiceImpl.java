package ba.codecta.academy.services.impl;

import ba.codecta.academy.model.WelcomeMessage;
import ba.codecta.academy.services.DisneyService;
import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class DisneyServiceImpl implements DisneyService {
    @Override
    public WelcomeMessage getWelcomeMessage() {
        return new WelcomeMessage("DisneyWorld", "Welcome to our theme parks!", "From 9 am to 3 pm");
    }
}
