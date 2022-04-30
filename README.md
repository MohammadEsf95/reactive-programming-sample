This project is a simple rest with reactive spring

We have only a person model, which has only name property. When the application starts, 3 models are added to the in-memory database and we can
do the crud operations on them. My next challenge is to add proper logging, exception handling, using dtos instead of the object, add a new model
and try to create relations between models.

This application uses java11, h2 as database, spring webflux, r2dbc.
