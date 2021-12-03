director(chad).
admin(teresa).
admin(burt).
admin(edmond).
subscriber(eric).
subscriber(kathryn).
subscriber(mitch).
subscriber(cordell).
coach(cordell).
coach(wade).
coach(cordell, giraffes).
coach(wade, camels).

/* Page Update privilages */
canUpdatePage(Person) :- admin(Person).

/* director can act as admin */
canUpdatePage(Person) :- director(Person).

/* Team Page Update privilages */
canUpdateTeamPage(Person,giraffes) :- coach(Person, giraffes).
canUpdateTeamPage(Person,camels) :- coach(Person, camels).

/* Able to Read Pages */
canReadPage(Person) :- admin(Person).
canReadPage(Person) :- director(Person).
canReadPage(Person) :- subscriber(Person).
canReadPage(Person) :- coach(Person).
