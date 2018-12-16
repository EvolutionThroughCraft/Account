#### Clients

Since every service may not want / need to implement every client, these clients
do not have @Component annotation.

If a service would like to use a client, simply create an empty class extending
the client w/ the @Component annotation.
